package com.codecrane.dbr.rule.service;

import java.util.List;
import com.codecrane.dbr.rule.entity.ConfigRuleType;

 /**
 * 抽取规则分类比重配置 服务接口
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 * <br/>
 * <br/>
 */
public interface ConfigRuleTypeService{

	/**
	 * 新增 抽取规则分类比重配置
	 * @param configRuleType
	 * @return
	 */
	 int save(ConfigRuleType configRuleType);

	/**
	 * 批量新增 抽取规则分类比重配置
	 * @param configRuleTypes
	 * @return
	 */
	 int saveBatch(List<ConfigRuleType> configRuleTypes);

	/**
	 * 修改 抽取规则分类比重配置
	 * @param configRuleType
	 * @return
	 */
	 int modify(ConfigRuleType configRuleType);

	/**
	 * 删除 抽取规则分类比重配置
	 * @param configRuleTypeId
	 * @return
	 */
	 int delete(Integer configRuleTypeId);

	/**
	 * 批量删除 抽取规则分类比重配置
	 * @param configRuleTypeIds
	 * @return
	 */
	 int deleteByIds(Integer[] configRuleTypeIds);

	 /**
	  * 删除指定管理机构的抽取规则分类比重配置
	  * @param groupId
	  * @return
      */
	 int deleteByGroupId(Integer groupId);

	/**
	 * 查询指定 抽取规则分类比重配置
	 * @param id
	 * @return 抽取规则分类比重配置
	 */
	 ConfigRuleType findById(Integer id);
	
	/**
	 * 查询所有 抽取规则分类比重配置
	 * @return
	 */
	 List<ConfigRuleType> findAllConfigRuleType();

	/**
	 * 多条件查询 抽取规则分类比重配置
	 * @param configRuleType
	 * @return
	 */
	 List<ConfigRuleType> findByCnd(ConfigRuleType configRuleType);

	 /**
	  * 查询指定 管理机构抽取规则分类比重配置
	  * @param groupId
	  * @return
      */
	 List<ConfigRuleType> findByGroupId( Integer groupId);
}