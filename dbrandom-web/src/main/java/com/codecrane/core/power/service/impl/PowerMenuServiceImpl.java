package com.codecrane.core.power.service.impl;

import com.codecrane.core.power.entity.PowerMenu;
import com.codecrane.core.power.entity.PowerPermission;
import com.codecrane.core.power.mapper.PowerMenuMapper;
import com.codecrane.core.power.mapper.PowerPermissionMapper;
import com.codecrane.core.power.service.PowerMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


/**
 * 菜单信息表 服务
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
@Service
@Slf4j
public class PowerMenuServiceImpl implements PowerMenuService {

    @Autowired
    private PowerMenuMapper powerMenuMapper;

    @Autowired
    private PowerPermissionMapper powerPermissionMapper;

    @Override
    @Transactional
    public int saveWithPermission(PowerMenu powerMenu) {
        int result = 0;
        if (null != powerMenu) {
            result = powerMenuMapper.insert(powerMenu);
            if (result > 0) {
                PowerPermission powerPermission = powerMenu.getPowerPermission();
                powerPermission.setPermissionName(powerMenu.getMenuName());
                powerPermission.setPermissionCode(powerMenu.getPowerPermission().getPermissionCode());
                powerPermission.setOrderId(powerMenu.getOrderId());
                powerPermission.setPermissionType(1);
                powerPermission.setPrivilegeId(powerMenu.getId());

                result = powerPermissionMapper.insert(powerPermission);
            }
        }
        return result;
    }

    @Override
    public int save(PowerMenu powerMenu) {
        int result = 0;
        if (null != powerMenu) {
            result = powerMenuMapper.insert(powerMenu);
        }
        return result;
    }

    @Override
    public int saveBatch(List<PowerMenu> powerMenus) {
        int result = 0;
        if (null != powerMenus && powerMenus.size() > 0) {
            result = powerMenuMapper.insertBatch(powerMenus);
        }
        return result;
    }

    @Override
    public int modify(PowerMenu powerMenu) {
        int result = 0;
        if (null != powerMenu) {
            result = powerMenuMapper.update(powerMenu);
        }
        return result;
    }

    @Override
    public int modifyWithPermission(PowerMenu powerMenu) {
        int result = 0;
        if (null != powerMenu) {

            //更新菜单信息
            result = powerMenuMapper.update(powerMenu);

            //更新权限信息
            PowerPermission powerPermission = powerMenu.getPowerPermission();
            powerPermission.setPermissionCode(powerMenu.getPowerPermission().getPermissionCode());
            powerPermission.setPermissionName(powerMenu.getMenuName());
            powerPermission.setOrderId(powerMenu.getOrderId());
            powerPermission.setModifyDate(new Date());

            powerPermissionMapper.update(powerMenu.getPowerPermission());
        }
        return result;
    }

    @Override
    public int delete(long powerMenuId) {
        int result = 0;
        if (powerMenuId > 0) {
            result = powerMenuMapper.delete(powerMenuId);
        }
        return result;
    }

    @Override
    public int deleteByIds(long[] powerMenuIds) {
        int result = 0;
        if (powerMenuIds.length > 0) {
            result = powerMenuMapper.deleteByIds(powerMenuIds);
        }
        return result;
    }

    @Override
    public PowerMenu findById(long powerMenuId) {
        return powerMenuMapper.queryByPowerMenuId(powerMenuId);
    }

    @Override
    public List<PowerMenu> findAllPowerMenu() {
        return powerMenuMapper.queryAllPowerMenu();
    }

    @Override
    public List<PowerMenu> findByMenuPid(long menuPid) {
        return powerMenuMapper.queryByMenuPid(menuPid);
    }

    @Override
    public List<PowerMenu> findByUserId(long userId) {
        return powerMenuMapper.queryByUserId(userId);
    }
}