package com.codecrane.dbr.rule.mapper;

import com.codecrane.dbr.rule.entity.ConfigRuleGroup;

import java.util.List;

/**
 * 抽取规则分组模式配置 数据库操作接口
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 * <br/>
 * <br/>
 */
public interface ConfigRuleGroupMapper{

	/**
	 * 新增 抽取规则分组模式配置
	 * @param configRuleGroup
	 * @return
	 */
	 int insert(ConfigRuleGroup configRuleGroup);

	/**
	 * 批量新增 抽取规则分组模式配置
	 * @param configRuleGroups
	 * @return
	 */
	 int insertBatch(List<ConfigRuleGroup> configRuleGroups);
	
	/**
	 * 更新 抽取规则分组模式配置
	 * @param configRuleGroup
	 * @return
	 */
	 int update(ConfigRuleGroup configRuleGroup);
	
	/**
	 * 删除 抽取规则分组模式配置
	 * @param id
	 * @return
	 */
	 int delete(Integer id);
	
	/**
	 * 批量删除 抽取规则分组模式配置
	 * @param idList
	 * @return
	 */
	 int deleteByIds(Integer[] idList);
	
	/**
	 * 查询指定 抽取规则分组模式配置
	 * @param id
	 * @return 抽取规则分组模式配置
	 */
	 ConfigRuleGroup queryByConfigRuleGroupId(Integer id);

	/**
	 * 查询指定 管理机构抽取规则分组模式配置
	 * @param groupId
	 * @return
     */
	 ConfigRuleGroup queryByGroupId(Integer groupId);

	/**
	 * 查询所有 抽取规则分组模式配置
	 */
	 List<ConfigRuleGroup> queryAllConfigRuleGroup();


	/**
	 * 多条件查询 抽取规则分组模式配置
	 */
	 List<ConfigRuleGroup> queryByCnd(ConfigRuleGroup configRuleGroup);
}