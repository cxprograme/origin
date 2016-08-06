package com.codecrane.core.power.service;

import com.codecrane.core.power.entity.PowerGroup;

import java.util.List;

/**
 * 组织机构信息表 服务接口
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
public interface PowerGroupService {

    /**
     * 新增 组织机构信息表
     *
     * @param powerGroup
     * @return
     */
    int save(PowerGroup powerGroup);

    /**
     * 批量新增 组织机构信息表
     *
     * @param powerGroups
     * @return
     */
    int saveBatch(List<PowerGroup> powerGroups);

    /**
     * 修改 组织机构信息表
     *
     * @param powerGroup
     * @return
     */
    int modify(PowerGroup powerGroup);

    /**
     * 删除 组织机构信息表
     *
     * @param powerGroupId
     * @return
     */
    int delete(long powerGroupId);

    /**
     * 批量删除 组织机构信息表
     *
     * @param powerGroupIds
     * @return
     */
    int deleteByIds(long[] powerGroupIds);

    /**
     * 查询指定 组织机构信息表
     *
     * @param id
     * @return 组织机构信息表
     */
    PowerGroup findById(long id);

    /**
     * 查询所有 组织机构信息表
     *
     * @return
     */
    List<PowerGroup> findAllPowerGroup();

    /**
     * 查询指定机构下子机构
     *
     * @param id 父机构编号
     * @return
     */
    List<PowerGroup> findByPid(long id);

    /**
     * 查询指定机构下所有子机构
     * @param powerGroup
     * @return
     */
    List<PowerGroup> findAllChildGroup(PowerGroup powerGroup);

    /**
     * 查询指定机构所有父机构
     * @param powerGroup
     * @return
     */
    List<PowerGroup> findAllParentGroup(PowerGroup powerGroup);

}