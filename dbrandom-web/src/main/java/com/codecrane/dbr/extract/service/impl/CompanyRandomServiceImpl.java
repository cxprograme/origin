package com.codecrane.dbr.extract.service.impl;

import com.codecrane.dbr.extract.entity.CompanyRandom;
import com.codecrane.dbr.extract.mapper.CompanyRandomMapper;
import com.codecrane.dbr.extract.service.CompanyRandomService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 企业随机抽取纪录信息 服务
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
@Service
public class CompanyRandomServiceImpl implements CompanyRandomService {

    @Autowired
    private CompanyRandomMapper companyRandomMapper;

    @Override
    public int save(CompanyRandom companyRandom) {
        int result = 0;
        if (null != companyRandom) {
            result = companyRandomMapper.insert(companyRandom);
        }
        return result;
    }

    @Override
    public int saveBatch(List<CompanyRandom> companyRandoms) {
        int result = 0;
        if (null != companyRandoms && companyRandoms.size() > 0) {
            result = companyRandomMapper.insertBatch(companyRandoms);
        }
        return result;
    }

    @Override
    public int modify(CompanyRandom companyRandom) {
        int result = 0;
        if (null != companyRandom) {
            result = companyRandomMapper.update(companyRandom);
        }
        return result;
    }

    @Override
    public int delete(Integer companyRandomId) {
        int result = 0;
        if (companyRandomId > 0) {
            result = companyRandomMapper.delete(companyRandomId);
        }
        return result;
    }

    @Override
    public int deleteByIds(Integer[] companyRandomIds) {
        int result = 0;
        if (companyRandomIds.length > 0) {
            result = companyRandomMapper.deleteByIds(companyRandomIds);
        }
        return result;
    }

    @Override
    public int deleteByBatchNo(String batchNo) {
        int result = 0;
        if (StringUtils.isNoneBlank(batchNo)) {
            result = companyRandomMapper.deleteByBatchNo(batchNo);
        }
        return result;
    }

    @Override
    public CompanyRandom findById(Integer companyRandomId) {
        return companyRandomMapper.queryByCompanyRandomId(companyRandomId);
    }

    @Override
    public List<CompanyRandom> findAllCompanyRandom() {
        return companyRandomMapper.queryAllCompanyRandom();
    }

    @Override
    public List<CompanyRandom> findByCnd(CompanyRandom companyRandom) {
        if (null != companyRandom) {
            return companyRandomMapper.queryByCnd(companyRandom);
        } else {
            return null;
        }
    }

    @Override
    public List<CompanyRandom> findByGrouped(Integer groupId) {
        if (null != groupId) {
            return companyRandomMapper.queryByGrouped(groupId);
        } else {
            return null;
        }
    }

    @Override
    public List<CompanyRandom> findCountByCompanyType(Integer groupId, Integer year) {
        if (null != groupId && null != year) {
            return companyRandomMapper.queryCountByCompanyType(groupId, year);
        } else {
            return null;
        }
    }
}