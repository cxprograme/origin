package com.codecrane.dbr.sysconfig.service.impl;

import com.codecrane.dbr.sysconfig.entity.LogOperation;
import com.codecrane.dbr.sysconfig.mapper.LogOperationMapper;
import com.codecrane.dbr.sysconfig.service.LogOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * 日志服务实现类
 * Created by cx on 16/6/15.
 */
@Service
public class LogOperationServiceImp implements LogOperationService {

    @Autowired
    private LogOperationMapper logOperationMapper;

    @Override
    public List<LogOperation> findAll() {
        return logOperationMapper.queryAllLogOperation();
    }

    @Override
    public List<LogOperation> queryCnd(LogOperation logOperation) {
        return logOperationMapper.queryByCnd(logOperation);
    }

    @Override
    public int insert(LogOperation logOperation) {
        return logOperationMapper.insert(logOperation);
    }
}
