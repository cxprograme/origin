package com.codecrane.dbr.rule.mapper;

import com.codecrane.dbr.rule.entity.ConfigRuleType;

import java.util.List;

/**
 * 抽取规则分类比重配置 数据库操作接口
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
public interface ConfigRuleTypeMapper {

    /**
     * 新增 抽取规则分类比重配置
     *
     * @param configRuleType
     * @return
     */
    int insert(ConfigRuleType configRuleType);

    /**
     * 批量新增 抽取规则分类比重配置
     *
     * @param configRuleTypes
     * @return
     */
    int insertBatch(List<ConfigRuleType> configRuleTypes);

    /**
     * 更新 抽取规则分类比重配置
     *
     * @param configRuleType
     * @return
     */
    int update(ConfigRuleType configRuleType);

    /**
     * 删除 抽取规则分类比重配置
     *
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 批量删除 抽取规则分类比重配置
     *
     * @param idList
     * @return
     */
    int deleteByIds(Integer[] idList);

    /**
     * 删除指定 管理机构的分类规则配置
     * @param groupId
     * @return
     */
    int deleteByGroupId(Integer groupId);

    /**
     * 查询指定 抽取规则分类比重配置
     *
     * @param id
     * @return 抽取规则分类比重配置
     */
    ConfigRuleType queryByConfigRuleTypeId(Integer id);

    /**
     * 查询所有 抽取规则分类比重配置
     */
    List<ConfigRuleType> queryAllConfigRuleType();

    /**
     * 多条件查询 抽取规则分类比重配置
     */
    List<ConfigRuleType> queryByCnd(ConfigRuleType configRuleType);

    /**
     * 查询指定 管理机构抽取规则分类比重配置
     *
     * @param groupId
     * @return
     */
    List<ConfigRuleType> queryByGroupId(Integer groupId);
}