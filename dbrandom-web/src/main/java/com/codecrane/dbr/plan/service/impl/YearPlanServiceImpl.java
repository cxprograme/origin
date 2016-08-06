package com.codecrane.dbr.plan.service.impl;

import com.codecrane.dbr.plan.entity.YearPlan;
import com.codecrane.dbr.plan.mapper.YearPlanMapper;
import com.codecrane.dbr.plan.service.YearPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 年度执法计划 服务
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
@Service
public class YearPlanServiceImpl implements YearPlanService {

    @Autowired
    private YearPlanMapper yearPlanMapper;

    @Override
    public int save(YearPlan yearPlan) {
        int result = 0;
        if (null != yearPlan) {
            result = yearPlanMapper.insert(yearPlan);
        }
        return result;
    }

    @Override
    public int saveBatch(List<YearPlan> yearPlans) {
        int result = 0;
        if (null != yearPlans && yearPlans.size() > 0) {
            result = yearPlanMapper.insertBatch(yearPlans);
        }
        return result;
    }

    @Override
    public int modify(YearPlan yearPlan) {
        int result = 0;
        if (null != yearPlan) {
            result = yearPlanMapper.update(yearPlan);
        }
        return result;
    }

    @Override
    public int delete(Integer yearPlanId) {
        int result = 0;
        if (yearPlanId > 0) {
            result = yearPlanMapper.delete(yearPlanId);
        }
        return result;
    }

    @Override
    public int deleteByIds(Integer[] yearPlanIds) {
        int result = 0;
        if (yearPlanIds.length > 0) {
            result = yearPlanMapper.deleteByIds(yearPlanIds);
        }
        return result;
    }

    @Override
    public YearPlan findById(Integer yearPlanId) {
        return yearPlanMapper.queryByYearPlanId(yearPlanId);
    }

    @Override
    public YearPlan findByGroupId(Integer groupId) {
        return yearPlanMapper.queryByGroupId(groupId);
    }

    @Override
    public List<YearPlan> findAllYearPlan() {
        return yearPlanMapper.queryAllYearPlan();
    }

    @Override
    public List<YearPlan> findByCnd(YearPlan yearPlan) {
        if (null != yearPlan) {
            return yearPlanMapper.queryByCnd(yearPlan);
        } else {
            return null;
        }
    }
}