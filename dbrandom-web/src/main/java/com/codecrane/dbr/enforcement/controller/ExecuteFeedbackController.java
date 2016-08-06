package com.codecrane.dbr.enforcement.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.codecrane.core.Constants;
import com.codecrane.core.power.entity.PowerUser;
import com.codecrane.core.web.Ajax;
import com.codecrane.core.web.AjaxReturn;
import com.codecrane.core.web.AjaxTableReturn;
import com.codecrane.core.web.RequestUtils;
import com.codecrane.dbr.enforcement.entity.ExecuteFeedback;
import com.codecrane.dbr.enforcement.service.ExecuteFeedbackService;
import com.codecrane.dbr.extract.entity.ExecutorRandom;
import com.codecrane.dbr.extract.service.ExecutorRandomService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.apache.shiro.SecurityUtils;
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
 * 执法反馈信息 控制器
 *
 * @author Crane(hehebaiy@gmail.com)
 *         <br/>
 *         <br/>
 */
@Slf4j
@Controller
@RequestMapping("/execute/feedback")
public class ExecuteFeedbackController {

    @Autowired
    private ExecuteFeedbackService executeFeedbackService;

    @Autowired
    private ExecutorRandomService executorRandomService;

    @Value("${app_upload_store_path}")
    private String uploadStorePath;

    /**
     * 执法反馈信息管理主页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/main")
    public String executeFeedbackListPage(Model model) {
        // 查询当前用户可选管理机构
        PowerUser user = (PowerUser) SecurityUtils.getSubject().getSession().getAttribute(Constants.CURRENT_USER_SESSION);
        if (null != user) {
            Long groupId = user.getGroupId();
            model.addAttribute("groupId", groupId);
        }
        return "/dbr/enforcement/executefeedback/main";
    }

    /**
     * 新增执法反馈信息页面
     *
     * @param recordNo 纪录编号
     * @param model
     * @return
     */
    @RequestMapping("/addpage")
    public String addExecuteFeedbackPage(@RequestParam(value = "rno", defaultValue = "") String recordNo, Model model) {

        if (StringUtils.isNoneBlank(recordNo)) {
            ExecutorRandom executorRandom = new ExecutorRandom();
            executorRandom.setRecordNo(recordNo);
            List<ExecutorRandom> executorRandoms = executorRandomService.findByCndWithGrouped(executorRandom);

            if (null != executorRandoms && executorRandoms.size() > 0) {
                model.addAttribute("executorRandom", executorRandoms.get(0));
            }
        }

        return "/dbr/enforcement/executefeedback/add";
    }

    /**
     * 修改执法反馈信息页面
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/editpage")
    public String editExecuteFeedbackPage(@RequestParam("id") Integer id, Model model) {

        // 根据ID查询执法反馈信息
        ExecuteFeedback executeFeedback = executeFeedbackService.findById(id);

        // 将执法反馈信息返回到页面中
        model.addAttribute("executeFeedback", executeFeedback);

        return "/dbr/enforcement/executefeedback/edit";
    }

    /**
     * 查看执法反馈信息页面
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/detail")
    public String viewExecuteFeedbackPage(@RequestParam("id") Integer id, Model model) {

        // 根据ID查询执法反馈信息
        ExecuteFeedback executeFeedback = executeFeedbackService.findById(id);

        // 将执法反馈信息返回到页面中
        model.addAttribute("feedback", executeFeedback);

        return "/dbr/enforcement/executefeedback/detail";
    }

    /**
     * 分页查询执法反馈信息
     *
     * @param pagesize
     * @param start
     * @return
     */
    @ResponseBody
    @RequestMapping("/findtodo")
    public AjaxTableReturn findTodoFeedback(@RequestParam(value = "limit", defaultValue = "10") int pagesize,
                                            @RequestParam(value = "offset", defaultValue = "0") int start, ExecuteFeedback executeFeedback) {
        start = start > 0 ? start / pagesize + 1 : 1;
        PageHelper.startPage(start, pagesize);
        List<ExecuteFeedback> executeFeedbacks = executeFeedbackService.findTodoByCnd(executeFeedback);
        PageInfo<ExecuteFeedback> page = new PageInfo<>(executeFeedbacks);

        return Ajax.tableDataOk(page.getTotal(), page.getList());
    }

