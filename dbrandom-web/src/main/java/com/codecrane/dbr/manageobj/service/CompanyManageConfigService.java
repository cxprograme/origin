package com.codecrane.dbr.manageobj.service;


import com.codecrane.dbr.manageobj.entity.CompanyManageConfig;

import java.util.List;

/**
 * 企业管理模式信息 服务接口
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
public interface CompanyManageConfigService {

    /**
     * 新增 企业管理模式信息
     *
     * @param companyManageConfig
     * @return
     */
    int save(CompanyManageConfig companyManageConfig);

    /**
     * 批量新增 企业管理模式信息
     *
     * @param companyManageConfigs
     * @return
     */
    int saveBatch(List<CompanyManageConfig> companyManageConfigs);

    /**
     * 修改 企业管理模式信息
     *
     * @param companyManageConfig
     * @return
     */
    int modify(CompanyManageConfig companyManageConfig);

    /**
     * 删除 企业管理模式信息
     *
     * @param companyManageConfigId
     * @return
     */
    int delete(Integer companyManageConfigId);

    /**
     * 批量删除 企业管理模式信息
     *
     * @param companyManageConfigIds
     * @return
     */
    int deleteByIds(Integer[] companyManageConfigIds);

    /**
     * 查询指定 企业管理模式信息
     *
     * @param id
     * @return 企业管理模式信息
     */
    CompanyManageConfig findById(Integer id);

    /**
     * 查询指定 企业和管理机构管理模式
     *
     * @param companyId
     * @param groupId
     * @return
     */
    CompanyManageConfig findByCompanyAndGroupId(Integer companyId, Integer groupId);

    /**
     * 查询所有 企业管理模式信息
     *
     * @return
     */
    List<CompanyManageConfig> findAllCompanyManageConfig();


    /**
     * 多条件查询 企业管理模式信息
     *
     * @param companyManageConfig
     * @return
     */
    List<CompanyManageConfig> findByCnd(CompanyManageConfig companyManageConfig);
}