package com.codecrane.core.power.service;

import com.codecrane.core.power.entity.DictDetail;

import java.util.List;

/**
 * 数据字典详情信息 服务接口
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
public interface DictDetailService {

    /**
     * 新增 数据字典详情信息
     *
     * @param dictDetail
     * @return
     */
    int save(DictDetail dictDetail);

    /**
     * 批量新增 数据字典详情信息
     *
     * @param dictDetails
     * @return
     */
    int saveBatch(List<DictDetail> dictDetails);

    /**
     * 修改 数据字典详情信息
     *
     * @param dictDetail
     * @return
     */
    int modify(DictDetail dictDetail);

    /**
     * 删除 数据字典详情信息
     *
     * @param dictDetailId
     * @return
     */
    int delete(Integer dictDetailId);

    /**
     * 批量删除 数据字典详情信息
     *
     * @param dictDetailIds
     * @return
     */
    int deleteByIds(Integer[] dictDetailIds);

    /**
     * 查询指定 数据字典详情信息
     *
     * @param id
     * @return 数据字典详情信息
     */
    DictDetail findById(Integer id);

    /**
     * 查询所有 数据字典详情信息
     *
     * @return
     */
    List<DictDetail> findAllDictDetail();


    /**
     * 多条件查询 数据字典详情信息
     *
     * @param dictDetail
     * @return
     */
    List<DictDetail> findByCnd(DictDetail dictDetail);

    /**
     * 查询指定字典编码下字典项
     * @param typeCode 字典分类编码
     * @return
     */
    List<DictDetail> findByTypeCode(String typeCode);


}