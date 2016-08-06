package com.codecrane.dbr.extract.service;

import com.codecrane.dbr.extract.entity.ExecutorRandom;

import java.util.List;

/**
 * 执法者抽取纪录信息 服务接口
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
public interface ExecutorRandomService {

    /**
     * 新增 执法者抽取纪录信息
     *
     * @param executorRandom
     * @return
     */
    int save(ExecutorRandom executorRandom);

    /**
     * 批量新增 执法者抽取纪录信息
     *
     * @param executorRandoms
     * @return
     */
    int saveBatch(List<ExecutorRandom> executorRandoms);

    /**
     * 修改 执法者抽取纪录信息
     *
     * @param executorRandom
     * @return
     */
    int modify(ExecutorRandom executorRandom);

    /**
     * 删除 执法者抽取纪录信息
     *
     * @param executorRandomId
     * @return
     */
    int delete(Integer executorRandomId);

    /**
     * 批量删除 执法者抽取纪录信息
     *
     * @param executorRandomIds
     * @return
     */
    int deleteByIds(Integer[] executorRandomIds);

    /**
     * 删除指定批次的抽取纪录
     *
     * @param batchNo
     * @return
     */
    int deleteByBatchNo(String batchNo);

    /**
     * 查询指定 执法者抽取纪录信息
     *
     * @param id
     * @return 执法者抽取纪录信息
     */
    ExecutorRandom findById(Integer id);

    /**
     * 查询所有 执法者抽取纪录信息
     *
     * @return
     */
    List<ExecutorRandom> findAllExecutorRandom();


    /**
     * 多条件查询 执法者抽取纪录信息
     *
     * @param executorRandom
     * @return
     */
    List<ExecutorRandom> findByCnd(ExecutorRandom executorRandom);

    /**
     * 根据执法人员手机号和记录号查询
     * @param executorMobile
     * @param recordNo
     * @return
     */
    ExecutorRandom findByExecutor(String executorMobile,String recordNo);


    List<ExecutorRandom> findByCndWithGrouped(ExecutorRandom executorRandom);


    List<ExecutorRandom> findByCndAndGroupedWithFeedback(ExecutorRandom executorRandom);

    /**
     * 查询指定管理机构抽取纪录
     *
     * @param groupId
     * @return
     */
    List<ExecutorRandom> findByGrouped(Integer groupId);
}