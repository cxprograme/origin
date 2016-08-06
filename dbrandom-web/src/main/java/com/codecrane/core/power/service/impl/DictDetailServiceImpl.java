package com.codecrane.core.power.service.impl;

import com.codecrane.core.power.entity.DictDetail;
import com.codecrane.core.power.mapper.DictDetailMapper;
import com.codecrane.core.power.service.DictDetailService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * 数据字典详情信息 服务
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
@Service
public class DictDetailServiceImpl implements DictDetailService {

    @Autowired
    private DictDetailMapper dictDetailMapper;

    @Override
    public int save(DictDetail dictDetail) {
        int result = 0;
        if (null != dictDetail) {
            result = dictDetailMapper.insert(dictDetail);
        }
        return result;
    }

    @Override
    public int saveBatch(List<DictDetail> dictDetails) {
        int result = 0;
        if (null != dictDetails && dictDetails.size() > 0) {
            result = dictDetailMapper.insertBatch(dictDetails);
        }
        return result;
    }

    @Override
    public int modify(DictDetail dictDetail) {
        int result = 0;
        if (null != dictDetail) {
            dictDetail.setModifyDate(new Date());
            result = dictDetailMapper.update(dictDetail);
        }
        return result;
    }

    @Override
    public int delete(Integer dictDetailId) {
        int result = 0;
        if (dictDetailId > 0) {
            result = dictDetailMapper.delete(dictDetailId);
        }
        return result;
    }

    @Override
    public int deleteByIds(Integer[] dictDetailIds) {
        int result = 0;
        if (dictDetailIds.length > 0) {
            result = dictDetailMapper.deleteByIds(dictDetailIds);
        }
        return result;
    }

    @Override
    public DictDetail findById(Integer dictDetailId) {
        return dictDetailMapper.queryByDictDetailId(dictDetailId);
    }

    @Override
    public List<DictDetail> findAllDictDetail() {
        return dictDetailMapper.queryAllDictDetail();
    }

    @Override
    public List<DictDetail> findByCnd(DictDetail dictDetail) {
        if (null != dictDetail) {
            return dictDetailMapper.queryByCnd(dictDetail);
        }
        return null;
    }

    @Override
    public List<DictDetail> findByTypeCode(String typeCode) {
        if (StringUtils.isNoneBlank(typeCode)) {
            return dictDetailMapper.queryByTypeCode(typeCode);
        }
        return null;
    }
}