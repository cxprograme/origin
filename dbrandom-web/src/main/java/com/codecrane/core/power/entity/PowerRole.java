package com.codecrane.core.power.entity;

import lombok.*;

/**
 * 角色信息表
 * 
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1 <br/>
 *          <br/>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper = true)
public class PowerRole extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 角色名称
	 */
	private String roleName;
	/**
	 * 角色描述
	 */
	private String roleDesc;
	/**
	 * 启用标志
	 */
	private Integer enabled;

}