package com.codecrane.dbr.rule.service.impl;

import com.codecrane.dbr.rule.entity.ConfigRuleGroup;
import com.codecrane.dbr.rule.entity.ConfigRuleType;
import com.codecrane.dbr.rule.service.ConfigRuleGroupService;
import com.codecrane.dbr.rule.service.ConfigRuleService;
import com.codecrane.dbr.rule.service.ConfigRuleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by crane on 16/6/3.
 */
@Service
public class ConfigRuleServiceImpl implements ConfigRuleService {

    @Autowired
    private ConfigRuleGroupService configRuleGroupService;

    @Autowired
    private ConfigRuleTypeService configRuleTypeService;

    @Override
    @Transactional
    public boolean saveRuleConfig(ConfigRuleGroup configRuleGroup, List<ConfigRuleType> configRuleTypes) {
        boolean result = false;
        if (null != configRuleGroup && null != configRuleTypes) {
            configRuleGroupService.save(configRuleGroup);
            configRuleTypeService.saveBatch(configRuleTypes);
            result = true;
        }
        return result;
    }

    @Override
    @Transactional
    public boolean modifyRuleConfig(ConfigRuleGroup configRuleGroup, List<ConfigRuleType> configRuleTypes) {
        boolean result = false;
        if (null != configRuleGroup && null != configRuleTypes) {
            configRuleGroupService.modify(configRuleGroup);
            //先删除
            configRuleTypeService.deleteByGroupId(configRuleGroup.getGroupId());
            //再写入
            configRuleTypeService.saveBatch(configRuleTypes);
            result = true;
        }
        return result;
    }
}
