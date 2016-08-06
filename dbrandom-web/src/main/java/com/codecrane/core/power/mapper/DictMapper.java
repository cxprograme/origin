package com.codecrane.core.power.mapper;


import com.codecrane.core.power.entity.Dict;

import java.util.List;

/**
 * 数据字典分类信息 数据库操作接口
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
public interface DictMapper {

    /**
     * 新增 数据字典分类信息
     *
     * @param dict
     * @return
     */
    int insert(Dict dict);

    /**
     * 批量新增 数据字典分类信息
     *
     * @param dicts
     * @return
     */
    int insertBatch(List<Dict> dicts);

    /**
     * 更新 数据字典分类信息
     *
     * @param dict
     * @return
     */
    int update(Dict dict);

    /**
     * 删除 数据字典分类信息
     *
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 批量删除 数据字典分类信息
     *
     * @param idList
     * @return
     */
    int deleteByIds(Integer[] idList);

    /**
     * 查询指定 数据字典分类信息
     *
     * @param id
     * @return 数据字典分类信息
     */
    Dict queryByDictId(Integer id);

    /**
     * 查询所有 数据字典分类信息
     */
    List<Dict> queryAllDict();


    /**
     * 多条件查询 数据字典分类信息
     */
    List<Dict> queryByCnd(Dict dict);
}