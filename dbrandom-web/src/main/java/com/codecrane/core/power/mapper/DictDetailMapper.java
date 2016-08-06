package com.codecrane.core.power.mapper;

import com.codecrane.core.power.entity.DictDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 数据字典详情信息 数据库操作接口
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
public interface DictDetailMapper {

    /**
     * 新增 数据字典详情信息
     *
     * @param dictDetail
     * @return
     */
    int insert(DictDetail dictDetail);

    /**
     * 批量新增 数据字典详情信息
     *
     * @param dictDetails
     * @return
     */
    int insertBatch(List<DictDetail> dictDetails);

    /**
     * 更新 数据字典详情信息
     *
     * @param dictDetail
     * @return
     */
    int update(DictDetail dictDetail);

    /**
     * 删除 数据字典详情信息
     *
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 批量删除 数据字典详情信息
     *
     * @param idList
     * @return
     */
    int deleteByIds(Integer[] idList);

    /**
     * 查询指定 数据字典详情信息
     *
     * @param id
     * @return 数据字典详情信息
     */
    DictDetail queryByDictDetailId(Integer id);

    /**
     * 查询所有 数据字典详情信息
     */
    List<DictDetail> queryAllDictDetail();


    /**
     * 多条件查询 数据字典详情信息
     */
    List<DictDetail> queryByCnd(DictDetail dictDetail);

    /**
     * 查询指定字典编码下字典项
     * @param typeCode
     * @return
     */
    List<DictDetail> queryByTypeCode(@Param("typeCode") String typeCode);
}