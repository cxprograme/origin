package com.codecrane.core.power.service;

import com.codecrane.core.power.entity.PowerRole;
import com.codecrane.core.power.entity.RelUserRole;

import java.util.List;

/**
 * 角色信息表 服务接口
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
public interface PowerRoleService {

    /**
     * 新增 角色信息表
     *
     * @param powerRole
     * @return
     */
    int save(PowerRole powerRole);

    /**
     * 批量新增 角色信息表
     *
     * @param powerRoles
     * @return
     */
    int saveBatch(List<PowerRole> powerRoles);

    /**
     * 保存用户与角色关联信息
     * @param relUserRole
     * @return
     */
    int saveRelUserRole(RelUserRole relUserRole);

    /**
     * 批量保存用户与角色关联信息
     * @param relUserRoles
     * @return
     */
    int batchSaveRelUserRole(List<RelUserRole> relUserRoles);

    /**
     * 保存用户与角色关联(保存前删除原有关系)
     * @param relUserRoles 用户与角色关系
     * @param roleId 角色编号 -1 表示根据用户编号删除
     * @param userId 用户编号 -1 表示根据角色编号删除
     * @return
     */
    int batchSaveRelUserRoleWithDel(List<RelUserRole> relUserRoles,long roleId,long userId);

    /**
     * 修改 角色信息表
     *
     * @param powerRole
     * @return
     */
    int modify(PowerRole powerRole);

    /**
     * 删除 角色信息表
     *
     * @param powerRoleId
     * @return
     */
    int delete(long powerRoleId);

    /**
     * 批量删除 角色信息表
     *
     * @param powerRoleIds
     * @return
     */
    int deleteByIds(long[] powerRoleIds);

    /**
     * 删除指定用户的角色关联
     * @param userId
     * @return
     */
    int deleteRelUserRoleByUserId(long userId);

    /**
     * 删除指定角色的用户关联
     * @param roleId
     * @return
     */
    int deleteRelUserRoleByRoleId(long roleId);

    /**
     * 查询指定 角色信息表
     *
     * @param id
     * @return 角色信息表
     */
    PowerRole findById(long id);

    /**
     * 查询所有 角色信息表
     *
     * @return
     */
    List<PowerRole> findAllPowerRole();

    /**
     * 查询指定用户关联的角色
     *
     * @param userId
     * @return
     */
    List<PowerRole> findByUserId(long userId);

    /**
     * 查询指定组织机构关联的角色
     *
     * @param groupId
     * @return
     */
    List<PowerRole> findByGroupId(long groupId);

    /**
     * 查询指定权限关联的角色
     *
     * @param permissionId
     * @return
     */
    List<PowerRole> findByPermissionId(long permissionId);

    /**
     * 查询指定菜单关联的角色
     *
     * @param menuId
     * @return
     */
    List<PowerRole> findByMenuId(long menuId);
}