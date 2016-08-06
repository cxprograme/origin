package com.codecrane.dbr.manageobj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * 企业管理模式信息
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyManageConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 配置编号
     */
    private Integer id;
    /**
     * 所属企业编号
     */
    private Integer companyId;
    /**
     * 管理机构编号
     */
    private Integer groupId;
    /**
     * 企业类型 0:一般1:重点
     */
    private Integer companyType;
    /**
     * 分组模式 0:非分组模式1:分组模式
     */
    private Integer groupModel;
    /**
     * 固定人数
     */
    private Integer fixNum;
    /**
     * 随机人数
     */
    private Integer randomNum;
    /**
     * 随机抽取方式 0:年1:季度2:月3:周4:自定义
     */
    private Integer randomType;
    /**
     * 抽查天数
     */
    private Integer randomDays;

}