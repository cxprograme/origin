package com.codecrane.dbr.sysconfig.controller;

import com.alibaba.fastjson.JSONArray;
import com.codecrane.core.web.Ajax;
import com.codecrane.core.web.AjaxReturn;
import com.codecrane.core.web.AjaxTableReturn;
import com.codecrane.dbr.sysconfig.entity.ConfigHoliday;
import com.codecrane.dbr.sysconfig.service.ConfigHolidayService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 节假日配置信息 控制器
 *
 * @author Crane(hehebaiy@gmail.com)
 *         <br/>
 *         <br/>
 */
@Controller
@RequestMapping("/holiday")
public class ConfigHolidayController {

    @Autowired
    private ConfigHolidayService configHolidayService;

    /**
     * 节假日配置信息管理主页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/config")
    public String configHolidayListPage(Model model) {
        return "/dbr/sysconfig/holiday_config/config";
    }


    @RequestMapping("/main")
    public String configHolidayLists(Model model) {
        return "/dbr/sysconfig/holiday_config/main";
    }

    /**
     * 加载event
     *
     * @return
     */
    @RequestMapping(value = "calendarEvents",method = RequestMethod.POST)
    @ResponseBody
    public List<ConfigHoliday> calendarEvents(ConfigHoliday configHoliday) {
        List<ConfigHoliday>  configHolidayList=configHolidayService.findByDateRangeWithStatus(configHoliday);
        return configHolidayList;
    }


    /**
     * 新增节假日配置信息页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/add")
    public String addConfigHolidayPage(@RequestParam("selDate")  String selDate, Model model) {
        //将前台传入的字符创时间格式化为Date ,放入对象中,并且放到作用域中
        ConfigHoliday configHoliday = new ConfigHoliday();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            configHoliday.setHolidayDate(format.parse(selDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        model.addAttribute("configHoliday", configHoliday);
        return "/dbr/sysconfig/holiday_config/add";
    }

    /**
     * 修改节假日配置信息页面
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/editpage")
    public String editConfigHolidayPage(@RequestParam("id") Integer id, Model model) {

        // 根据ID查询节假日配置信息
        ConfigHoliday configHoliday = configHolidayService.findById(id);
        // 将节假日配置信息返回到页面中
        model.addAttribute("configHoliday", configHoliday);
        return "/dbr/sysconfig/holiday_config/edit";
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
    public AjaxTableReturn findAllConfigHoliday(@RequestParam(value = "limit", defaultValue = "10") int pagesize,
                                                @RequestParam(value = "offset", defaultValue = "0") int start) {
        start = start > 0 ? start / pagesize + 1 : 1;
        PageHelper.startPage(start, pagesize);
        List<ConfigHoliday> configHolidays = configHolidayService.findAllConfigHoliday();
        PageInfo<ConfigHoliday> page = new PageInfo<ConfigHoliday>(configHolidays);

        return Ajax.tableDataOk(page.getTotal(), page.getList());
    }

    /**
     * 保存节假日配置信息
     *
     * @param configHoliday
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public AjaxReturn save(ConfigHoliday configHoliday) {
        //configHoliday.setHolidayName("休息日");
        AjaxReturn result = Ajax.fail().setMsg("保存失败！");
        if (null != configHoliday && configHolidayService.save(configHoliday) > 0) {
            result.setOk(true).setMsg("保存成功！").setData(configHoliday);
        }
        return result;
    }

    /**
     * 保存修改后的节假日配置信息
     *
     *
     *
     * @param configHoliday
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/usave", method = RequestMethod.POST)
    public AjaxReturn updateSave(ConfigHoliday configHoliday) {

        AjaxReturn result = Ajax.fail().setMsg("修改失败！");
        /*if(configHoliday.getStatus()==0){
            if(configHolidayService.delete(configHoliday.getId())>0){
                //标记已经修改,把对象返回页面
                configHoliday.setStatus(0);
                System.err.println(configHoliday);
                result.setOk(true).setMsg("禁用成功！").setData(configHoliday);
            }
        }*/
        if(null != configHoliday && configHolidayService.modify(configHoliday) > 0) {
            //获得修改后的节日对象,返回页面
            ConfigHoliday configHoliday1=configHolidayService.findById(configHoliday.getId());
            System.err.println(configHoliday1);
            result.setOk(true).setMsg("修改成功！").setData(configHoliday1);
        }
        return result;
    }


    /**
     * 删除节假日配置信息
     *
     * @param ids 节假日配置信息编号
     * @return
     */
    @ResponseBody
    @RequestMapping("/delete")
    public AjaxReturn deleteByIds(@RequestParam("ids") Integer ids[]) {
        AjaxReturn result = Ajax.fail().setMsg("操作失败！");
        if (ids.length > 0 && configHolidayService.deleteByIds(ids) > 0) {
            result.setOk(true).setMsg("删除成功");
        }
        return result;
    }

    /**
     * 查询是否有相同的数据
     * @param selDate
     * @return
     */
    @RequestMapping(value = "find",method = RequestMethod.POST)
    @ResponseBody
    public AjaxReturn isEqual(@RequestParam("selDate") String selDate) {
        AjaxReturn result = new AjaxReturn();
        //前台时间日期格式化
        ConfigHoliday configHoliday = new ConfigHoliday();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            //字符串时间转换Date类型,放入节假日对象
            configHoliday.setHolidayDate(format.parse(selDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //获取与前台传入时间相同的节假日对象
        List<ConfigHoliday> configHolidays = configHolidayService.findByCnd(configHoliday);
        if(configHolidays.size()>0){
            //获取查询的节日对象,并且将对象返回到页面,为做判断准备
            ConfigHoliday configHoliday1=configHolidays.get(0);
            result.setOk(true).setData(configHoliday1);
        }else{
            result.setOk(false);
        }

        return result;
    }

}
