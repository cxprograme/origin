package com.codecrane.dbr.enforcement.service;

import com.codecrane.dbr.enforcement.entity.ExecuteFeedback;

import java.util.List;

 /**
 * 执法反馈信息 服务接口
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 * <br/>
 * <br/>
 */
public interface ExecuteFeedbackService{

	/**
	 * 新增 执法反馈信息
	 * @param executeFeedback
	 * @return
	 */
	 int save(ExecuteFeedback executeFeedback);

	/**
	 * 批量新增 执法反馈信息
	 * @param executeFeedbacks
	 * @return
	 */
	 int saveBatch(List<ExecuteFeedback> executeFeedbacks);

	/**
	 * 修改 执法反馈信息
	 * @param executeFeedback
	 * @return
	 */
	 int modify(ExecuteFeedback executeFeedback);

	/**
	 * 删除 执法反馈信息
	 * @param executeFeedbackId
	 * @return
	 */
	 int delete(Integer executeFeedbackId);

	/**
	 * 批量删除 执法反馈信息
	 * @param executeFeedbackIds
	 * @return
	 */
	 int deleteByIds(Integer[] executeFeedbackIds);

	/**
	 * 查询指定 执法反馈信息
	 * @param id
	 * @return 执法反馈信息
	 */
	 ExecuteFeedback findById(Integer id);
	
	/**
	 * 查询所有 执法反馈信息
	 * @return
	 */
	 List<ExecuteFeedback> findAllExecuteFeedback();


	/**
	 * 多条件查询 执法反馈信息
	 * @param executeFeedback
	 * @return
	 */
	 List<ExecuteFeedback> findByCnd(ExecuteFeedback executeFeedback);

	 /**
	  * 多条件查询 待处理执法反馈信息
	  * @param executeFeedback
	  * @return
      */
	 List<ExecuteFeedback> findTodoByCnd(ExecuteFeedback executeFeedback);

	 /**
	  * 多条件查询已分发执法反馈
	  * @param executeFeedback
	  * @return
	  */
	 List<ExecuteFeedback> findDistributeByCnd(ExecuteFeedback executeFeedback);
}