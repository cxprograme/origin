package com.codecrane.core.power.service.impl;

import com.codecrane.core.power.entity.Dict;
import com.codecrane.core.power.mapper.DictMapper;
import com.codecrane.core.power.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * 数据字典分类信息 服务
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
@Service
public class DictServiceImpl implements DictService {

    @Autowired
    private DictMapper dictMapper;

    @Override
    public int save(Dict dict) {
        int result = 0;
        if (null != dict) {
            result = dictMapper.insert(dict);
        }
        return result;
    }

    @Override
    public int saveBatch(List<Dict> dicts) {
        int result = 0;
        if (null != dicts && dicts.size() > 0) {
            result = dictMapper.insertBatch(dicts);
        }
        return result;
    }

    @Override
    public int modify(Dict dict) {
        int result = 0;
        if (null != dict) {
            dict.setModifyDate(new Date());
            result = dictMapper.update(dict);
        }
        return result;
    }

    @Override
    public int delete(Integer dictId) {
        int result = 0;
        if (dictId > 0) {
            result = dictMapper.delete(dictId);
        }
        return result;
    }

    @Override
    public int deleteByIds(Integer[] dictIds) {
        int result = 0;
        if (dictIds.length > 0) {
            result = dictMapper.deleteByIds(dictIds);
        }
        return result;
    }

    @Override
    public Dict findById(Integer dictId) {
        return dictMapper.queryByDictId(dictId);
    }

    @Override
    public List<Dict> findAllDict() {
        return dictMapper.queryAllDict();
    }

    @Override
    public List<Dict> findByCnd(Dict dict) {
        if (null != dict) {
            return dictMapper.queryByCnd(dict);
        } else {
            return null;
        }
    }
}