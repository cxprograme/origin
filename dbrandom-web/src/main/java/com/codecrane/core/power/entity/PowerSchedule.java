package com.codecrane.core.power.entity;

import lombok.*;

/**
 * 任务计划
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper = true)
public class PowerSchedule  extends BaseEntity{

    private static final long serialVersionUID = 1L;

    /**
     * 任务名称
     */
    private String jobName;
    /**
     * 任务分组
     */
    private String jobGroup;
    /**
     * 任务执行时间表达式
     */
    private String jobCron;
    /**
     * 任务执行类完整路径
     */
    private String jobClassPath;
    /**
     * 任务状态 stop 停止 start 启动 pause 暂停
     */
    private String jobStatus;
    /**
     * 任务描述
     */
    private String jobDescription;

}