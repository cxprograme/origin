package com.codecrane.core.power.service;

import com.codecrane.core.power.entity.PowerSchedule;

import java.util.List;

/**
 * 任务计划 服务接口
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
public interface PowerScheduleService {

    /**
     * 新增 任务计划
     *
     * @param powerSchedule
     * @return
     */
    int save(PowerSchedule powerSchedule);

    /**
     * 批量新增 任务计划
     *
     * @param powerSchedules
     * @return
     */
    int saveBatch(List<PowerSchedule> powerSchedules);

    /**
     * 修改 任务计划
     *
     * @param powerSchedule
     * @return
     */
    int modify(PowerSchedule powerSchedule);

    /**
     * 删除 任务计划
     *
     * @param powerScheduleId
     * @return
     */
    int delete(Long powerScheduleId);

    /**
     * 批量删除 任务计划
     *
     * @param powerScheduleIds
     * @return
     */
    int deleteByIds(Long[] powerScheduleIds);

    /**
     * 查询指定 任务计划
     *
     * @param id
     * @return 任务计划
     */
    PowerSchedule findById(Long id);

    /**
     * 查询所有 任务计划
     *
     * @return
     */
    List<PowerSchedule> findAllPowerSchedule();

    /**
     * 多条件查询 任务计划
     * @param powerSchedule
     * @return
     */
    List<PowerSchedule> findByCnd(PowerSchedule powerSchedule);
}