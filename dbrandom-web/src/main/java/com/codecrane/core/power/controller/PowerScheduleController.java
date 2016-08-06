package com.codecrane.core.power.controller;

import com.codecrane.core.power.service.PowerScheduleService;
import com.codecrane.core.schedule.ScheduleJob;
import com.codecrane.core.web.AjaxTableReturn;
import com.codecrane.core.power.entity.PowerSchedule;
import com.codecrane.core.schedule.QuartzJobManager;
import com.codecrane.core.web.Ajax;
import com.codecrane.core.web.AjaxReturn;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 任务计划 控制器
 *
 * @author Crane(hehebaiy@gmail.com)
 *         <br/>
 *         <br/>
 */
@Slf4j
@Controller
@RequestMapping("/power/schedule")
public class PowerScheduleController {

    @Autowired
    private PowerScheduleService powerScheduleService;

    @Autowired
    private QuartzJobManager quartzJobManager;

    /**
     * 任务计划管理主页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/main")
    public String powerScheduleListPage(Model model) {
        return "/power/schedule/main";
    }

    /**
     * 新增任务计划页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/addpage")
    public String addPowerSchedulePage(Model model) {

        return "/power/schedule/add";
    }

    /**
     * 修改任务计划页面
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/editpage")
    public String editPowerSchedulePage(@RequestParam("id") long id, Model model) {

        // 根据ID查询任务计划
        PowerSchedule powerSchedule = powerScheduleService.findById(id);

        // 将任务计划返回到页面中
        model.addAttribute("powerSchedule", powerSchedule);

        return "/power/schedule/edit";
    }

    /**
     * 分页查询任务计划
     *
     * @param pagesize
     * @param start
     * @return
     */
    @ResponseBody
    @RequestMapping("/findall")
    public AjaxTableReturn findAllPowerSchedule(@RequestParam(value = "limit", defaultValue = "10") int pagesize,
                                                @RequestParam(value = "offset", defaultValue = "0") int start) {
        start = start > 0 ? start / pagesize + 1 : 1;
        PageHelper.startPage(start, pagesize);
        List<PowerSchedule> powerSchedules = powerScheduleService.findAllPowerSchedule();
        PageInfo<PowerSchedule> page = new PageInfo<>(powerSchedules);

        return Ajax.tableDataOk(page.getTotal(), page.getList());
    }

    /**
     * 保存任务计划
     *
     * @param powerSchedule
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public AjaxReturn save(PowerSchedule powerSchedule) {
        AjaxReturn result = Ajax.fail().setMsg("保存失败！");
        if (null != powerSchedule && powerScheduleService.save(powerSchedule) > 0) {
            result.setOk(true).setMsg("保存成功！");
        }
        return result;
    }

    /**
     * 保存修改后的任务计划
     *
     * @param powerSchedule
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/usave", method = RequestMethod.POST)
    public AjaxReturn updateSave(PowerSchedule powerSchedule) {
        AjaxReturn result = Ajax.fail().setMsg("修改失败！");
        if (null != powerSchedule && powerScheduleService.modify(powerSchedule) > 0) {
            result.setOk(true).setMsg("修改成功！");
        }
        return result;
    }


    /**
     * 删除任务计划
     *
     * @param ids 任务计划编号
     * @return
     */
    @ResponseBody
    @RequestMapping("/delete")
    public AjaxReturn deleteByIds(@RequestParam("ids") Long ids[]) {
        AjaxReturn result = Ajax.fail().setMsg("操作失败！");
        if (ids.length > 0 && powerScheduleService.deleteByIds(ids) > 0) {
            result.setOk(true).setMsg("删除成功");
        }
        return result;
    }

    /**
     * 启动一个任务
     *
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/start")
    public AjaxReturn startJob(@RequestParam("id") long id) {
        AjaxReturn result = Ajax.fail().setMsg("启动失败！");

        PowerSchedule schedule = powerScheduleService.findById(id);

        try {
            if (null != schedule && null == quartzJobManager.getJob(schedule.getJobName(), schedule.getJobGroup())) {

                ScheduleJob job = new ScheduleJob();
                job.setJobName(schedule.getJobName());
                job.setJobGroup(schedule.getJobGroup());
                job.setCronExpression(schedule.getJobCron());

                Class jobClass = Class.forName(schedule.getJobClassPath());

                job.setJobClass(jobClass);

                quartzJobManager.addJob(job);

                schedule.setJobStatus("start");
                powerScheduleService.modify(schedule);

                result.setOk(true).setMsg("启动成功");
            }
        } catch (SchedulerException e) {
            log.error("schedule exception,job detail:{}", schedule);
        } catch (ClassNotFoundException e) {
            log.error("schedule exception,job detail:{}", schedule);
            result.setMsg("任务类不存在!");
        }

        return result;
    }

    /**
     * 停止一个任务
     *
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/stop")
    public AjaxReturn stopJob(@RequestParam("id") long id) {
        AjaxReturn result = Ajax.fail().setMsg("停止失败！");

        PowerSchedule schedule = powerScheduleService.findById(id);

        try {
            if (null != schedule && null != quartzJobManager.getJob(schedule.getJobName(), schedule.getJobGroup())) {

                ScheduleJob job = new ScheduleJob();
                job.setJobName(schedule.getJobName());
                job.setJobGroup(schedule.getJobGroup());

                quartzJobManager.delete(job);

                schedule.setJobStatus("stop");
                powerScheduleService.modify(schedule);

                result.setOk(true).setMsg("任务停止成功");
            }
        } catch (SchedulerException e) {
            log.error("schedule exception,job detail:{}", schedule);
        }

        return result;
    }

    /**
     * 暂停一个任务
     *
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/pause")
    public AjaxReturn pauseJob(@RequestParam("id") long id) {
        AjaxReturn result = Ajax.fail().setMsg("暂停失败！");

        PowerSchedule schedule = powerScheduleService.findById(id);

        try {
            if (null != schedule && null != quartzJobManager.getJob(schedule.getJobName(), schedule.getJobGroup())) {

                ScheduleJob job = new ScheduleJob();
                job.setJobName(schedule.getJobName());
                job.setJobGroup(schedule.getJobGroup());

                quartzJobManager.pauseJob(job);

                schedule.setJobStatus("pause");
                powerScheduleService.modify(schedule);

                result.setOk(true).setMsg("任务停止成功");
            }
        } catch (SchedulerException e) {
            log.error("schedule exception,job detail:{}", schedule);
        }

        return result;
    }
}
