package com.codecrane.dbr.enforcement.service;

import com.codecrane.dbr.enforcement.entity.ExecuteDetail;

import java.util.List;

 /**
 * 执法反馈处理纪录 服务接口
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 * <br/>
 * <br/>
 */
public interface ExecuteDetailService{

	/**
	 * 新增 执法反馈处理纪录
	 * @param executeDetail
	 * @return
	 */
	 int save(ExecuteDetail executeDetail);

	/**
	 * 批量新增 执法反馈处理纪录
	 * @param executeDetails
	 * @return
	 */
	 int saveBatch(List<ExecuteDetail> executeDetails);

	/**
	 * 修改 执法反馈处理纪录
	 * @param executeDetail
	 * @return
	 */
	 int modify(ExecuteDetail executeDetail);

	 /**
	  * 回复执法反馈任务
	  * @param executeDetail
	  * @return
      */
	 int dealFeedback(ExecuteDetail executeDetail);

	 /**
	  * 自行处理执法纪录
	  * @param executeDetail
	  * @return
      */
	 int dealSelf(ExecuteDetail executeDetail);

	/**
	 * 删除 执法反馈处理纪录
	 * @param executeDetailId
	 * @return
	 */
	 int delete(Integer executeDetailId);

	/**
	 * 批量删除 执法反馈处理纪录
	 * @param executeDetailIds
	 * @return
	 */
	 int deleteByIds(Integer[] executeDetailIds);

	/**
	 * 查询指定 执法反馈处理纪录
	 * @param id
	 * @return 执法反馈处理纪录
	 */
	 ExecuteDetail findById(Integer id);
	
	/**
	 * 查询所有 执法反馈处理纪录
	 * @return
	 */
	 List<ExecuteDetail> findAllExecuteDetail();


	/**
	 * 多条件查询 执法反馈处理纪录
	 * @param executeDetail
	 * @return
	 */
	 List<ExecuteDetail> findByCnd(ExecuteDetail executeDetail);
}