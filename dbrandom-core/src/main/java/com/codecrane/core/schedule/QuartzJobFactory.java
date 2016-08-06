package com.codecrane.core.schedule;

import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Created by crane on 16/5/5.
 */
@Slf4j
@DisallowConcurrentExecution
public class QuartzJobFactory implements Job {

    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.info("任务成功运行 ...");
        ScheduleJob scheduleJob = (ScheduleJob) context.getMergedJobDataMap().get("scheduleJob");
        log.info("任务名称 = [{}]", scheduleJob.getJobName());
    }
}
