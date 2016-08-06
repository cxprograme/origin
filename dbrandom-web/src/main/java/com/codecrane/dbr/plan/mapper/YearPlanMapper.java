package com.codecrane.dbr.plan.mapper;

import com.codecrane.dbr.plan.entity.YearPlan;

import java.util.List;

/**
 * 年度执法计划 数据库操作接口
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
public interface YearPlanMapper {

    /**
     * 新增 年度执法计划
     *
     * @param yearPlan
     * @return
     */
    int insert(YearPlan yearPlan);

    /**
     * 批量新增 年度执法计划
     *
     * @param yearPlans
     * @return
     */
    int insertBatch(List<YearPlan> yearPlans);

    /**
     * 更新 年度执法计划
     *
     * @param yearPlan
     * @return
     */
    int update(YearPlan yearPlan);

    /**
     * 删除 年度执法计划
     *
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 批量删除 年度执法计划
     *
     * @param idList
     * @return
     */
    int deleteByIds(Integer[] idList);

    /**
     * 查询指定 年度执法计划
     *
     * @param id
     * @return 年度执法计划
     */
    YearPlan queryByYearPlanId(Integer id);

    /**
     * 查询指定 管理机构年度执法计划
     * @param groupId
     * @return
     */
    YearPlan queryByGroupId(Integer groupId);

    /**
     * 查询所有 年度执法计划
     */
    List<YearPlan> queryAllYearPlan();


    /**
     * 多条件查询 年度执法计划
     */
    List<YearPlan> queryByCnd(YearPlan yearPlan);
}