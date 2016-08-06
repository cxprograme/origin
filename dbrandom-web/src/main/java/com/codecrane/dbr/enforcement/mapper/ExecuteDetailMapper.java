package com.codecrane.dbr.enforcement.mapper;

import com.codecrane.dbr.enforcement.entity.ExecuteDetail;

import java.util.List;

/**
 * 执法反馈处理纪录 数据库操作接口
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
public interface ExecuteDetailMapper {

    /**
     * 新增 执法反馈处理纪录
     *
     * @param executeDetail
     * @return
     */
    int insert(ExecuteDetail executeDetail);

    /**
     * 批量新增 执法反馈处理纪录
     *
     * @param executeDetails
     * @return
     */
    int insertBatch(List<ExecuteDetail> executeDetails);

    /**
     * 更新 执法反馈处理纪录
     *
     * @param executeDetail
     * @return
     */
    int update(ExecuteDetail executeDetail);

    /**
     * 删除 执法反馈处理纪录
     *
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 批量删除 执法反馈处理纪录
     *
     * @param idList
     * @return
     */
    int deleteByIds(Integer[] idList);

    /**
     * 查询指定 执法反馈处理纪录
     *
     * @param id
     * @return 执法反馈处理纪录
     */
    ExecuteDetail queryByExecuteDetailId(Integer id);

    /**
     * 查询所有 执法反馈处理纪录
     */
    List<ExecuteDetail> queryAllExecuteDetail();


    /**
     * 多条件查询 执法反馈处理纪录
     */
    List<ExecuteDetail> queryByCnd(ExecuteDetail executeDetail);
}