package com.codecrane.core.power.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


 /**
 * 用户与角色关联信息
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 * <br/>
 * <br/>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RelUserRole implements Serializable{
	
	private static final long serialVersionUID = 1L;

	/**
	 * 用户编号
	 */
	private Long userId;
	/**
	 * 角色编号
	 */
	private Long roleId;

}