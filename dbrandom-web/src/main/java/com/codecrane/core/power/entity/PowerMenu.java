package com.codecrane.core.power.entity;

import lombok.*;

/**
 * 菜单信息表
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
public class PowerMenu extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 上级菜单编号
	 */
	private Long menuPid;

	/**
	 * 菜单层级
	 */
	private Integer menuLevel;

	/**
	 * 菜单路径(层级路径)
	 */
	private String menuPath;

	/**
	 * 菜单名称
	 */
	private String menuName;

	/**
	 * 上级菜单名称
	 */
	private String parentMenuName;

	/**
	 * 菜单编码
	 */
	private String menuCode;
	/**
	 * 菜单地址
	 */
	private String menuUrl;

	/**
	 * 菜单图标
	 */
	private String menuIcon;

	/**
	 * 根节点标志
	 */
	private Integer isLeaf;
	
	/**
	 * 菜单对应权限
	 */
	private PowerPermission powerPermission;

}