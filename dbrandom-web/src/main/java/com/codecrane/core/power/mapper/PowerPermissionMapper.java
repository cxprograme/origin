package com.codecrane.core.power.mapper;

import com.codecrane.core.power.entity.PowerPermission;
import com.codecrane.core.power.entity.RelRolePermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 权限信息表 数据库操作接口
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
public interface PowerPermissionMapper {

    /**
     * 新增 权限信息表
     *
     * @param PowerPermission
     * @return
     */
    int insert(PowerPermission powerPermission);

    /**
     * 批量新增 权限信息表
     *
     * @param powerPermissions
     * @return
     */
    int insertBatch(List<PowerPermission> powerPermissions);

    /**
     * 保存角色与权限关系
     * @param relRolePermission
     * @return
     */
    int insertRelRolePermission(RelRolePermission relRolePermission);

    /**
     * 批量保存角色与权限关系
     * @param relRolePermissions
     * @return
     */
    int batchInsertRelRolePermission(List<RelRolePermission> relRolePermissions);

    /**
     * 更新 权限信息表
     *
     * @param PowerPermission
     * @return
     */
    int update(PowerPermission powerPermission);

    /**
     * 删除 权限信息表
     *
     * @param id
     * @return
     */
    int delete(long id);

    /**
     * 批量删除 权限信息表
     *
     * @param idList
     * @return
     */
    int deleteByIds(long[] idList);

    /**
     * 删除指定角色所关联的权限关系
     * @param roleId
     * @return
     */
    int deleteRelRolePermissionByRoleId(long roleId);

    /**
     * 删除指定权限所关联的角色关系
     * @param permissionId
     * @return
     */
    int deleteRelRolePermissionByPermissionId(long permissionId);

    /**
     * 查询指定 权限信息表
     *
     * @param id
     * @return 权限信息表
     */
    PowerPermission queryByPermissionId(long id);

    /**
     * 查询所有 权限信息表
     */
    List<PowerPermission> queryAllPermission();

    /**
     * 查询指定类型的权限
     *
     * @param permissionType
     * @return
     */
    List<PowerPermission> queryByPermissionType(int permissionType);

    /**
     * 查询用户拥有的权限
     * @param userId 用户编号
     * @param permissionType 权限类型 -1 全部 0 普通权限 1 菜单 2 操作
     * @return
     */
    List<PowerPermission> queryByUserId(@Param("userId") long userId, @Param("permissionType") int permissionType);

    /**
     * 查询角色拥有的权限
     * @param roleId 角色编号
     * @param permissionType 权限类型 -1 全部 0 普通权限 1 菜单 2 操作
     * @return
     */
    List<PowerPermission> queryByRoleId(@Param("roleId") long roleId,@Param("permissionType") int permissionType);
}