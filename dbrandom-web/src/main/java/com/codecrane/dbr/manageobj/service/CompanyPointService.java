package com.codecrane.dbr.manageobj.service;


import com.codecrane.dbr.manageobj.entity.CompanyPoint;

import java.util.List;

/**
 * 企业监管点位信息 服务接口
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
public interface CompanyPointService {

    /**
     * 新增 企业监管点位信息
     *
     * @param companyPoint
     * @return
     */
    int save(CompanyPoint companyPoint);

    /**
     * 批量新增 企业监管点位信息
     *
     * @param companyPoints
     * @return
     */
    int saveBatch(List<CompanyPoint> companyPoints);

    /**
     * 修改 企业监管点位信息
     *
     * @param companyPoint
     * @return
     */
    int modify(CompanyPoint companyPoint);

    /**
     * 删除 企业监管点位信息
     *
     * @param companyPointId
     * @return
     */
    int delete(Integer companyPointId);

    /**
     * 批量删除 企业监管点位信息
     *
     * @param companyPointIds
     * @return
     */
    int deleteByIds(Integer[] companyPointIds);

    /**
     * 删除指定管理机构下的企业位点
     * @param groupId 管理机构编号
     * @return
     */
    int deleteByGroupId(Integer groupId);

    /**
     * 查询指定 企业监管点位信息
     *
     * @param id
     * @return 企业监管点位信息
     */
    CompanyPoint findById(Integer id);

    /**
     * 查询所有 企业监管点位信息
     *
     * @return
     */
    List<CompanyPoint> findAllCompanyPoint();


    /**
     * 多条件查询 企业监管点位信息
     *
     * @param companyPoint
     * @return
     */
    List<CompanyPoint> findByCnd(CompanyPoint companyPoint);
}