package com.codecrane.core.power.mapper;

import com.codecrane.core.power.entity.PowerRole;
import com.codecrane.core.power.entity.RelUserRole;

import java.util.List;

/**
 * 角色信息表 数据库操作接口
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
public interface PowerRoleMapper {

    /**
     * 新增 角色信息表
     *
     * @param powerRole
     * @return
     */
    int insert(PowerRole powerRole);

    /**
     * 批量新增 角色信息表
     *
     * @param powerRoles
     * @return
     */
    int insertBatch(List<PowerRole> powerRoles);

    /**
     * 新增用户与角色关联
     * @param relUserRole
     * @return
     */
    int insertRelUserRole(RelUserRole relUserRole);

    /**
     * 批量新增用户与角色关联
     * @param relUserRoles
     * @return
     */
    int batchInsertRelUserRole(List<RelUserRole> relUserRoles);

    /**
     * 更新 角色信息表
     *
     * @param powerRole
     * @return
     */
    int update(PowerRole powerRole);

    /**
     * 删除 角色信息表
     *
     * @param id
     * @return
     */
    int delete(long id);

    /**
     * 批量删除 角色信息表
     *
     * @param idList
     * @return
     */
    int deleteByIds(long[] idList);

    /**
     * 删除指定用户与角色关系
     * @param userId
     * @return
     */
    int deleteRelUserRoleByUserId(long userId);

    /**
     * 删除指定角色与用户关系
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
    PowerRole queryByPowerRoleId(long id);

    /**
     * 查询所有 角色信息表
     */
    List<PowerRole> queryAllPowerRole();

    /**
     * 查询指定用户关联的角色信息
     *
     * @param userId
     * @return
     */
    List<PowerRole> queryByUserId(long userId);
}