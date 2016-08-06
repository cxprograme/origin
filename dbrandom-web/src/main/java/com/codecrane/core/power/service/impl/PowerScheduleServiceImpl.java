package com.codecrane.core.power.service.impl;

import com.codecrane.core.power.service.PowerScheduleService;
import com.codecrane.core.power.entity.PowerSchedule;
import com.codecrane.core.power.mapper.PowerScheduleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 任务计划 服务
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
@Service
public class PowerScheduleServiceImpl implements PowerScheduleService {

    @Autowired
    private PowerScheduleMapper powerScheduleMapper;

    @Override
    public int save(PowerSchedule powerSchedule) {
        int result = 0;
        if (null != powerSchedule) {
            result = powerScheduleMapper.insert(powerSchedule);
        }
        return result;
    }

    @Override
    public int saveBatch(List<PowerSchedule> powerSchedules) {
        int result = 0;
        if (null != powerSchedules && powerSchedules.size() > 0) {
            result = powerScheduleMapper.insertBatch(powerSchedules);
        }
        return result;
    }

    @Override
    public int modify(PowerSchedule powerSchedule) {
        int result = 0;
        if (null != powerSchedule) {
            result = powerScheduleMapper.update(powerSchedule);
        }
        return result;
    }

    @Override
    public int delete(Long powerScheduleId) {
        int result = 0;
        if (powerScheduleId > 0) {
            result = powerScheduleMapper.delete(powerScheduleId);
        }
        return result;
    }

    @Override
    public int deleteByIds(Long[] powerScheduleIds) {
        int result = 0;
        if (powerScheduleIds.length > 0) {
            result = powerScheduleMapper.deleteByIds(powerScheduleIds);
        }
        return result;
    }

    @Override
    public PowerSchedule findById(Long powerScheduleId) {
        return powerScheduleMapper.queryByPowerScheduleId(powerScheduleId);
    }

    @Override
    public List<PowerSchedule> findAllPowerSchedule() {
        return powerScheduleMapper.queryAllPowerSchedule();
    }

    @Override
    public List<PowerSchedule> findByCnd(PowerSchedule powerSchedule) {
        if( null != powerSchedule ){
            return powerScheduleMapper.queryByCnd(powerSchedule);
        }else{
            return null;
        }
    }
}