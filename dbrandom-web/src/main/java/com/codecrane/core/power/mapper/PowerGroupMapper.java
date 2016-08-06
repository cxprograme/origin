package com.codecrane.core.power.mapper;

import com.codecrane.core.power.entity.PowerGroup;

import java.util.List;

/**
 * 组织机构信息 数据库操作接口
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
public interface PowerGroupMapper {

    /**
     * 新增 组织机构信息
     *
     * @param powerGroup
     * @return
     */
    int insert(PowerGroup powerGroup);

    /**
     * 批量新增 组织机构信息
     *
     * @param powerGroups
     * @return
     */
    int insertBatch(List<PowerGroup> powerGroups);

    /**
     * 更新 组织机构信息
     *
     * @param powerGroup
     * @return
     */
    int update(PowerGroup powerGroup);

    /**
     * 删除 组织机构信息
     *
     * @param id
     * @return
     */
    int delete(long id);

    /**
     * 批量删除 组织机构信息
     *
     * @param idList
     * @return
     */
    int deleteByIds(long[] idList);

    /**
     * 查询指定 组织机构信息
     *
     * @param id
     * @return 组织机构信息
     */
    PowerGroup queryByPowerGroupId(long id);

    /**
     * 查询指定 组织机构子机构
     *
     * @param id 父机构编号
     * @return
     */
    List<PowerGroup> queryByPowerGroupPid(long id);

    /**
     * 查询所有 组织机构信息
     */
    List<PowerGroup> queryAllPowerGroup();

    /**
     * 查询指定机构下所有子机构
     * @param powerGroup
     * @return
     */
    List<PowerGroup> queryAllChildGroup(PowerGroup powerGroup);

    /**
     * 查询指定机构所有上级机构
     * @param powerGroup
     * @return
     */
    List<PowerGroup> queryAllParentGroup(PowerGroup powerGroup);

}