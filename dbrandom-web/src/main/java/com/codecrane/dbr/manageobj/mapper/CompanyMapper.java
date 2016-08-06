package com.codecrane.dbr.manageobj.mapper;

import com.codecrane.dbr.manageobj.entity.Company;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 企业单位基本信息 数据库操作接口
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
public interface CompanyMapper {

    /**
     * 新增 企业单位基本信息
     *
     * @param company
     * @return
     */
    int insert(Company company);

    /**
     * 批量新增 企业单位基本信息
     *
     * @param companys
     * @return
     */
    int insertBatch(List<Company> companys);

    /**
     * 更新 企业单位基本信息
     *
     * @param company
     * @return
     */
    int update(Company company);

    /**
     * 删除 企业单位基本信息
     *
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 批量删除 企业单位基本信息
     *
     * @param idList
     * @return
     */
    int deleteByIds(Integer[] idList);

    /**
     * 查询指定 企业单位基本信息
     *
     * @param id
     * @return 企业单位基本信息
     */
    Company queryByCompanyId(Integer id);

    /**
     * 查询指定  管理机构的企业单位基本信息
     *
     * @param companyId 企业编号
     * @param groupId   管理机构编号
     * @return
     */
    Company queryByCompanyAndGroupId(@Param("companyId") Integer companyId, @Param("groupId") Integer groupId);

    /**
     * 查询所有 企业单位基本信息
     */
    List<Company> queryAllCompany();


    /**
     * 多条件查询 企业单位基本信息
     */
    List<Company> queryByCnd(Company company);

    /**
     * 多条件查询 企业单位基本信息(包含管理机构下子机构)
     *
     * @param company
     * @return
     */
    List<Company> queryByCndWithGroup(Company company);

    /**
     * 多条件查询 企业单位基本信息(不含管理机构下子机构)
     *
     * @param company
     * @return
     */
    List<Company> queryByCndWithGroupNoPoints(Company company);
}