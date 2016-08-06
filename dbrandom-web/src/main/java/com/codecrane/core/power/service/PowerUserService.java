package com.codecrane.core.power.service;

import com.codecrane.core.power.entity.PowerUser;

import java.util.List;

/**
 * 用户信息 服务接口
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
public interface PowerUserService {

    /**
     * 新增 用户信息
     *
     * @param powerUser
     * @return
     */
    int save(PowerUser powerUser);

    /**
     * 批量新增 用户信息
     *
     * @param powerUsers
     * @return
     */
    int saveBatch(List<PowerUser> powerUsers);

    /**
     * 修改 用户信息
     *
     * @param powerUser
     * @return
     */
    int modify(PowerUser powerUser);

    /**
     * 删除 用户信息
     *
     * @param powerUserId
     * @return
     */
    int delete(long powerUserId);

    /**
     * 批量删除 用户信息
     *
     * @param powerUserIds
     * @return
     */
    int deleteByIds(long[] powerUserIds);

    /**
     * 查询指定 用户信息
     *
     * @param id
     * @return 用户信息
     */
    PowerUser findById(long id);

    /**
     * 查询所有 用户信息
     *
     * @return
     */
    List<PowerUser> findAllPowerUser();

    /**
     * 查询指定组织机构关联的用户
     *
     * @param groupId
     * @return
     */
    List<PowerUser> findUsersByGroupId(long groupId);

    /**
     * 查询指定角色关联的用户
     *
     * @param roleId
     * @return
     */
    List<PowerUser> finUsersByRoleId(long roleId);

    /**
     * 查询指定权限关联的用户
     *
     * @param permissionId
     * @return
     */
    List<PowerUser> findUsersByPermissionId(long permissionId);

    /**
     * 查询指定菜单关联的用户
     *
     * @param menuId
     * @return
     */
    List<PowerUser> findUsersByMenuId(long menuId);

    /**
     * 用户登录
     *
     * @param userAccount  账号
     * @param userPassword 密码
     * @param vcode        验证码
     * @return 1 登录成功 0 账号、密码为空 -2 密码错误 -1 账号不存在
     */
    int doLoginAuth(String userAccount, String userPassword, String vcode);

    /**
     * 用户注销
     *
     * @param userId
     */
    void doLogout(long userId);

    /**
     * 用户修改密码
     *
     * @param oldPassword
     * @param newPassword
     * @return -1 账号或旧密码或新密码为空 0 旧密码不正确 1 修改成功
     */
    int changePassword(String account, String oldPassword, String newPassword);

    /**
     * 根据账号查询用户信息
     *
     * @param userAccount
     * @return
     */
    PowerUser findByUserAccount(String userAccount);

    /**
     * 获取当前已登录用户对象
     * @return
     */
    PowerUser getCurrentUserFromShiro();

}