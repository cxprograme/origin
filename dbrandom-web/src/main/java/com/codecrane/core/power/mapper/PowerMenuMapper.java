package com.codecrane.core.power.mapper;

import com.codecrane.core.power.entity.PowerMenu;

import java.util.List;

/**
 * 菜单信息表 数据库操作接口
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
public interface PowerMenuMapper {

    /**
     * 新增 菜单信息表
     *
     * @param PowerMenu
     * @return
     */
    int insert(PowerMenu powerMenu);

    /**
     * 批量新增 菜单信息表
     *
     * @param powerMenus
     * @return
     */
    int insertBatch(List<PowerMenu> powerMenus);

    /**
     * 更新 菜单信息表
     *
     * @param PowerMenu
     * @return
     */
    int update(PowerMenu powerMenu);

    /**
     * 删除 菜单信息表
     *
     * @param id
     * @return
     */
    int delete(long id);

    /**
     * 批量删除 菜单信息表
     *
     * @param idList
     * @return
     */
    int deleteByIds(long[] idList);

    /**
     * 查询指定 菜单信息表
     *
     * @param id
     * @return 菜单信息表
     */
    PowerMenu queryByPowerMenuId(long id);

    /**
     * 查询所有 菜单信息表
     */
    List<PowerMenu> queryAllPowerMenu();

    /**
     * 查询指定菜单子菜单
     *
     * @param menuPid
     * @return
     */
    List<PowerMenu> queryByMenuPid(long menuPid);

    /**
     * 查询指定用户的菜单
     * @param userId
     * @return
     */
    List<PowerMenu> queryByUserId(long userId);
}