    /**
     * 分页查询执法反馈信息
     *
     * @param pagesize
     * @param start
     * @return
     */
    @ResponseBody
    @RequestMapping("/finddistribute")
    public AjaxTableReturn findDistributeFeedback(@RequestParam(value = "limit", defaultValue = "10") int pagesize,
                                                  @RequestParam(value = "offset", defaultValue = "0") int start, ExecuteFeedback executeFeedback) {
        start = start > 0 ? start / pagesize + 1 : 1;
        PageHelper.startPage(start, pagesize);
        List<ExecuteFeedback> executeFeedbacks = executeFeedbackService.findDistributeByCnd(executeFeedback);
        PageInfo<ExecuteFeedback> page = new PageInfo<>(executeFeedbacks);

        return Ajax.tableDataOk(page.getTotal(), page.getList());
    }

    /**
     * 分页查询执法反馈信息
     *
     * @param pagesize
     * @param start
     * @return
     */
    @ResponseBody
    @RequestMapping("/findwithrandom")
    public AjaxTableReturn findExecuteFeedbackWithRandom(@RequestParam(value = "limit", defaultValue = "10") int pagesize,
                                                         @RequestParam(value = "offset", defaultValue = "0") int start, ExecutorRandom executorRandom) {
        start = start > 0 ? start / pagesize + 1 : 1;
        PageHelper.startPage(start, pagesize);

        List<ExecutorRandom> executorRandoms = executorRandomService.findByCndAndGroupedWithFeedback(executorRandom);
        PageInfo<ExecutorRandom> page = new PageInfo<>(executorRandoms);

        return Ajax.tableDataOk(page.getTotal(), page.getList());
    }

    /**
     * 保存执法反馈信息
     *
     * @param executeFeedback
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public AjaxReturn save(ExecuteFeedback executeFeedback) {
        AjaxReturn result = Ajax.fail().setMsg("保存失败！");
        if (null != executeFeedback && null != executeFeedback.getAttachFileJson()) {
            executeFeedback.setAttachFile(JSON.parseArray(executeFeedback.getAttachFileJson()));
        }
        if (null != executeFeedback && executeFeedbackService.save(executeFeedback) > 0) {
            result.setOk(true).setMsg("保存成功！");
        }
        return result;
    }

    /**
     * 保存修改后的执法反馈信息
     *
     * @param executeFeedback
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/usave", method = RequestMethod.POST)
    public AjaxReturn updateSave(ExecuteFeedback executeFeedback) {
        AjaxReturn result = Ajax.fail().setMsg("修改失败！");
        if (null != executeFeedback && null != executeFeedback.getAttachFileJson()) {
            executeFeedback.setAttachFile(JSON.parseArray(executeFeedback.getAttachFileJson()));
        }
        if (null != executeFeedback && executeFeedbackService.modify(executeFeedback) > 0) {
            result.setOk(true).setMsg("修改成功！");
        }
        return result;
    }


    /**
     * 删除执法反馈信息
     *
     * @param ids 执法反馈信息编号
     * @return
     */
    @ResponseBody
    @RequestMapping("/delete")
    public AjaxReturn deleteByIds(@RequestParam("ids") Integer ids[]) {
        AjaxReturn result = Ajax.fail().setMsg("操作失败！");
        if (ids.length > 0 && executeFeedbackService.deleteByIds(ids) > 0) {
            result.setOk(true).setMsg("删除成功");
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

        String mimeType= URLConnection.guessContentTypeFromName(file.getName());
        if(mimeType==null){
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
