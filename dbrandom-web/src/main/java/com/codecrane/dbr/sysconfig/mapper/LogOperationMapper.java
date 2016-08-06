package com.codecrane.dbr.sysconfig.mapper;

import com.codecrane.dbr.sysconfig.entity.LogOperation;

import java.util.List;

/**
 * Created by cx on 16/6/15.
 */
public interface LogOperationMapper {

    /**
     * 查询所有日志信息
     * @return
     */
    List<LogOperation> queryAllLogOperation();

    /**
     * 多条件查询
     * @param logOperationMap
     * @return
     */
    List<LogOperation> queryByCnd(LogOperation logOperationMap);

    /**
     * 添加日志
     * @param logOperation
     * @return
     */
    int  insert(LogOperation logOperation);
}
