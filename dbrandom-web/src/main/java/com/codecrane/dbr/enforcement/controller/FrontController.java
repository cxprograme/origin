package com.codecrane.dbr.enforcement.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.codecrane.core.web.Ajax;
import com.codecrane.core.web.AjaxReturn;
import com.codecrane.core.web.RequestUtils;
import com.codecrane.dbr.enforcement.entity.ExecuteFeedback;
import com.codecrane.dbr.enforcement.service.ExecuteFeedbackService;
import com.codecrane.dbr.extract.entity.ExecutorRandom;
import com.codecrane.dbr.extract.service.ExecutorRandomService;
import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.List;

/**
 * Created by crane on 16/6/27.
 */
@Slf4j
@Controller
@RequestMapping("/feedback")
public class FrontController {

    private static final String LOGIN_EXECUTOR_TAG = "CUTTENT_LOGIN_EXECUTOR";

    @Autowired
    private ExecuteFeedbackService executeFeedbackService;

    @Autowired
    private ExecutorRandomService executorRandomService;

    @Value("${app_upload_store_path}")
    private String uploadStorePath;

    /**
     * 执法反馈填报页面
     *
     * @param recordNo 纪录编号
     * @param model
     * @return
     */
    @RequestMapping("/fillpage")
    public String addExecuteFeedbackPage(@RequestParam(value = "rno", defaultValue = "") String recordNo, Model model,HttpServletRequest request) {

        //登录session判断
        ExecutorRandom random = (ExecutorRandom) request.getSession().getAttribute(LOGIN_EXECUTOR_TAG);
        if (null == random || !recordNo.equals(random.getRecordNo())) {
            return "redirect:/feedback/loginpage";
        }

        if (!Strings.isNullOrEmpty(recordNo)) {
            ExecutorRandom executorRandom = new ExecutorRandom();
            executorRandom.setRecordNo(recordNo);
            List<ExecutorRandom> executorRandoms = executorRandomService.findByCndWithGrouped(executorRandom);

            if (null != executorRandoms && executorRandoms.size() > 0) {
                model.addAttribute("executorRandom", executorRandoms.get(0));
            }

            //已经填过
            ExecuteFeedback feedback = new ExecuteFeedback();
            feedback.setPlanId(recordNo);
            List<ExecuteFeedback> feedbacks = executeFeedbackService.findByCnd(feedback);
            if (null != feedbacks && feedbacks.size() > 0) {
                model.addAttribute("feedback", feedbacks.get(0));
            }
        }

        return "/dbr/enforcement/executefeedback/front/fill";
    }

    /**
     * 执法人员登录页面
     *
     * @return
     */
    @RequestMapping(value = "/loginpage", method = RequestMethod.GET)
    public String executorLoginPage() {
        return "/dbr/enforcement/executefeedback/front/login";
    }

