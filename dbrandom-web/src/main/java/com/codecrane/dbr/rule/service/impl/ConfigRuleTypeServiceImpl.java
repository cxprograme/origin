package com.codecrane.dbr.rule.service.impl;

import com.codecrane.dbr.rule.entity.ConfigRuleType;
import com.codecrane.dbr.rule.mapper.ConfigRuleTypeMapper;
import com.codecrane.dbr.rule.service.ConfigRuleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 抽取规则分类比重配置 服务
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
@Service
public class ConfigRuleTypeServiceImpl implements ConfigRuleTypeService {

    @Autowired
    private ConfigRuleTypeMapper configRuleTypeMapper;

    @Override
    public int save(ConfigRuleType configRuleType) {
        int result = 0;
        if (null != configRuleType) {
            result = configRuleTypeMapper.insert(configRuleType);
        }
        return result;
    }

    @Override
    public int saveBatch(List<ConfigRuleType> configRuleTypes) {
        int result = 0;
        if (null != configRuleTypes && configRuleTypes.size() > 0) {
            result = configRuleTypeMapper.insertBatch(configRuleTypes);
        }
        return result;
    }

    @Override
    public int modify(ConfigRuleType configRuleType) {
        int result = 0;
        if (null != configRuleType) {
            result = configRuleTypeMapper.update(configRuleType);
        }
        return result;
    }

    @Override
    public int delete(Integer configRuleTypeId) {
        int result = 0;
        if (configRuleTypeId > 0) {
            result = configRuleTypeMapper.delete(configRuleTypeId);
        }
        return result;
    }

    @Override
    public int deleteByIds(Integer[] configRuleTypeIds) {
        int result = 0;
        if (configRuleTypeIds.length > 0) {
            result = configRuleTypeMapper.deleteByIds(configRuleTypeIds);
        }
        return result;
    }

    @Override
    public int deleteByGroupId(Integer groupId) {
        int result = 0;
        if (null != groupId) {
            result = configRuleTypeMapper.deleteByGroupId(groupId);
        }
        return result;
    }

    @Override
    public ConfigRuleType findById(Integer configRuleTypeId) {
        return configRuleTypeMapper.queryByConfigRuleTypeId(configRuleTypeId);
    }

    @Override
    public List<ConfigRuleType> findAllConfigRuleType() {
        return configRuleTypeMapper.queryAllConfigRuleType();
    }

    @Override
    public List<ConfigRuleType> findByCnd(ConfigRuleType configRuleType) {
        if (null != configRuleType) {
            return configRuleTypeMapper.queryByCnd(configRuleType);
        } else {
            return null;
        }
    }

    @Override
    public List<ConfigRuleType> findByGroupId(Integer groupId) {
        return configRuleTypeMapper.queryByGroupId(groupId);
    }
}