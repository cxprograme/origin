package com.codecrane.core.power.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * 用户信息表
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
public class PowerUser extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 用户账号
	 */
	private String userAccount;
	/**
	 * 用户登录密码
	 */
	private String userPassword;
	/**
	 * 用户盐
	 */
	private String userSalt;
	/**
	 * 用户昵称
	 */
	private String userNickname;
	/**
	 * 用户姓名
	 */
	private String userRealname;
	/**
	 * 用户性别
	 */
	private Integer userSex;
	/**
	 * 用户年龄
	 */
	private Integer userAge;
	/**
	 * 出生日期
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date userBirthday;
	/**
	 * 用户手机
	 */
	private String userPhone;
	/**
	 * 用户邮箱
	 */
	private String userEmail;
	/**
	 * 锁定标志
	 */
	private Integer locked;
	/**
	 * 启用标志
	 */
	private Integer enabled;
	/**
	 * 最后登录时间
	 */
	private Date lastLoginDate;
	/**
	 * 登录失败时间
	 */
	private Date failedLoginDate;
	/**
	 * 登录失败次数
	 */
	private Integer failedCount;

	/**
	 * 所属组织机构编号(临时)
	 */
	private Long groupId;

	private List<PowerMenu> menus;

	private List<PowerPermission> permissions;

	private List<PowerRole> roles;

	/**
	 * 复杂关系下的用户所属组织机构
	 */
	private List<PowerGroup> groups;

}