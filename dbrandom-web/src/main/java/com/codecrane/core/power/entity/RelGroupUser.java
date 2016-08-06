package com.codecrane.core.power.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


 /**
 * 组织机构与用户关联信息
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 * <br/>
 * <br/>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RelGroupUser implements Serializable{
	
	private static final long serialVersionUID = 1L;

	/**
	 * 组织机构编号
	 */
	private Long groupId;
	/**
	 * 用户编号
	 */
	private Long userId;

}