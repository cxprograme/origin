package com.codecrane.core.power.service.impl;

import com.codecrane.core.power.entity.PowerPermission;
import com.codecrane.core.power.service.PowerPermissionService;
import com.codecrane.core.power.entity.RelRolePermission;
import com.codecrane.core.power.mapper.PowerPermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 权限信息表 服务
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
@Service
public class PowerPermissionServiceImpl implements PowerPermissionService {

    @Autowired
    private PowerPermissionMapper powerPermissionMapper;

    @Override
    public int save(PowerPermission powerPermission) {
        int result = 0;
        if (null != powerPermission) {
            result = powerPermissionMapper.insert(powerPermission);
        }
        return result;
    }

    @Override
    public int saveBatch(List<PowerPermission> powerPermissions) {
        int result = 0;
        if (null != powerPermissions && powerPermissions.size() > 0) {
            result = powerPermissionMapper.insertBatch(powerPermissions);
        }
        return result;
    }

    @Override
    public int saveRelRolePermission(RelRolePermission relRolePermission) {
        int result = 0;
        if (null != relRolePermission) {
            result = powerPermissionMapper.insertRelRolePermission(relRolePermission);
        }
        return result;
    }

    @Override
    public int batchSaveRelRolePermission(List<RelRolePermission> relRolePermissions, long roleId, long permissionId) {
        int result = 0;
        if (null != relRolePermissions && relRolePermissions.size() > 0) {
            deleteRelRolePermission(roleId, permissionId);
            result = powerPermissionMapper.batchInsertRelRolePermission(relRolePermissions);
        }
        return result;
    }

    @Override
    public int deleteRelRolePermission(long roleId, long permissionId) {
        int result = 0;
        if (-1 == roleId && -1 != permissionId) {
            result = powerPermissionMapper.deleteRelRolePermissionByPermissionId(permissionId);
        } else if (-1 == permissionId && -1 != roleId) {
            result = powerPermissionMapper.deleteRelRolePermissionByRoleId(roleId);
        }
        return result;
    }

    @Override
    public int modify(PowerPermission powerPermission) {
        int result = 0;
        if (null != powerPermission) {
            result = powerPermissionMapper.update(powerPermission);
        }
        return result;
    }

    @Override
    public int delete(long powerPermissionId) {
        int result = 0;
        if (powerPermissionId > 0) {
            result = powerPermissionMapper.delete(powerPermissionId);
        }
        return result;
    }

    @Override
    public int deleteByIds(long[] powerPermissionIds) {
        int result = 0;
        if (powerPermissionIds.length > 0) {
            result = powerPermissionMapper.deleteByIds(powerPermissionIds);
        }
        return result;
    }

    @Override
    public PowerPermission findById(long powerPermissionId) {
        return powerPermissionMapper.queryByPermissionId(powerPermissionId);
    }

    @Override
    public List<PowerPermission> findAllPermission() {
        return powerPermissionMapper.queryAllPermission();
    }

    @Override
    public List<PowerPermission> findByPermissionType(int permissionType) {
        return powerPermissionMapper.queryByPermissionType(permissionType);
    }

    @Override
    public List<PowerPermission> findByUserId(long userId, int permissionType) {
        return powerPermissionMapper.queryByUserId(userId, permissionType);
    }

    @Override
    public List<PowerPermission> findByRoleId(long roleId) {
        return powerPermissionMapper.queryByRoleId(roleId,-1);
    }

    @Override
    public List<PowerPermission> findByGroupId(long groupId) {
        return null;
    }

    @Override
    public PowerPermission findByMenuId(long menuId) {
        return null;
    }

}