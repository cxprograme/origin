package com.codecrane.dbr.extract.service;

import java.util.List;
import com.codecrane.dbr.extract.entity.CompanyRandom;

 /**
 * 企业随机抽取纪录信息 服务接口
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 * <br/>
 * <br/>
 */
public interface CompanyRandomService{

	/**
	 * 新增 企业随机抽取纪录信息
	 * @param companyRandom
	 * @return
	 */
	 int save(CompanyRandom companyRandom);

	/**
	 * 批量新增 企业随机抽取纪录信息
	 * @param companyRandoms
	 * @return
	 */
	 int saveBatch(List<CompanyRandom> companyRandoms);

	/**
	 * 修改 企业随机抽取纪录信息
	 * @param companyRandom
	 * @return
	 */
	 int modify(CompanyRandom companyRandom);

	/**
	 * 删除 企业随机抽取纪录信息
	 * @param companyRandomId
	 * @return
	 */
	 int delete(Integer companyRandomId);

	/**
	 * 批量删除 企业随机抽取纪录信息
	 * @param companyRandomIds
	 * @return
	 */
	 int deleteByIds(Integer[] companyRandomIds);

	 /**
	  * 删除指定批次 企业随机抽取记录
	  * @param batchNo
	  * @return
      */
	 int deleteByBatchNo(String batchNo);

	/**
	 * 查询指定 企业随机抽取纪录信息
	 * @param id
	 * @return 企业随机抽取纪录信息
	 */
	 CompanyRandom findById(Integer id);
	
	/**
	 * 查询所有 企业随机抽取纪录信息
	 * @return
	 */
	 List<CompanyRandom> findAllCompanyRandom();


	/**
	 * 多条件查询 企业随机抽取纪录信息
	 * @param companyRandom
	 * @return
	 */
	 List<CompanyRandom> findByCnd(CompanyRandom companyRandom);


	 /**
	  * 分组查询指定管理机构抽取纪录
	  * @param groupId
	  * @return
      */
	 List<CompanyRandom> findByGrouped(Integer groupId);

	 /**
	  * 按企业类型 统计指定管理机构指定年份的抽查企业总数
	  * @param groupId
	  * @param year
      * @return
      */
	 List<CompanyRandom> findCountByCompanyType(Integer groupId,Integer year);
}