    /**
     * 执法人员登录
     *
     * @param recordNo 记录编号
     * @param mobile   执法人员手机号码
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public AjaxReturn executorLogin(@RequestParam(value = "recordno", defaultValue = "") String recordNo,
                                    @RequestParam(value = "mobile", defaultValue = "") String mobile, HttpServletRequest request) {

        AjaxReturn result = Ajax.fail().setMsg("登录失败！");
        if (!Strings.isNullOrEmpty(recordNo) && !Strings.isNullOrEmpty(mobile)) {
            ExecutorRandom executorRandom = executorRandomService.findByExecutor(mobile, recordNo);

            //存在记录
            if (null != executorRandom) {
                request.getSession().setAttribute(LOGIN_EXECUTOR_TAG, executorRandom);
                result.setOk(true).setData(recordNo).setMsg("登录成功");
            } else {
                result.setMsg("抱歉,找不到要填报的检查记录!");
            }
        }

        return result;
    }

    /**
     * 执法人员退出
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public AjaxReturn executorLogout(HttpServletRequest request){
        AjaxReturn result = Ajax.fail().setMsg("退出失败！");

        ExecutorRandom random = (ExecutorRandom) request.getSession().getAttribute(LOGIN_EXECUTOR_TAG);
        if( null != random ){
            request.getSession().removeAttribute(LOGIN_EXECUTOR_TAG);
            result.setOk(true).setMsg("退出成功");
        }

        return result;
    }


    /**
     * 保存执法反馈信息
     *
     * @param executeFeedback
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public AjaxReturn save(ExecuteFeedback executeFeedback, HttpServletRequest request) {
        AjaxReturn result = Ajax.fail().setMsg("保存失败！");

        ExecutorRandom random = (ExecutorRandom) request.getSession().getAttribute(LOGIN_EXECUTOR_TAG);
        if (null == random) {
            result.setMsg("尚未登录,请登录!");
        } else {
            if (null != executeFeedback && null != executeFeedback.getAttachFileJson()) {
                executeFeedback.setAttachFile(JSON.parseArray(executeFeedback.getAttachFileJson()));
            }
            if (null != executeFeedback && executeFeedbackService.save(executeFeedback) > 0) {
                result.setOk(true).setMsg("保存成功！");
            }
        }

        return result;
    }

    /**
     * 文件上传
     *
     * @param uploadFile
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public AjaxReturn uploadAttachFile(@RequestParam("feedbackfile") MultipartFile uploadFile) {
        AjaxReturn result = Ajax.fail();
        if (!uploadFile.isEmpty()) {

            JSONObject fileJson = new JSONObject();
            fileJson.put("fileRealName", uploadFile.getOriginalFilename());
            String fileSuffix = FilenameUtils.getExtension(uploadFile.getOriginalFilename());
            fileJson.put("fileSuffix", fileSuffix);
            fileJson.put("fileSize", uploadFile.getSize());
            fileJson.put("fileType", uploadFile.getContentType());

            String fileStoreName = System.currentTimeMillis() + String.valueOf(RandomUtils.nextInt(10000, 99999)) + "." + fileSuffix;
            fileJson.put("fileStoreName", fileStoreName);
            fileJson.put("fileStorePath", uploadStorePath);

            boolean isUploadOk = false;
            try {
                uploadFile.transferTo(new File(uploadStorePath + SystemUtils.FILE_SEPARATOR + fileStoreName));
                isUploadOk = true;
            } catch (IOException e) {
                log.error("upload feekback file error:{}", e.toString());
            }
            result.setOk(isUploadOk).setData(fileJson);
        }
        return result;
    }

    /**
     * 下载文件
     *
     * @param response
     * @param fileRealName
     */
    @ResponseBody
    @RequestMapping("/download")
    public void downAttachFile(HttpServletResponse response, HttpServletRequest request,
                               @RequestParam(value = "fname", defaultValue = "") String fileName,
                               @RequestParam(value = "frname", defaultValue = "") String fileRealName) throws IOException {
        File file = new File(uploadStorePath + fileName);

        if (file.isFile() && !file.exists() && StringUtils.isNotBlank(fileRealName)) {
            String errorMessage = "抱歉,文件不存在!";
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
            outputStream.close();
            return;
        }

        String mimeType = URLConnection.guessContentTypeFromName(file.getName());
        if (mimeType == null) {
            mimeType = MediaType.APPLICATION_OCTET_STREAM.toString();
        }

        response.setContentType(mimeType);
        if (RequestUtils.isIE(request)) {//IE文件名特殊处理
            fileRealName = URLEncoder.encode(fileRealName, "UTF8");
        } else {
            fileRealName = new String(fileRealName.getBytes("UTF-8"), "ISO-8859-1");
        }
        response.setHeader("content-disposition", "attachment;filename=" + fileRealName);
        response.setContentLength((int) file.length());
        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
        FileCopyUtils.copy(inputStream, response.getOutputStream());

    }
}
