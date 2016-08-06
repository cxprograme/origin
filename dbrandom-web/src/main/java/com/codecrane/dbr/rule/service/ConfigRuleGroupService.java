package com.codecrane.dbr.rule.service;

import com.codecrane.dbr.rule.entity.ConfigRuleGroup;

import java.util.List;

/**
 * 抽取规则分组模式配置 服务接口
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
public interface ConfigRuleGroupService {

    /**
     * 新增 抽取规则分组模式配置
     *
     * @param configRuleGroup
     * @return
     */
    int save(ConfigRuleGroup configRuleGroup);

    /**
     * 批量新增 抽取规则分组模式配置
     *
     * @param configRuleGroups
     * @return
     */
    int saveBatch(List<ConfigRuleGroup> configRuleGroups);

    /**
     * 修改 抽取规则分组模式配置
     *
     * @param configRuleGroup
     * @return
     */
    int modify(ConfigRuleGroup configRuleGroup);

    /**
     * 删除 抽取规则分组模式配置
     *
     * @param configRuleGroupId
     * @return
     */
    int delete(Integer configRuleGroupId);

    /**
     * 批量删除 抽取规则分组模式配置
     *
     * @param configRuleGroupIds
     * @return
     */
    int deleteByIds(Integer[] configRuleGroupIds);

    /**
     * 查询指定 抽取规则分组模式配置
     *
     * @param id
     * @return 抽取规则分组模式配置
     */
    ConfigRuleGroup findById(Integer id);

    /**
     * 查询指定 管理机构抽取规则分组模式配置
     *
     * @param groupId
     * @return
     */
    ConfigRuleGroup findByGroupId(Integer groupId);


    /**
     * 查询所有 抽取规则分组模式配置
     *
     * @return
     */
    List<ConfigRuleGroup> findAllConfigRuleGroup();


    /**
     * 多条件查询 抽取规则分组模式配置
     *
     * @param configRuleGroup
     * @return
     */
    List<ConfigRuleGroup> findByCnd(ConfigRuleGroup configRuleGroup);
}