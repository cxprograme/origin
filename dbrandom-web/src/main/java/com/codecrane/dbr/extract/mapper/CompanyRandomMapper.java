package com.codecrane.dbr.extract.mapper;

import com.codecrane.dbr.extract.entity.CompanyRandom;
import com.codecrane.dbr.manageobj.entity.Company;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 企业随机抽取纪录信息 数据库操作接口
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
public interface CompanyRandomMapper {

    /**
     * 新增 企业随机抽取纪录信息
     *
     * @param companyRandom
     * @return
     */
    int insert(CompanyRandom companyRandom);

    /**
     * 批量新增 企业随机抽取纪录信息
     *
     * @param companyRandoms
     * @return
     */
    int insertBatch(List<CompanyRandom> companyRandoms);

    /**
     * 更新 企业随机抽取纪录信息
     *
     * @param companyRandom
     * @return
     */
    int update(CompanyRandom companyRandom);

    /**
     * 删除 企业随机抽取纪录信息
     *
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 批量删除 企业随机抽取纪录信息
     *
     * @param idList
     * @return
     */
    int deleteByIds(Integer[] idList);

    /**
     * 删除指定批次 企业随机抽取记录
     * @param batchNo
     * @return
     */
    int deleteByBatchNo(String batchNo);

    /**
     * 查询指定 企业随机抽取纪录信息
     *
     * @param id
     * @return 企业随机抽取纪录信息
     */
    CompanyRandom queryByCompanyRandomId(Integer id);

    /**
     * 查询所有 企业随机抽取纪录信息
     */
    List<CompanyRandom> queryAllCompanyRandom();

    /**
     * 多条件查询 企业随机抽取纪录信息
     */
    List<CompanyRandom> queryByCnd(CompanyRandom companyRandom);

    /**
     * 分组查询指定管理机构抽取纪录
     * @param groupId
     * @return
     */
    List<CompanyRandom> queryByGrouped(Integer groupId);

    /**
     * 按企业类型 统计指定管理机构指定年份的抽查企业总数
     * @param groupId
     * @param year
     * @return
     */
    List<CompanyRandom> queryCountByCompanyType(@Param("groupId") Integer groupId, @Param("year") Integer year);
}