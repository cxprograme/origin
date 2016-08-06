package com.codecrane.dbr.manageobj.service;


import com.codecrane.dbr.manageobj.entity.LawExecutor;

import java.util.List;

/**
 * 执法者基本信息 服务接口
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
public interface LawExecutorService {

    /**
     * 新增 执法者基本信息
     *
     * @param lawExecutor
     * @return
     */
    int save(LawExecutor lawExecutor);

    /**
     * 批量新增 执法者基本信息
     *
     * @param lawExecutors
     * @return
     */
    int saveBatch(List<LawExecutor> lawExecutors);

    /**
     * 修改 执法者基本信息
     *
     * @param lawExecutor
     * @return
     */
    int modify(LawExecutor lawExecutor);

    /**
     * 删除 执法者基本信息
     *
     * @param lawExecutorId
     * @return
     */
    int delete(Integer lawExecutorId);

    /**
     * 批量删除 执法者基本信息
     *
     * @param lawExecutorIds
     * @return
     */
    int deleteByIds(Integer[] lawExecutorIds);

    /**
     * 查询指定 执法者基本信息
     *
     * @param id
     * @return 执法者基本信息
     */
    LawExecutor findById(Integer id);

    /**
     * 查询所有 执法者基本信息
     *
     * @return
     */
    List<LawExecutor> findAllLawExecutor();


    /**
     * 多条件查询 执法者基本信息
     *
     * @param lawExecutor
     * @return
     */
    List<LawExecutor> findByCnd(LawExecutor lawExecutor);
}