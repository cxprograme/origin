package com.codecrane.dbr.sysconfig.service;

import com.codecrane.dbr.sysconfig.entity.ConfigHoliday;

import java.util.List;

/**
 * 节假日配置信息 服务接口
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
public interface ConfigHolidayService {

    /**
     * 新增 节假日配置信息
     *
     * @param configHoliday
     * @return
     */
    int save(ConfigHoliday configHoliday);

    /**
     * 批量新增 节假日配置信息
     *
     * @param configHolidays
     * @return
     */
    int saveBatch(List<ConfigHoliday> configHolidays);

    /**
     * 修改 节假日配置信息
     *
     * @param configHoliday
     * @return
     */
    int modify(ConfigHoliday configHoliday);

    /**
     * 删除 节假日配置信息
     *
     * @param configHolidayId
     * @return
     */
    int delete(Integer configHolidayId);

    /**
     * 批量删除 节假日配置信息
     *
     * @param configHolidayIds
     * @return
     */
    int deleteByIds(Integer[] configHolidayIds);

    /**
     * 查询指定 节假日配置信息
     *
     * @param id
     * @return 节假日配置信息
     */
    ConfigHoliday findById(Integer id);

    /**
     * 查询所有 节假日配置信息
     *
     * @return
     */
    List<ConfigHoliday> findAllConfigHoliday();


    /**
     * 多条件查询 节假日配置信息
     *
     * @param configHoliday
     * @return
     */
    List<ConfigHoliday> findByCnd(ConfigHoliday configHoliday);

    /**
     * 查询指定日期范围内的指定状态日期
     * @param configHoliday
     * @return
     */
    List<ConfigHoliday> findByDateRangeWithStatus(ConfigHoliday configHoliday);
}