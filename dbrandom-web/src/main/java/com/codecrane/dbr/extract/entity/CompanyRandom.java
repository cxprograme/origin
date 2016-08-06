package com.codecrane.dbr.extract.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * 企业随机抽取纪录信息
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyRandom implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 企业抽取结果编号
     */
    private Integer id;
    /**
     * 所属月份
     */
    private Integer month;

    /**
     * 统计收取月份分组
     */
    private String groupMonth;

    /**
     * 所属年份
     */
    private Integer year;
    /**
     * 企业编号
     */
    private Integer companyId;

    /**
     * 企业名称
     */
    private String companyName;

    /**
     * 企业环保负责人
     */
    private String companyEvManager;

    /**
     * 企业环保负责人收集
     */
    private String companyMobile;

    /**
     * 企业所属行业代码
     */
    private String companyTrade;

    /**
     * 企业管理类型
     */
    private Integer companyType;

    /**
     * 管理机构编号
     */
    private Integer manageGroupId;

    /**
     * 管理机构名称
     */
    private String manageGroupName;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 抽取纪录日期
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date recordDate;

    /**
     * 抽取批次编号
     */
    private String batchNo;

    /**
     * 抽取的月份以及重点和一般数量
     */
    private List<MonthRandom> monthRandoms;

    /**
     * 统计类型下总数
     */
    private Integer typeTotal;

    /**
     * 统计开始月份
     */
    private Integer startMonth;

    /**
     * 统计结束月份
     */
    private Integer endMonth;

}