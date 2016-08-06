package com.codecrane.dbr.manageobj.mapper;

import com.codecrane.dbr.manageobj.entity.CompanyPoint;

import java.util.List;

/**
 * 企业监管点位信息 数据库操作接口
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
public interface CompanyPointMapper {

    /**
     * 新增 企业监管点位信息
     *
     * @param companyPoint
     * @return
     */
    int insert(CompanyPoint companyPoint);

    /**
     * 批量新增 企业监管点位信息
     *
     * @param companyPoints
     * @return
     */
    int insertBatch(List<CompanyPoint> companyPoints);

    /**
     * 更新 企业监管点位信息
     *
     * @param companyPoint
     * @return
     */
    int update(CompanyPoint companyPoint);

    /**
     * 删除 企业监管点位信息
     *
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 批量删除 企业监管点位信息
     *
     * @param idList
     * @return
     */
    int deleteByIds(Integer[] idList);

    /**
     * 删除指定管理机构下的企业位点
     * @param groupId
     * @return
     */
    int deleteByGroupId(Integer groupId);

    /**
     * 查询指定 企业监管点位信息
     *
     * @param id
     * @return 企业监管点位信息
     */
    CompanyPoint queryByCompanyPointId(Integer id);

    /**
     * 查询所有 企业监管点位信息
     */
    List<CompanyPoint> queryAllCompanyPoint();


    /**
     * 多条件查询 企业监管点位信息
     */
    List<CompanyPoint> queryByCnd(CompanyPoint companyPoint);
}