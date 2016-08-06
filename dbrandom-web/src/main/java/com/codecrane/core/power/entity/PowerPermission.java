package com.codecrane.core.power.entity;

import lombok.*;

/**
 * 权限信息表
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
public class PowerPermission extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 受控对象编号
	 */
	private Long privilegeId;
	/**
	 * 权限名称
	 */
	private String permissionName;
	/**
	 * 权限类型
            0普通权限
            1菜单权限
            2操作权限
	 */
	private Integer permissionType;
	/**
	 * 权限编码
	 */
	private String permissionCode;
	
	/**
	 * 权限对应菜单
	 */
	private PowerMenu powerMenu;
	
	/**
	 * 权限对应操作
	 */
	private PowerOperation powerOperation;

}