package com.codecrane.dbr.extract.mapper;

import com.codecrane.dbr.extract.entity.ExecutorRandom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 执法者抽取纪录信息 数据库操作接口
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
public interface ExecutorRandomMapper {

    /**
     * 新增 执法者抽取纪录信息
     *
     * @param executorRandom
     * @return
     */
    int insert(ExecutorRandom executorRandom);

    /**
     * 批量新增 执法者抽取纪录信息
     *
     * @param executorRandoms
     * @return
     */
    int insertBatch(List<ExecutorRandom> executorRandoms);

    /**
     * 更新 执法者抽取纪录信息
     *
     * @param executorRandom
     * @return
     */
    int update(ExecutorRandom executorRandom);

    /**
     * 删除 执法者抽取纪录信息
     *
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 批量删除 执法者抽取纪录信息
     *
     * @param idList
     * @return
     */
    int deleteByIds(Integer[] idList);

    /**
     * 删除指定批次抽取纪录
     * @param batchNo
     * @return
     */
    int deleteByBatchNo(@Param("batchNo") String batchNo);

    /**
     * 查询指定 执法者抽取纪录信息
     *
     * @param id
     * @return 执法者抽取纪录信息
     */
    ExecutorRandom queryByExecutorRandomId(Integer id);

    /**
     * 查询所有 执法者抽取纪录信息
     */
    List<ExecutorRandom> queryAllExecutorRandom();


    /**
     * 多条件查询 执法者抽取纪录信息
     */
    List<ExecutorRandom> queryByCnd(ExecutorRandom executorRandom);

    /**
     * 根据执法人员手机号和记录号查询
     * @param executorMobile
     * @param recordNo
     * @return
     */
    ExecutorRandom queryByExecutor(@Param("executorMobile") String executorMobile,@Param("recordNo") String recordNo);


    List<ExecutorRandom> queryByCndWithGrouped(ExecutorRandom executorRandom);

    /**
     * 多条件分组查询抽取纪录(含反馈数据)
     * @param executorRandom
     * @return
     */
    List<ExecutorRandom> queryByCndAndGroupedWithFeedback(ExecutorRandom executorRandom);

    /**
     * 查询指定管理机构抽取纪录
     * @param groupId
     * @return
     */
    List<ExecutorRandom> queryByGrouped(@Param("groupId")Integer groupId);
}