package com.codecrane.dbr.extract.service.impl;

import com.codecrane.dbr.extract.entity.ExecutorRandom;
import com.codecrane.dbr.extract.mapper.ExecutorRandomMapper;
import com.codecrane.dbr.extract.service.ExecutorRandomService;
import com.google.common.base.Strings;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 执法者抽取纪录信息 服务
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
@Service
public class ExecutorRandomServiceImpl implements ExecutorRandomService {

    @Autowired
    private ExecutorRandomMapper executorRandomMapper;

    @Override
    public int save(ExecutorRandom executorRandom) {
        int result = 0;
        if (null != executorRandom) {
            result = executorRandomMapper.insert(executorRandom);
        }
        return result;
    }

    @Override
    public int saveBatch(List<ExecutorRandom> executorRandoms) {
        int result = 0;
        if (null != executorRandoms && executorRandoms.size() > 0) {
            result = executorRandomMapper.insertBatch(executorRandoms);
        }
        return result;
    }

    @Override
    public int modify(ExecutorRandom executorRandom) {
        int result = 0;
        if (null != executorRandom) {
            result = executorRandomMapper.update(executorRandom);
        }
        return result;
    }

    @Override
    public int delete(Integer executorRandomId) {
        int result = 0;
        if (executorRandomId > 0) {
            result = executorRandomMapper.delete(executorRandomId);
        }
        return result;
    }

    @Override
    public int deleteByIds(Integer[] executorRandomIds) {
        int result = 0;
        if (executorRandomIds.length > 0) {
            result = executorRandomMapper.deleteByIds(executorRandomIds);
        }
        return result;
    }

    @Override
    public int deleteByBatchNo(String batchNo) {
        int result = 0;
        if (StringUtils.isNoneBlank(batchNo)) {
            result = executorRandomMapper.deleteByBatchNo(batchNo);
        }
        return result;
    }

    @Override
    public ExecutorRandom findById(Integer executorRandomId) {
        return executorRandomMapper.queryByExecutorRandomId(executorRandomId);
    }

    @Override
    public List<ExecutorRandom> findAllExecutorRandom() {
        return executorRandomMapper.queryAllExecutorRandom();
    }

    @Override
    public List<ExecutorRandom> findByCnd(ExecutorRandom executorRandom) {
        if (null != executorRandom) {
            return executorRandomMapper.queryByCnd(executorRandom);
        } else {
            return null;
        }
    }

    @Override
    public ExecutorRandom findByExecutor(String executorMobile, String recordNo) {
        if (!Strings.isNullOrEmpty(executorMobile) && !Strings.isNullOrEmpty(recordNo)) {
            return executorRandomMapper.queryByExecutor(executorMobile, recordNo);
        }
        return null;
    }

    @Override
    public List<ExecutorRandom> findByCndWithGrouped(ExecutorRandom executorRandom) {
        if (null != executorRandom) {
            return executorRandomMapper.queryByCndWithGrouped(executorRandom);
        } else {
            return null;
        }
    }

    @Override
    public List<ExecutorRandom> findByCndAndGroupedWithFeedback(ExecutorRandom executorRandom) {
        if (null != executorRandom) {
            return executorRandomMapper.queryByCndAndGroupedWithFeedback(executorRandom);
        } else {
            return null;
        }
    }

    @Override
    public List<ExecutorRandom> findByGrouped(Integer groupId) {
        if (null != groupId) {
            return executorRandomMapper.queryByGrouped(groupId);
        } else {
            return null;
        }
    }
}