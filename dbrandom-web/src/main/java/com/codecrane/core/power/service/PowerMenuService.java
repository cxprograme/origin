package com.codecrane.core.power.service;

import com.codecrane.core.power.entity.PowerMenu;

import java.util.List;

/**
 * 菜单信息表 服务接口
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
public interface PowerMenuService {

    /**
     * 新增 菜单信息表
     *
     * @param powerMenu
     * @return
     */
    int save(PowerMenu powerMenu);

    /**
     * 新增菜单信息包含权限
     *
     * @param powerMenu
     * @return
     */
    int saveWithPermission(PowerMenu powerMenu);

    /**
     * 批量新增 菜单信息表
     *
     * @param powerMenus
     * @return
     */
    int saveBatch(List<PowerMenu> powerMenus);

    /**
     * 修改 菜单信息表
     *
     * @param powerMenu
     * @return
     */
    int modify(PowerMenu powerMenu);

    /**
     * 修改菜单信息同步更新权限信息
     * @param powerMenu
     * @return
     */
    int modifyWithPermission(PowerMenu powerMenu);

    /**
     * 删除 菜单信息表
     *
     * @param powerMenuId
     * @return
     */
    int delete(long powerMenuId);

    /**
     * 批量删除 菜单信息表
     *
     * @param powerMenuIds
     * @return
     */
    int deleteByIds(long[] powerMenuIds);

    /**
     * 查询指定 菜单信息表
     *
     * @param id
     * @return 菜单信息表
     */
    PowerMenu findById(long id);

    /**
     * 查询指定菜单下级菜单
     * @param menuPid
     * @return
     */
    List<PowerMenu> findByMenuPid(long menuPid);

    /**
     * 查询所有 菜单信息表
     *
     * @return
     */
    List<PowerMenu> findAllPowerMenu();

    /**
     * 查询指定用户的菜单
     * @param userId
     * @return
     */
    List<PowerMenu> findByUserId(long userId);
}