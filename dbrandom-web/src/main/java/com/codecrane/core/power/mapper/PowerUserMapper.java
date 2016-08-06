package com.codecrane.core.power.mapper;

import com.codecrane.core.power.entity.RelGroupUser;
import com.codecrane.core.power.entity.PowerUser;

import java.util.List;

/**
 * 用户信息 数据库操作接口
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
public interface PowerUserMapper {

    /**
     * 新增 用户信息
     *
     * @param PowerUser
     * @return
     */
    int insert(PowerUser powerUser);

    /**
     * 批量新增 用户信息
     *
     * @param powerUsers
     * @return
     */
    int insertBatch(List<PowerUser> powerUsers);

    /**
     * 更新 用户信息
     *
     * @param PowerUser
     * @return
     */
    int update(PowerUser powerUser);

    /**
     * 删除 用户信息
     *
     * @param id
     * @return
     */
    int delete(long id);

    /**
     * 批量删除 用户信息
     *
     * @param idList
     * @return
     */
    int deleteByIds(long[] idList);

    /**
     * 查询指定 用户信息
     *
     * @param id
     * @return 用户信息
     */
    PowerUser queryByPowerUserId(long id);

    /**
     * 查询指定账号用户信息
     *
     * @param userAccount
     * @return
     */
    PowerUser queryByPowerUserAccount(String userAccount);

    /**
     * 查询所有 用户信息
     */
    List<PowerUser> queryAllPowerUser();

    /**
     * 查询指定组织机构下的用户
     *
     * @param groupId
     * @return
     */
    List<PowerUser> queryByGroupId(long groupId);

    /**
     * 查询指定角色关联的用户
     *
     * @param roleId
     * @return
     */
    List<PowerUser> queryByRoleId(long roleId);

    /**
     * 查询指定权限关联的用户
     *
     * @param permissionId
     * @return
     */
    List<PowerUser> queryByPermissionId(long permissionId);

    /**
     * 查询指定菜单关联的用户
     *
     * @param menuId
     * @return
     */
    List<PowerUser> queryByMenuId(long menuId);

    /**
     * 新增用户与组织机构关系
     * @param userId
     * @param groupId
     * @return
     */
    int insertRelGroupUser(RelGroupUser relGroupUser);

    /**
     * 批量新增用户与组织机构关系
     * @param groupUsers
     * @return
     */
    int batchInsertRelGroupUser(List<RelGroupUser> groupUsers);
}