package com.codecrane.dbr.manageobj.service.impl;

import com.codecrane.dbr.manageobj.entity.LawExecutor;
import com.codecrane.dbr.manageobj.mapper.LawExecutorMapper;
import com.codecrane.dbr.manageobj.service.LawExecutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 执法者基本信息 服务
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
@Service
public class LawExecutorServiceImpl implements LawExecutorService {

    @Autowired
    private LawExecutorMapper lawExecutorMapper;

    @Override
    public int save(LawExecutor lawExecutor) {
        int result = 0;
        if (null != lawExecutor) {
            result = lawExecutorMapper.insert(lawExecutor);
        }
        return result;
    }

    @Override
    public int saveBatch(List<LawExecutor> lawExecutors) {
        int result = 0;
        if (null != lawExecutors && lawExecutors.size() > 0) {
            result = lawExecutorMapper.insertBatch(lawExecutors);
        }
        return result;
    }

    @Override
    public int modify(LawExecutor lawExecutor) {
        int result = 0;
        if (null != lawExecutor) {
            result = lawExecutorMapper.update(lawExecutor);
        }
        return result;
    }

    @Override
    public int delete(Integer lawExecutorId) {
        int result = 0;
        if (lawExecutorId > 0) {
            result = lawExecutorMapper.delete(lawExecutorId);
        }
        return result;
    }

    @Override
    public int deleteByIds(Integer[] lawExecutorIds) {
        int result = 0;
        if (lawExecutorIds.length > 0) {
            result = lawExecutorMapper.deleteByIds(lawExecutorIds);
        }
        return result;
    }

    @Override
    public LawExecutor findById(Integer lawExecutorId) {
        return lawExecutorMapper.queryByLawExecutorId(lawExecutorId);
    }

    @Override
    public List<LawExecutor> findAllLawExecutor() {
        return lawExecutorMapper.queryAllLawExecutor();
    }

    @Override
    public List<LawExecutor> findByCnd(LawExecutor lawExecutor) {
        if (null != lawExecutor) {
            return lawExecutorMapper.queryByCnd(lawExecutor);
        } else {
            return null;
        }
    }
}