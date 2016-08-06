package com.codecrane.dbr.manageobj.service.impl;

import com.codecrane.dbr.manageobj.entity.CompanyPoint;
import com.codecrane.dbr.manageobj.mapper.CompanyPointMapper;
import com.codecrane.dbr.manageobj.service.CompanyPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 企业监管点位信息 服务
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
@Service
public class CompanyPointServiceImpl implements CompanyPointService {

    @Autowired
    private CompanyPointMapper companyPointMapper;

    @Override
    public int save(CompanyPoint companyPoint) {
        int result = 0;
        if (null != companyPoint) {
            result = companyPointMapper.insert(companyPoint);
        }
        return result;
    }

    @Override
    public int saveBatch(List<CompanyPoint> companyPoints) {
        int result = 0;
        if (null != companyPoints && companyPoints.size() > 0) {
            result = companyPointMapper.insertBatch(companyPoints);
        }
        return result;
    }

    @Override
    public int modify(CompanyPoint companyPoint) {
        int result = 0;
        if (null != companyPoint) {
            result = companyPointMapper.update(companyPoint);
        }
        return result;
    }

    @Override
    public int delete(Integer companyPointId) {
        int result = 0;
        if (companyPointId > 0) {
            result = companyPointMapper.delete(companyPointId);
        }
        return result;
    }

    @Override
    public int deleteByIds(Integer[] companyPointIds) {
        int result = 0;
        if (companyPointIds.length > 0) {
            result = companyPointMapper.deleteByIds(companyPointIds);
        }
        return result;
    }

    @Override
    public int deleteByGroupId(Integer groupId) {
        int result = 0;
        if (null != groupId && groupId.intValue() > 0) {
            result = companyPointMapper.deleteByGroupId(groupId);
        }
        return result;
    }

    @Override
    public CompanyPoint findById(Integer companyPointId) {
        return companyPointMapper.queryByCompanyPointId(companyPointId);
    }

    @Override
    public List<CompanyPoint> findAllCompanyPoint() {
        return companyPointMapper.queryAllCompanyPoint();
    }

    @Override
    public List<CompanyPoint> findByCnd(CompanyPoint companyPoint) {
        if (null != companyPoint) {
            return companyPointMapper.queryByCnd(companyPoint);
        } else {
            return null;
        }
    }
}