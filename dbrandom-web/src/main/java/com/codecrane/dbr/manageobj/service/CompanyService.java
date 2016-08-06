package com.codecrane.dbr.manageobj.service;


import com.codecrane.dbr.manageobj.entity.Company;

import java.util.List;

/**
 * 企业单位基本信息 服务接口
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
public interface CompanyService {

    /**
     * 新增 企业单位基本信息
     *
     * @param company
     * @return
     */
    int save(Company company);

    /**
     * 批量新增 企业单位基本信息
     *
     * @param companys
     * @return
     */
    int saveBatch(List<Company> companys);

    /**
     * 批量导入
     * @param companys
     * @return
     */
    int importBatch(List<Company> companys);

    /**
     * 修改 企业单位基本信息
     *
     * @param company
     * @return
     */
    int modify(Company company);

    /**
     * 删除 企业单位基本信息
     *
     * @param companyId
     * @return
     */
    int delete(Integer companyId);

    /**
     * 批量删除 企业单位基本信息
     *
     * @param companyIds
     * @return
     */
    int deleteByIds(Integer[] companyIds);

    /**
     * 查询指定 企业单位基本信息
     *
     * @param id
     * @return 企业单位基本信息
     */
    Company findById(Integer id);

    /**
     * 查询指定 管理机构的企业单位基本信息
     * @param companyId
     * @param groupId
     * @return
     */
    Company findByCompanyAndGroupId(Integer companyId,Integer groupId);

    /**
     * 查询所有 企业单位基本信息
     *
     * @return
     */
    List<Company> findAllCompany();


    /**
     * 多条件查询 企业单位基本信息
     *
     * @param company
     * @return
     */
    List<Company> findByCnd(Company company);

    /**
     * /**
     * 多条件查询 企业单位基本信息(包含管理机构下子机构)
     *
     * @param company
     * @return
     */
    List<Company> findByCndWithGroup(Company company);

    /**
     * /**
     * 多条件查询 企业单位基本信息(不含管理机构下子机构)
     *
     * @param company
     * @return
     */
    List<Company> findByCndWithGroupNoPoints(Company company);
}