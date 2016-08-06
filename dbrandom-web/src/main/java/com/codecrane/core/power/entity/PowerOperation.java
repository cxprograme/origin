package com.codecrane.core.power.entity;

import lombok.*;

/**
 * 功能操作信息
 * 
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1 <br/>
 *          <br/>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PowerOperation extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 操作名称
	 */
	private String operattionName;
	/**
	 * 操作编码
	 */
	private String operattionCode;

}