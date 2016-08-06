package com.codecrane.dbr.sysconfig.mapper;

import com.codecrane.dbr.sysconfig.entity.ConfigHoliday;

import java.util.List;

/**
 * 节假日配置信息 数据库操作接口
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
public interface ConfigHolidayMapper {

    /**
     * 新增 节假日配置信息
     *
     * @param configHoliday
     * @return
     */
    int insert(ConfigHoliday configHoliday);

    /**
     * 批量新增 节假日配置信息
     *
     * @param configHolidays
     * @return
     */
    int insertBatch(List<ConfigHoliday> configHolidays);

    /**
     * 更新 节假日配置信息
     *
     * @param configHoliday
     * @return
     */
    int update(ConfigHoliday configHoliday);

    /**
     * 删除 节假日配置信息
     *
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 批量删除 节假日配置信息
     *
     * @param idList
     * @return
     */
    int deleteByIds(Integer[] idList);

    /**
     * 查询指定 节假日配置信息
     *
     * @param id
     * @return 节假日配置信息
     */
    ConfigHoliday queryByConfigHolidayId(Integer id);

    /**
     * 查询所有 节假日配置信息
     */
    List<ConfigHoliday> queryAllConfigHoliday();


    /**
     * 多条件查询 节假日配置信息
     */
    List<ConfigHoliday> queryByCnd(ConfigHoliday configHoliday);

    /**
     * 查询指定日期范围内的指定状态日期
     * @param configHoliday
     * @return
     */
    List<ConfigHoliday> queryByDateRangeWithStatus(ConfigHoliday configHoliday);
}