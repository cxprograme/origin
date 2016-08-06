package com.codecrane.dbr.manageobj.service.impl;

import com.codecrane.dbr.manageobj.entity.CompanyManageConfig;
import com.codecrane.dbr.manageobj.mapper.CompanyManageConfigMapper;
import com.codecrane.dbr.manageobj.service.CompanyManageConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 企业管理模式信息 服务
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
@Service
public class CompanyManageConfigServiceImpl implements CompanyManageConfigService {

    @Autowired
    private CompanyManageConfigMapper companyManageConfigMapper;

    @Override
    public int save(CompanyManageConfig companyManageConfig) {
        int result = 0;
        if (null != companyManageConfig) {
            result = companyManageConfigMapper.insert(companyManageConfig);
        }
        return result;
    }

    @Override
    public int saveBatch(List<CompanyManageConfig> companyManageConfigs) {
        int result = 0;
        if (null != companyManageConfigs && companyManageConfigs.size() > 0) {
            result = companyManageConfigMapper.insertBatch(companyManageConfigs);
        }
        return result;
    }

    @Override
    public int modify(CompanyManageConfig companyManageConfig) {
        int result = 0;
        if (null != companyManageConfig) {
            result = companyManageConfigMapper.update(companyManageConfig);
        }
        return result;
    }

    @Override
    public int delete(Integer companyManageConfigId) {
        int result = 0;
        if (companyManageConfigId > 0) {
            result = companyManageConfigMapper.delete(companyManageConfigId);
        }
        return result;
    }

    @Override
    public int deleteByIds(Integer[] companyManageConfigIds) {
        int result = 0;
        if (companyManageConfigIds.length > 0) {
            result = companyManageConfigMapper.deleteByIds(companyManageConfigIds);
        }
        return result;
    }

    @Override
    public CompanyManageConfig findById(Integer companyManageConfigId) {
        return companyManageConfigMapper.queryByCompanyManageConfigId(companyManageConfigId);
    }

    @Override
    public CompanyManageConfig findByCompanyAndGroupId(Integer companyId, Integer groupId) {
        return companyManageConfigMapper.queryByCompanyAndGroupId(companyId, groupId);
    }

    @Override
    public List<CompanyManageConfig> findAllCompanyManageConfig() {
        return companyManageConfigMapper.queryAllCompanyManageConfig();
    }

    @Override
    public List<CompanyManageConfig> findByCnd(CompanyManageConfig companyManageConfig) {
        if (null != companyManageConfig) {
            return companyManageConfigMapper.queryByCnd(companyManageConfig);
        } else {
            return null;
        }
    }
}