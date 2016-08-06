package com.codecrane.dbr.extract.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 月份抽取数据
 * Created by crane on 16/6/4.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonthRandom {

    /**
     * 月份
     */
    private Integer month;

    /**
     * 重点数量
     */
    private Integer important;

    /**
     * 一般数量
     */
    private Integer normal;

}
