package com.codecrane.dbr.rule.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


 /**
 * 抽取规则分类比重配置
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 * <br/>
 * <br/>
 */
 @Data
 @AllArgsConstructor
 @NoArgsConstructor
public class ConfigRuleType implements Serializable{
	
	private static final long serialVersionUID = 1L;

	/**
	 * 配置编号
	 */
	private Integer id;
	/**
	 * 所属机构编号
	 */
	private Integer groupId;
	/**
	 * 分类属性编号
	 */
	private String typeId;
	/**
	 * 比重值
	 */
	private Integer proportion;

}