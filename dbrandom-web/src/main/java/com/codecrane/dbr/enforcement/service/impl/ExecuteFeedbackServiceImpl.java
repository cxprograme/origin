package com.codecrane.dbr.enforcement.service.impl;

import com.codecrane.dbr.enforcement.entity.ExecuteFeedback;
import com.codecrane.dbr.enforcement.mapper.ExecuteFeedbackMapper;
import com.codecrane.dbr.enforcement.service.ExecuteFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 执法反馈信息 服务
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
@Service
public class ExecuteFeedbackServiceImpl implements ExecuteFeedbackService {

    @Autowired
    private ExecuteFeedbackMapper executeFeedbackMapper;

    @Override
    public int save(ExecuteFeedback executeFeedback) {
        int result = 0;
        if (null != executeFeedback) {
            result = executeFeedbackMapper.insert(executeFeedback);
        }
        return result;
    }

    @Override
    public int saveBatch(List<ExecuteFeedback> executeFeedbacks) {
        int result = 0;
        if (null != executeFeedbacks && executeFeedbacks.size() > 0) {
            result = executeFeedbackMapper.insertBatch(executeFeedbacks);
        }
        return result;
    }

    @Override
    public int modify(ExecuteFeedback executeFeedback) {
        int result = 0;
        if (null != executeFeedback) {
            result = executeFeedbackMapper.update(executeFeedback);
        }
        return result;
    }

    @Override
    public int delete(Integer executeFeedbackId) {
        int result = 0;
        if (executeFeedbackId > 0) {
            result = executeFeedbackMapper.delete(executeFeedbackId);
        }
        return result;
    }

    @Override
    public int deleteByIds(Integer[] executeFeedbackIds) {
        int result = 0;
        if (executeFeedbackIds.length > 0) {
            result = executeFeedbackMapper.deleteByIds(executeFeedbackIds);
        }
        return result;
    }

    @Override
    public ExecuteFeedback findById(Integer executeFeedbackId) {
        return executeFeedbackMapper.queryById(executeFeedbackId);
    }

    @Override
    public List<ExecuteFeedback> findAllExecuteFeedback() {
        return executeFeedbackMapper.queryAllExecuteFeedback();
    }

    @Override
    public List<ExecuteFeedback> findByCnd(ExecuteFeedback executeFeedback) {
        if (null != executeFeedback) {
            return executeFeedbackMapper.queryByCnd(executeFeedback);
        } else {
            return null;
        }
    }

    @Override
    public List<ExecuteFeedback> findTodoByCnd(ExecuteFeedback executeFeedback) {
        if (null != executeFeedback) {
            return executeFeedbackMapper.queryTodoByCnd(executeFeedback);
        } else {
            return null;
        }
    }

    @Override
    public List<ExecuteFeedback> findDistributeByCnd(ExecuteFeedback executeFeedback) {
        if (null != executeFeedback) {
            return executeFeedbackMapper.queryDistributeByCnd(executeFeedback);
        } else {
            return null;
        }
    }
}