package com.codecrane.core.power.service;

import com.codecrane.core.power.entity.PowerPermission;
import com.codecrane.core.power.entity.RelRolePermission;

import java.util.List;

/**
 * 权限信息表 服务接口
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
public interface PowerPermissionService {

    /**
     * 新增 权限信息表
     *
     * @param powerPermission
     * @return
     */
    int save(PowerPermission powerPermission);

    /**
     * 批量新增 权限信息表
     *
     * @param powerPermissions
     * @return
     */
    int saveBatch(List<PowerPermission> powerPermissions);

    /**
     * 保存角色与权限关系
     * @param relRolePermission
     * @return
     */
    int saveRelRolePermission(RelRolePermission relRolePermission);

    /**
     * 批量保存角色与权限关系
     * @param relRolePermissions
     * @param roleId -1 根据权限删除
     * @param permissionId -1 根据角色删除
     * @return
     */
    int batchSaveRelRolePermission(List<RelRolePermission> relRolePermissions,long roleId,long permissionId);

    /**
     * 删除角色与权限关系
     * @param roleId -1 根据权限删除
     * @param permissionId -1 根据角色删除
     * @return
     */
    int deleteRelRolePermission(long roleId,long permissionId);

    /**
     * 修改 权限信息表
     *
     * @param powerPermission
     * @return
     */
    int modify(PowerPermission powerPermission);

    /**
     * 删除 权限信息表
     *
     * @param powerPermissionId
     * @return
     */
    int delete(long powerPermissionId);

    /**
     * 批量删除 权限信息表
     *
     * @param idList
     * @return
     */
    int deleteByIds(long[] powerPermissionIds);

    /**
     * 查询指定 权限信息表
     *
     * @param id
     * @return 权限信息表
     */
    PowerPermission findById(long id);

    /**
     * 查询所有 权限信息表
     *
     * @return
     */
    List<PowerPermission> findAllPermission();

    /**
     * 查询指定类型的权限
     * @param permissionType
     * @return
     */
    List<PowerPermission> findByPermissionType(int permissionType);

    /**
     * 查询指定用户关联权限
     *
     * @param userId
     * @param permissionType 权限类型 -1 全部 0 普通权限 1 菜单 2 操作
     * @return
     */
    List<PowerPermission> findByUserId(long userId,int permissionType);

    /**
     * 查询指定角色关联权限
     *
     * @param roleId
     * @return
     */
    List<PowerPermission> findByRoleId(long roleId);

    /**
     * 查询指定组织机构关联权限
     *
     * @param groupId
     * @return
     */
    List<PowerPermission> findByGroupId(long groupId);

    /**
     * 查询指定菜单权限
     *
     * @param menuId
     * @return
     */
    PowerPermission findByMenuId(long menuId);
}