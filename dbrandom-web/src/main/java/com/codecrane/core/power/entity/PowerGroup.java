package com.codecrane.core.power.entity;

import lombok.*;

/**
 * 组织机构信息表
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 * <br/>
 * <br/>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper = true)
public class PowerGroup extends BaseEntity{
	
	private static final long serialVersionUID = 1L;

	/**
	 * 上级组织机构编号
	 */
	private Long groupPid;
	/**
	 * 组织机构名称
	 */
	private String groupName;

	/**
	 * 组织机构类型
	 */
	private Integer groupType;

	/**
	 * 组织机构描述
	 */
	private String groupDesc;

	/**
	 * 上级机构名称
	 */
	private String parentGroupName;

	/**
	 * 层级关系
	 */
	private String groupLevel;

}