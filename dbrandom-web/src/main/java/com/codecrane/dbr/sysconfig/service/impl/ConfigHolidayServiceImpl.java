package com.codecrane.dbr.sysconfig.service.impl;

import com.codecrane.dbr.sysconfig.entity.ConfigHoliday;
import com.codecrane.dbr.sysconfig.mapper.ConfigHolidayMapper;
import com.codecrane.dbr.sysconfig.service.ConfigHolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 节假日配置信息 服务
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
@Service
public class ConfigHolidayServiceImpl implements ConfigHolidayService {

    @Autowired
    private ConfigHolidayMapper configHolidayMapper;

    @Override
    public int save(ConfigHoliday configHoliday) {
        int result = 0;
        if (null != configHoliday) {
            result = configHolidayMapper.insert(configHoliday);
        }
        return result;
    }

    @Override
    public int saveBatch(List<ConfigHoliday> configHolidays) {
        int result = 0;
        if (null != configHolidays && configHolidays.size() > 0) {
            result = configHolidayMapper.insertBatch(configHolidays);
        }
        return result;
    }

    @Override
    public int modify(ConfigHoliday configHoliday) {
        int result = 0;
        if (null != configHoliday) {
            result = configHolidayMapper.update(configHoliday);
        }
        return result;
    }

    @Override
    public int delete(Integer configHolidayId) {
        int result = 0;
        if (configHolidayId > 0) {
            result = configHolidayMapper.delete(configHolidayId);
        }
        return result;
    }

    @Override
    public int deleteByIds(Integer[] configHolidayIds) {
        int result = 0;
        if (configHolidayIds.length > 0) {
            result = configHolidayMapper.deleteByIds(configHolidayIds);
        }
        return result;
    }

    @Override
    public ConfigHoliday findById(Integer configHolidayId) {
        return configHolidayMapper.queryByConfigHolidayId(configHolidayId);
    }

    @Override
    public List<ConfigHoliday> findAllConfigHoliday() {
        return configHolidayMapper.queryAllConfigHoliday();
    }

    @Override
    public List<ConfigHoliday> findByCnd(ConfigHoliday configHoliday) {
        if (null != configHoliday) {
            return configHolidayMapper.queryByCnd(configHoliday);
        } else {
            return null;
        }
    }

    @Override
    public List<ConfigHoliday> findByDateRangeWithStatus(ConfigHoliday configHoliday) {
        if (null != configHoliday) {
            return configHolidayMapper.queryByDateRangeWithStatus(configHoliday);
        } else {
            return null;
        }
    }
}