package com.codecrane.dbr.rule.service;

import com.codecrane.dbr.rule.entity.ConfigRuleGroup;
import com.codecrane.dbr.rule.entity.ConfigRuleType;

import java.util.List;

/**
 * 抽取规则配置服务
 * Created by crane on 16/6/3.
 */
public interface ConfigRuleService {

    /**
     * 保存抽取规则配置
     * @param configRuleGroup
     * @param configRuleTypes
     * @return
     */
    boolean saveRuleConfig(ConfigRuleGroup configRuleGroup, List<ConfigRuleType> configRuleTypes);

    /**
     * 更新抽取规则配置
     * @param configRuleGroup
     * @param configRuleTypes
     * @return
     */
    boolean modifyRuleConfig(ConfigRuleGroup configRuleGroup, List<ConfigRuleType> configRuleTypes);

}
