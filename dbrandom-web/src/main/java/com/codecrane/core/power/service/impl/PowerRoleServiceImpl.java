package com.codecrane.core.power.service.impl;

import com.codecrane.core.power.entity.PowerRole;
import com.codecrane.core.power.entity.RelUserRole;
import com.codecrane.core.power.service.PowerRoleService;
import com.codecrane.core.power.mapper.PowerRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * 角色信息表 服务
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
@Service
public class PowerRoleServiceImpl implements PowerRoleService {

    @Autowired
    private PowerRoleMapper powerRoleMapper;

    @Override
    public int save(PowerRole powerRole) {
        int result = 0;
        if (null != powerRole) {
            result = powerRoleMapper.insert(powerRole);
        }
        return result;
    }

    @Override
    public int saveBatch(List<PowerRole> powerRoles) {
        int result = 0;
        if (null != powerRoles && powerRoles.size() > 0) {
            result = powerRoleMapper.insertBatch(powerRoles);
        }
        return result;
    }

    @Override
    public int saveRelUserRole(RelUserRole relUserRole) {
        int result = 0;
        if (null != relUserRole) {
            result = powerRoleMapper.insertRelUserRole(relUserRole);
        }
        return result;
    }

    @Override
    public int batchSaveRelUserRole(List<RelUserRole> relUserRoles) {
        int result = 0;
        if (null != relUserRoles && relUserRoles.size() > 0) {
            result = powerRoleMapper.batchInsertRelUserRole(relUserRoles);
        }
        return result;
    }

    @Override
    @Transactional
    public int batchSaveRelUserRoleWithDel(List<RelUserRole> relUserRoles, long roleId, long userId) {
        int result = 0;
        if (null != relUserRoles && relUserRoles.size() > 0) {
            //删除关系
            if( roleId == -1 ){
                powerRoleMapper.deleteRelUserRoleByUserId(userId);
            }else if(userId == -1){
                powerRoleMapper.deleteRelUserRoleByRoleId(roleId);
            }

            result = powerRoleMapper.batchInsertRelUserRole(relUserRoles);
        }
        return result;
    }

    @Override
    public int modify(PowerRole powerRole) {
        int result = 0;
        if (null != powerRole) {
            result = powerRoleMapper.update(powerRole);
        }
        return result;
    }

    @Override
    public int delete(long powerRoleId) {
        int result = 0;
        if (powerRoleId > 0) {
            result = powerRoleMapper.delete(powerRoleId);
        }
        return result;
    }

    @Override
    public int deleteByIds(long[] powerRoleIds) {
        int result = 0;
        if (powerRoleIds.length > 0) {
            result = powerRoleMapper.deleteByIds(powerRoleIds);
        }
        return result;
    }

    @Override
    public int deleteRelUserRoleByUserId(long userId) {
        return 0;
    }

    @Override
    public int deleteRelUserRoleByRoleId(long roleId) {
        return 0;
    }

    @Override
    public PowerRole findById(long powerRoleId) {
        return powerRoleMapper.queryByPowerRoleId(powerRoleId);
    }

    @Override
    public List<PowerRole> findAllPowerRole() {
        return powerRoleMapper.queryAllPowerRole();
    }

    @Override
    public List<PowerRole> findByUserId(long userId) {
        return powerRoleMapper.queryByUserId(userId);
    }

    @Override
    public List<PowerRole> findByGroupId(long groupId) {
        //TODO
        return null;
    }

    @Override
    public List<PowerRole> findByPermissionId(long permissionId) {
        //TODO
        return null;
    }

    @Override
    public List<PowerRole> findByMenuId(long menuId) {
        //TODO
        return null;
    }
}