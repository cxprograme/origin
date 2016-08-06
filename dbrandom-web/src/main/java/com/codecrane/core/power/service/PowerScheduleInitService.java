package com.codecrane.core.power.service;

import com.codecrane.core.power.entity.PowerSchedule;
import com.codecrane.core.schedule.QuartzJobManager;
import com.codecrane.core.schedule.ScheduleJob;
import lombok.extern.slf4j.Slf4j;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.List;

/**
 * 任务计划初始化服务
 * Created by crane on 16/5/9.
 */
@Slf4j
public class PowerScheduleInitService implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private PowerScheduleService powerScheduleService;

    @Autowired
    private QuartzJobManager quartzJobManager;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        log.debug("初始化任务计划...");

        //查询所有状态为已启动的任务
        PowerSchedule schedule = new PowerSchedule();
        schedule.setJobStatus("start");
        List<PowerSchedule> scheduleList = powerScheduleService.findByCnd(schedule);

        if (null != scheduleList) {
            for (PowerSchedule job : scheduleList) {

                ScheduleJob scheduleJob = new ScheduleJob();
                scheduleJob.setJobName(job.getJobName());
                scheduleJob.setJobGroup(job.getJobGroup());
                scheduleJob.setCronExpression(job.getJobCron());



                Class jobClass = null;
                try {
                    jobClass = Class.forName(job.getJobClassPath());
                    scheduleJob.setJobClass(jobClass);
                    quartzJobManager.addJob(scheduleJob);
                } catch (ClassNotFoundException e) {
                    log.error("quartz job class not found exception:{}", job);
                } catch (SchedulerException e) {
                    log.error("schedule exception:{}", scheduleJob);
                }

            }
        }

    }
}
