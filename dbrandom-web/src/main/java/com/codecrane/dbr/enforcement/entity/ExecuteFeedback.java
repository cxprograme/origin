package com.codecrane.dbr.enforcement.entity;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.JSONArray;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;


/**
 * 执法反馈信息
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 * <br/>
 * <br/>
 */
 @Data
 @AllArgsConstructor
 @NoArgsConstructor
public class ExecuteFeedback implements Serializable{
	
	private static final long serialVersionUID = 1L;

	/**
	 * 反馈编号
	 */
	private Integer id;
	/**
	 * 反馈对应检查纪录编号
	 */
	private String planId;
	/**
	 * 检查内容
	 */
	private String checkContent;
	/**
	 * 处理状态 0 未填报 1 未发现异常 2 责令整改 3 立案查处
	 */
	private Integer processStatus;
	/**
	 * 检查日期
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date checkDate;
	/**
	 * 反馈附件
	 */
	private JSONArray attachFile;

	/**
	 * 反馈附件JSON字符串
	 */
	private String attachFileJson;

	/**
	 * 反馈状态0 待处理 1 已办结 2已回复
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

	/**
	 * 企业编号
	 */
	private Integer companyId;

	/**
	 * 企业名称
	 */
	private String companyName;

	/**
	 * 管理机构编号
	 */
	private Integer groupId;

	/**
	 * 管理机构名称
	 */
	private String groupName;

	/**
	 * 检查开始事件
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;

	/**
	 * 检查结束时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;

	/**
	 * 登记人编号
	 */
	private Integer executorId;

	/**
	 * 登记人姓名
	 */
	private String executorName;

	private Integer feedbackDetailId;

}