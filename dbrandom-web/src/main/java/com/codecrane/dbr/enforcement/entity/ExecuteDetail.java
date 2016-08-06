package com.codecrane.dbr.enforcement.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;


/**
 * 执法反馈处理纪录
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 * <br/>
 * <br/>
 */
 @Data
 @AllArgsConstructor
 @NoArgsConstructor
public class ExecuteDetail implements Serializable{
	
	private static final long serialVersionUID = 1L;

	/**
	 * 纪录编号
	 */
	private Integer id;

	/**
	 * 对应反馈编号
	 */
	private Integer feedbackId;

	/**
	 * 处理机构编号
	 */
	private Integer executeGroupId;

	/**
	 * 处理机构名称
	 */
	private String executeGroupName;

	/**
	 * 分发机构编号
	 */
	private Integer distributeGroupId;

	/**
	 * 分发机构名称
	 */
	private String distributeGroupName;

	/**
	 * 处理意见
	 */
	private String executeDetail;

	/**
	 * 分发意见
	 */
	private String distributeDetail;

	/**
	 * 限办日期
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endDate;

	/**
	 * 处理状态 0:待处理 1:已回复2:已办结
	 */
	private Integer status;

	/**
	 * 创建时间
	 */
	private Date createDate;

	/**
	 * 修改时间
	 */
	private Date modifyDate;

}