package com.codecrane.dbr.enforcement.controller;

import com.codecrane.core.Constants;
import com.codecrane.core.power.entity.PowerUser;
import com.codecrane.core.util.ExcelWriter;
import com.codecrane.core.web.RequestUtils;
import com.codecrane.dbr.extract.entity.ExecutorRandom;
import com.codecrane.dbr.extract.service.ExecutorRandomService;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.List;

/**
 * 排班表控制器
 * Created by crane on 16/6/3.
 */
@Controller
@RequestMapping("/scheduletable")
public class ScheduleTableController {

    @Autowired
    private ExecutorRandomService executorRandomService;

    /**
     * 企业随机抽取纪录信息管理主页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/main")
    public String companyRandomListPage(Model model) {
        // 查询当前用户可选管理机构
        PowerUser user = (PowerUser) SecurityUtils.getSubject().getSession().getAttribute(Constants.CURRENT_USER_SESSION);
        if (null != user) {
            Long groupId = user.getGroupId();
            model.addAttribute("groupId", groupId);
        }

        return "/dbr/enforcement/scheduletable/main";
    }

    /**
     * 日历排班表
     *
     * @return
     */
    @RequestMapping("/calendarmode")
    public String calendarmode(Model model) {

        PowerUser user = (PowerUser) SecurityUtils.getSubject().getSession().getAttribute(Constants.CURRENT_USER_SESSION);
        if (null != user) {
            Long groupId = user.getGroupId();
            model.addAttribute("groupId", groupId);
        }

        return "/dbr/enforcement/scheduletable/calendar_mode";
    }


    /**
     * 文件导出下载
     *
     * @return
     */
    @RequestMapping("/export")
    public void downFile(HttpServletRequest request, HttpServletResponse response, ExecutorRandom executorRandom,
                         @RequestParam(value = "cols", defaultValue = "") String[] excelCols) throws IOException {

        String path = request.getSession().getServletContext().getRealPath("/export");

        if (null != excelCols && excelCols.length > 0) {

            List<ExecutorRandom> executorRandoms = executorRandomService.findByCndAndGroupedWithFeedback(executorRandom);

            ExcelWriter excelWriter = new ExcelWriter(ExcelWriter.ExcelType.XLS);
            excelWriter.createRow();
            int cellIndex = 0;
            boolean hasRecordNo = ArrayUtils.contains(excelCols,"recordNo");
            boolean hasExecutorName = ArrayUtils.contains(excelCols,"executorName");
            boolean hasCompanyName = ArrayUtils.contains(excelCols,"companyName");
            if (hasRecordNo){
                excelWriter.setCell(cellIndex, "编号");
                cellIndex++;
            }

            if (hasExecutorName){
                excelWriter.setCell(cellIndex, "姓名");
                cellIndex++;
            }

            if (hasCompanyName){
                excelWriter.setCell(cellIndex, "企业名称");
                cellIndex++;
            }

            if (null != executorRandoms) {
                for (ExecutorRandom executor : executorRandoms) {
                    excelWriter.createRow();
                    int tempCellIndex = 0;
                    if (hasRecordNo){
                        excelWriter.setCell(tempCellIndex, executor.getRecordNo());
                        tempCellIndex++;
                    }
                    if (hasExecutorName){
                        excelWriter.setCell(tempCellIndex, executor.getExecutorName());
                        tempCellIndex++;
                    }
                    if (hasCompanyName){
                        excelWriter.setCell(tempCellIndex, executor.getCompanyName());
                        tempCellIndex++;
                    }
                }
            }
            String tempFileName = SystemUtils.FILE_SEPARATOR + System.currentTimeMillis() + ".xls";
            excelWriter.export(path + tempFileName);

            //默认文件名称
            String downFileName = "排班表.xls";

            File file = new File(path + tempFileName);

            if (!file.exists()) {
                String errorMessage = "抱歉,文件不存在!";
                OutputStream outputStream = response.getOutputStream();
                outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
                outputStream.close();
                return;
            }

            response.setContentType(MediaType.APPLICATION_OCTET_STREAM.toString());
            if (RequestUtils.isIE(request)) {//IE文件名特殊处理
                downFileName = URLEncoder.encode(downFileName, "UTF8");
            } else {
                downFileName = new String(downFileName.getBytes("UTF-8"), "ISO-8859-1");
            }
            response.setHeader("content-disposition", "attachment;filename=" + downFileName);
            response.setContentLength((int) file.length());
            InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
            FileCopyUtils.copy(inputStream, response.getOutputStream());
        }

    }


    /**
     * 加载event
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "calendarEvents", method = RequestMethod.POST)
    public List<ExecutorRandom> calendarEvents(ExecutorRandom executorRandom) {
        List<ExecutorRandom> executorRandomList = executorRandomService.findByCndWithGrouped(executorRandom);
        return executorRandomList;
    }


}
