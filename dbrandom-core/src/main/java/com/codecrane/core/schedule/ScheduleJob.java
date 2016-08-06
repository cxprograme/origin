package com.codecrane.core.schedule;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.quartz.Job;

/**
 * 任务model
 * Created by crane on 16/5/5.
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleJob {

    private String jobName;

    private String jobGroup;

    private String jobClassStr;

    private Class<? extends Job> jobClass;

    private String jobStatus;

    private String cronExpression;

    private String description;
}
