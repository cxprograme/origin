package com.codecrane.dbr.manageobj.mapper;

import com.codecrane.dbr.manageobj.entity.LawExecutor;

import java.util.List;

/**
 * 执法者基本信息 数据库操作接口
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
public interface LawExecutorMapper {

    /**
     * 新增 执法者基本信息
     *
     * @param lawExecutor
     * @return
     */
    int insert(LawExecutor lawExecutor);

    /**
     * 批量新增 执法者基本信息
     *
     * @param lawExecutors
     * @return
     */
    int insertBatch(List<LawExecutor> lawExecutors);

    /**
     * 更新 执法者基本信息
     *
     * @param lawExecutor
     * @return
     */
    int update(LawExecutor lawExecutor);

    /**
     * 删除 执法者基本信息
     *
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 批量删除 执法者基本信息
     *
     * @param idList
     * @return
     */
    int deleteByIds(Integer[] idList);

    /**
     * 查询指定 执法者基本信息
     *
     * @param id
     * @return 执法者基本信息
     */
    LawExecutor queryByLawExecutorId(Integer id);

    /**
     * 查询所有 执法者基本信息
     */
    List<LawExecutor> queryAllLawExecutor();


    /**
     * 多条件查询 执法者基本信息
     */
    List<LawExecutor> queryByCnd(LawExecutor lawExecutor);
}