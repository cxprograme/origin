package com.codecrane.dbr.plan.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


 /**
 * 年度执法计划
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 * <br/>
 * <br/>
 */
 @Data
 @AllArgsConstructor
 @NoArgsConstructor
public class YearPlan implements Serializable{
	
	private static final long serialVersionUID = 1L;

	/**
	 * 年度计划编号
	 */
	private Integer id;
	/**
	 * 年份
	 */
	private String year;
	/**
	 * 管理机构编号
	 */
	private Integer groupId;

	 /**
	  * 管理机构名称
	  */
	 private String groupName;

	/**
	 * 年计划总数
	 */
	private Integer yearTotal;
	/**
	 * 重点企业数量
	 */
	private Integer importantTotal;
	/**
	 * 一般企业数量
	 */
	private Integer normalTotal;
	/**
	 * 人数
	 */
	private Integer memberNum;
	/**
	 * 抽查比例
	 */
	private Float checkPercent;
	/**
	 * 创建时间
	 */
	private Date createDate;
	/**
	 * 修改时间
	 */
	private Date modifyDate;
	/**
	 * 删除标志
	 */
	private Integer deleted;

}