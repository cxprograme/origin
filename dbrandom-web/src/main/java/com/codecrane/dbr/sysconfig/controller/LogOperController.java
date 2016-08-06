package com.codecrane.dbr.sysconfig.controller;

import com.codecrane.core.web.Ajax;
import com.codecrane.core.web.AjaxTableReturn;
import com.codecrane.dbr.sysconfig.entity.LogOperation;
import com.codecrane.dbr.sysconfig.service.LogOperationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;


/**
 *
 * 日志管理控制类
 * Created by cx on 16/6/15.
 */
@Controller
@RequestMapping("/log")
public class LogOperController {

    @Autowired
    private LogOperationService logOperationService;

    @RequestMapping("/main")
    public String main(Model modle){
        List<LogOperation> logOperations=logOperationService.findAll();
        HashSet<String> opTypes=new HashSet<>();

        for(LogOperation logOperation:logOperations){
            opTypes.add(logOperation.getOpType());
        }

/*        for(Iterator it = opTypes.iterator(); it.hasNext();){
            System.err.println(it.next());
        }*/
        modle.addAttribute("logOperations",opTypes);
        return "/dbr/sysconfig/log_operation/main";
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }


    /**
     * 分页查询节假日配置信息
     *
     * @param pagesize
     * @param start
     * @return
     */
    @ResponseBody
    @RequestMapping("/findall")
    @DateTimeFormat(style = "FF")
    public AjaxTableReturn findAllConfigHoliday(@RequestParam(value = "limit", defaultValue = "10") int pagesize,
                                                @RequestParam(value = "offset", defaultValue = "0") int start,LogOperation logOperation) {
        start = start > 0 ? start / pagesize + 1 : 1;
        PageHelper.startPage(start, pagesize);
        //System.err.println("opName:"+logOperation.getOpName()+",startTime:"+logOperation.getStartTime()+",endTime:"+logOperation.getEndTime());
        List<LogOperation> logOperationList=logOperationService.queryCnd(logOperation);
        PageInfo<LogOperation> page=new PageInfo<LogOperation>(logOperationList);
        return Ajax.tableDataOk(page.getTotal(), page.getList());
    }
}
