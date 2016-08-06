package com.codecrane.dbr.enforcement.mapper;

import com.codecrane.dbr.enforcement.entity.ExecuteFeedback;

import java.util.List;

 /**
 * 执法反馈信息 数据库操作接口
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 * <br/>
 * <br/>
 */
public interface ExecuteFeedbackMapper{

	/**
	 * 新增 执法反馈信息
	 * @param executeFeedback
	 * @return
	 */
	 int insert(ExecuteFeedback executeFeedback);

	/**
	 * 批量新增 执法反馈信息
	 * @param executeFeedbacks
	 * @return
	 */
	 int insertBatch(List<ExecuteFeedback> executeFeedbacks);
	
	/**
	 * 更新 执法反馈信息
	 * @param executeFeedback
	 * @return
	 */
	 int update(ExecuteFeedback executeFeedback);
	
	/**
	 * 删除 执法反馈信息
	 * @param id
	 * @return
	 */
	 int delete(Integer id);
	
	/**
	 * 批量删除 执法反馈信息
	 * @param idList
	 * @return
	 */
	 int deleteByIds(Integer[] idList);
	
	/**
	 * 查询指定 执法反馈信息
	 * @param id
	 * @return 执法反馈信息
	 */
	 ExecuteFeedback queryById(Integer id);

	/**
	 * 查询所有 执法反馈信息
	 */
	 List<ExecuteFeedback> queryAllExecuteFeedback();


	/**
	 * 多条件查询 执法反馈信息
	 */
	 List<ExecuteFeedback> queryByCnd(ExecuteFeedback executeFeedback);

	 /**
	  * 多条件查询待处理执法反馈
	  * @param executeFeedback
	  * @return
      */
	 List<ExecuteFeedback> queryTodoByCnd(ExecuteFeedback executeFeedback);

	 /**
	  * 多条件查询已分发执法反馈
	  * @param executeFeedback
	  * @return
	  */
	 List<ExecuteFeedback> queryDistributeByCnd(ExecuteFeedback executeFeedback);
}