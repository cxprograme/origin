package com.codecrane.dbr.enforcement.service.impl;

import com.codecrane.dbr.enforcement.entity.ExecuteDetail;
import com.codecrane.dbr.enforcement.entity.ExecuteFeedback;
import com.codecrane.dbr.enforcement.mapper.ExecuteDetailMapper;
import com.codecrane.dbr.enforcement.service.ExecuteDetailService;
import com.codecrane.dbr.enforcement.service.ExecuteFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * 执法反馈处理纪录 服务
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
@Service
public class ExecuteDetailServiceImpl implements ExecuteDetailService {

    @Autowired
    private ExecuteDetailMapper executeDetailMapper;

    @Autowired
    private ExecuteFeedbackService executeFeedbackService;

    @Override
    public int save(ExecuteDetail executeDetail) {
        int result = 0;
        if (null != executeDetail) {
            result = executeDetailMapper.insert(executeDetail);
        }
        return result;
    }

    @Override
    public int saveBatch(List<ExecuteDetail> executeDetails) {
        int result = 0;
        if (null != executeDetails && executeDetails.size() > 0) {
            result = executeDetailMapper.insertBatch(executeDetails);
        }
        return result;
    }

    @Override
    public int modify(ExecuteDetail executeDetail) {
        int result = 0;
        if (null != executeDetail) {
            result = executeDetailMapper.update(executeDetail);
        }
        return result;
    }

    @Override
    @Transactional
    public int dealFeedback(ExecuteDetail executeDetail) {
        int result = 0;
        if (null != executeDetail) {
            result = executeDetailMapper.update(executeDetail);
            //更新反馈主状态
            if( result > 0 ){
                ExecuteFeedback feedback = new ExecuteFeedback();
                feedback.setId(executeDetail.getFeedbackId());
                feedback.setStatus(1);
                result = executeFeedbackService.modify(feedback);
            }
        }
        return result;
    }

    @Override
    public int dealSelf(ExecuteDetail executeDetail) {
        int result = 0;
        if (null != executeDetail) {
            result = executeDetailMapper.insert(executeDetail);
            //更新反馈主状态
            if( result > 0 ){
                ExecuteFeedback feedback = new ExecuteFeedback();
                feedback.setId(executeDetail.getFeedbackId());
                feedback.setStatus(executeDetail.getStatus());
                result = executeFeedbackService.modify(feedback);
            }
        }
        return result;
    }

    @Override
    public int delete(Integer executeDetailId) {
        int result = 0;
        if (executeDetailId > 0) {
            result = executeDetailMapper.delete(executeDetailId);
        }
        return result;
    }

    @Override
    public int deleteByIds(Integer[] executeDetailIds) {
        int result = 0;
        if (executeDetailIds.length > 0) {
            result = executeDetailMapper.deleteByIds(executeDetailIds);
        }
        return result;
    }

    @Override
    public ExecuteDetail findById(Integer executeDetailId) {
        return executeDetailMapper.queryByExecuteDetailId(executeDetailId);
    }

    @Override
    public List<ExecuteDetail> findAllExecuteDetail() {
        return executeDetailMapper.queryAllExecuteDetail();
    }

    @Override
    public List<ExecuteDetail> findByCnd(ExecuteDetail executeDetail) {
        if (null != executeDetail) {
            return executeDetailMapper.queryByCnd(executeDetail);
        } else {
            return null;
        }
    }
}