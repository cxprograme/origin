package com.codecrane.core.power.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


 /**
 * 角色与权限关联信息
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 * <br/>
 * <br/>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RelRolePermission implements Serializable{
	
	private static final long serialVersionUID = 1L;

	/**
	 * 角色编号
	 */
	private Long roleId;
	/**
	 * 权限编号
	 */
	private Long permissionId;

}