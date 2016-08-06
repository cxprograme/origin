package com.codecrane.core.power.service;

import com.codecrane.core.power.entity.Dict;

import java.util.List;

/**
 * 数据字典分类信息 服务接口
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
public interface DictService {

    /**
     * 新增 数据字典分类信息
     *
     * @param dict
     * @return
     */
    int save(Dict dict);

    /**
     * 批量新增 数据字典分类信息
     *
     * @param dicts
     * @return
     */
    int saveBatch(List<Dict> dicts);

    /**
     * 修改 数据字典分类信息
     *
     * @param dict
     * @return
     */
    int modify(Dict dict);

    /**
     * 删除 数据字典分类信息
     *
     * @param dictId
     * @return
     */
    int delete(Integer dictId);

    /**
     * 批量删除 数据字典分类信息
     *
     * @param dictIds
     * @return
     */
    int deleteByIds(Integer[] dictIds);

    /**
     * 查询指定 数据字典分类信息
     *
     * @param id
     * @return 数据字典分类信息
     */
    Dict findById(Integer id);

    /**
     * 查询所有 数据字典分类信息
     *
     * @return
     */
    List<Dict> findAllDict();


    /**
     * 多条件查询 数据字典分类信息
     *
     * @param dict
     * @return
     */
    List<Dict> findByCnd(Dict dict);
}