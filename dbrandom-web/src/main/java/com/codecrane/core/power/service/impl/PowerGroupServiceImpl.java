package com.codecrane.core.power.service.impl;

import com.codecrane.core.power.entity.PowerGroup;
import com.codecrane.core.power.mapper.PowerGroupMapper;
import com.codecrane.core.power.service.PowerGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 组织机构信息表 服务
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
@Service
public class PowerGroupServiceImpl implements PowerGroupService {

    @Autowired
    private PowerGroupMapper powerGroupMapper;

    @Override
    public int save(PowerGroup powerGroup) {
        int result = 0;
        if (null != powerGroup) {
            result = powerGroupMapper.insert(powerGroup);
        }
        return result;
    }

    @Override
    public int saveBatch(List<PowerGroup> powerGroups) {
        int result = 0;
        if (null != powerGroups && powerGroups.size() > 0) {
            result = powerGroupMapper.insertBatch(powerGroups);
        }
        return result;
    }

    @Override
    public int modify(PowerGroup powerGroup) {
        int result = 0;
        if (null != powerGroup) {
            result = powerGroupMapper.update(powerGroup);
        }
        return result;
    }

    @Override
    public int delete(long powerGroupId) {
        int result = 0;
        if (powerGroupId > 0) {
            result = powerGroupMapper.delete(powerGroupId);
        }
        return result;
    }

    @Override
    public int deleteByIds(long[] powerGroupIds) {
        int result = 0;
        if (powerGroupIds.length > 0) {
            result = powerGroupMapper.deleteByIds(powerGroupIds);
        }
        return result;
    }

    @Override
    public PowerGroup findById(long powerGroupId) {
        return powerGroupMapper.queryByPowerGroupId(powerGroupId);
    }

    @Override
    public List<PowerGroup> findAllPowerGroup() {
        return powerGroupMapper.queryAllPowerGroup();
    }

    @Override
    public List<PowerGroup> findByPid(long id) {
        return powerGroupMapper.queryByPowerGroupPid(id);
    }

    @Override
    public List<PowerGroup> findAllChildGroup(PowerGroup powerGroup) {
        return powerGroupMapper.queryAllChildGroup(powerGroup);
    }

    @Override
    public List<PowerGroup> findAllParentGroup(PowerGroup powerGroup) {
        return powerGroupMapper.queryAllParentGroup(powerGroup);
    }
}