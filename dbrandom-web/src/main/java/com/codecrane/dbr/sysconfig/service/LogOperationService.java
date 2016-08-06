package com.codecrane.dbr.sysconfig.service;

import com.codecrane.dbr.sysconfig.entity.LogOperation;

import java.util.List;

/**
 * 日志服务接口
 * Created by cx on 16/6/15.
 */
public interface LogOperationService {


    /**
     * 查询所有日志信息
     * @return
     */
    List<LogOperation> findAll();

    /**
     * 对条件查询
     * @param logOperation
     * @return
     */
    List<LogOperation> queryCnd(LogOperation logOperation);

    /**
     * 添加数据
     * @param logOperation
     * @return
     */
    int insert(LogOperation logOperation);
}
