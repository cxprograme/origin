package com.codecrane.core.power.mapper;

import com.codecrane.core.power.entity.PowerSchedule;

import java.util.List;

/**
 * 任务计划 数据库操作接口
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
public interface PowerScheduleMapper {

    /**
     * 新增 任务计划
     *
     * @param powerSchedule
     * @return
     */
    int insert(PowerSchedule powerSchedule);

    /**
     * 批量新增 任务计划
     *
     * @param powerSchedules
     * @return
     */
    int insertBatch(List<PowerSchedule> powerSchedules);

    /**
     * 更新 任务计划
     *
     * @param powerSchedule
     * @return
     */
    int update(PowerSchedule powerSchedule);

    /**
     * 删除 任务计划
     *
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 批量删除 任务计划
     *
     * @param idList
     * @return
     */
    int deleteByIds(Long[] idList);

    /**
     * 查询指定 任务计划
     *
     * @param id
     * @return 任务计划
     */
    PowerSchedule queryByPowerScheduleId(Long id);

    /**
     * 查询所有 任务计划
     */
    List<PowerSchedule> queryAllPowerSchedule();

    /**
     * 多条件查询任务计划
     * @param powerSchedule
     * @return
     */
    List<PowerSchedule> queryByCnd(PowerSchedule powerSchedule);
}