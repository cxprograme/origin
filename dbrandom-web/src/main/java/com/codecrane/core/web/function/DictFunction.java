package com.codecrane.core.web.function;

import com.codecrane.core.power.entity.DictDetail;
import com.codecrane.core.power.service.DictDetailService;
import org.beetl.core.Context;
import org.beetl.core.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 数据字典自定义方法
 * Created by crane on 16/5/27.
 */
@Service
public class DictFunction implements Function {

    @Autowired
    private DictDetailService dictDetailService;

    @Override
    public Object call(Object[] paras, Context ctx) {

        if (null != paras && paras.length > 0) {

            String typeCode = paras[0].toString();
            //String dictCode = paras[1].toString();

            List<DictDetail> dictDataList = dictDetailService.findByTypeCode(typeCode);

            return dictDataList;
        }
        return null;
    }
}
