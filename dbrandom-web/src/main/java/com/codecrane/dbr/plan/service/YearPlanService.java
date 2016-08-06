package com.codecrane.dbr.plan.service;

import com.codecrane.dbr.plan.entity.YearPlan;

import java.util.List;

/**
 * 年度执法计划 服务接口
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
public interface YearPlanService {

    /**
     * 新增 年度执法计划
     *
     * @param yearPlan
     * @return
     */
    int save(YearPlan yearPlan);

    /**
     * 批量新增 年度执法计划
     *
     * @param yearPlans
     * @return
     */
    int saveBatch(List<YearPlan> yearPlans);

    /**
     * 修改 年度执法计划
     *
     * @param yearPlan
     * @return
     */
    int modify(YearPlan yearPlan);

    /**
     * 删除 年度执法计划
     *
     * @param yearPlanId
     * @return
     */
    int delete(Integer yearPlanId);

    /**
     * 批量删除 年度执法计划
     *
     * @param yearPlanIds
     * @return
     */
    int deleteByIds(Integer[] yearPlanIds);

    /**
     * 查询指定 年度执法计划
     *
     * @param id
     * @return 年度执法计划
     */
    YearPlan findById(Integer id);

    /**
     * 查询指定 管理机构的年度执法计划
     * @param groupId
     * @return
     */
    YearPlan findByGroupId(Integer groupId);

    /**
     * 查询所有 年度执法计划
     *
     * @return
     */
    List<YearPlan> findAllYearPlan();


    /**
     * 多条件查询 年度执法计划
     *
     * @param yearPlan
     * @return
     */
    List<YearPlan> findByCnd(YearPlan yearPlan);
}