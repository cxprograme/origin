package com.codecrane.dbr.manageobj.mapper;

import com.codecrane.dbr.manageobj.entity.CompanyManageConfig;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 企业管理模式信息 数据库操作接口
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
public interface CompanyManageConfigMapper {

    /**
     * 新增 企业管理模式信息
     *
     * @param companyManageConfig
     * @return
     */
    int insert(CompanyManageConfig companyManageConfig);

    /**
     * 批量新增 企业管理模式信息
     *
     * @param companyManageConfigs
     * @return
     */
    int insertBatch(List<CompanyManageConfig> companyManageConfigs);

    /**
     * 更新 企业管理模式信息
     *
     * @param companyManageConfig
     * @return
     */
    int update(CompanyManageConfig companyManageConfig);

    /**
     * 删除 企业管理模式信息
     *
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 批量删除 企业管理模式信息
     *
     * @param idList
     * @return
     */
    int deleteByIds(Integer[] idList);

    /**
     * 查询指定 企业管理模式信息
     *
     * @param id
     * @return 企业管理模式信息
     */
    CompanyManageConfig queryByCompanyManageConfigId(Integer id);

    /**
     * 查询指定 企业和管理机构管理模式
     * @param companyId
     * @param groupId
     * @return
     */
    CompanyManageConfig queryByCompanyAndGroupId(@Param("companyId") Integer companyId,@Param("groupId") Integer groupId);

    /**
     * 查询所有 企业管理模式信息
     */
    List<CompanyManageConfig> queryAllCompanyManageConfig();


    /**
     * 多条件查询 企业管理模式信息
     */
    List<CompanyManageConfig> queryByCnd(CompanyManageConfig companyManageConfig);
}