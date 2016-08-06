package com.codecrane.dbr.rule.service.impl;

import com.codecrane.dbr.rule.entity.ConfigRuleGroup;
import com.codecrane.dbr.rule.mapper.ConfigRuleGroupMapper;
import com.codecrane.dbr.rule.service.ConfigRuleGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 抽取规则分组模式配置 服务
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
@Service
public class ConfigRuleGroupServiceImpl implements ConfigRuleGroupService {

    @Autowired
    private ConfigRuleGroupMapper configRuleGroupMapper;

    @Override
    public int save(ConfigRuleGroup configRuleGroup) {
        int result = 0;
        if (null != configRuleGroup) {
            result = configRuleGroupMapper.insert(configRuleGroup);
        }
        return result;
    }

    @Override
    public int saveBatch(List<ConfigRuleGroup> configRuleGroups) {
        int result = 0;
        if (null != configRuleGroups && configRuleGroups.size() > 0) {
            result = configRuleGroupMapper.insertBatch(configRuleGroups);
        }
        return result;
    }

    @Override
    public int modify(ConfigRuleGroup configRuleGroup) {
        int result = 0;
        if (null != configRuleGroup) {
            result = configRuleGroupMapper.update(configRuleGroup);
        }
        return result;
    }

    @Override
    public int delete(Integer configRuleGroupId) {
        int result = 0;
        if (configRuleGroupId > 0) {
            result = configRuleGroupMapper.delete(configRuleGroupId);
        }
        return result;
    }

    @Override
    public int deleteByIds(Integer[] configRuleGroupIds) {
        int result = 0;
        if (configRuleGroupIds.length > 0) {
            result = configRuleGroupMapper.deleteByIds(configRuleGroupIds);
        }
        return result;
    }

    @Override
    public ConfigRuleGroup findById(Integer configRuleGroupId) {
        return configRuleGroupMapper.queryByConfigRuleGroupId(configRuleGroupId);
    }

    @Override
    public ConfigRuleGroup findByGroupId(Integer groupId) {
        return configRuleGroupMapper.queryByGroupId(groupId);
    }

    @Override
    public List<ConfigRuleGroup> findAllConfigRuleGroup() {
        return configRuleGroupMapper.queryAllConfigRuleGroup();
    }

    @Override
    public List<ConfigRuleGroup> findByCnd(ConfigRuleGroup configRuleGroup) {
        if (null != configRuleGroup) {
            return configRuleGroupMapper.queryByCnd(configRuleGroup);
        } else {
            return null;
        }
    }
}