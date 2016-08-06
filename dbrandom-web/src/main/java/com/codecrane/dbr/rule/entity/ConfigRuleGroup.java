package com.codecrane.dbr.rule.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * 抽取规则分组模式配置
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfigRuleGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private Integer id;
    /**
     * 所属机构编号
     */
    private Integer groupId;
    /**
     * 一般企业分组模式
     */
    private Integer normalGroup;
    /**
     * 重点企业分组模式
     */
    private Integer importantGroup;
    /**
     * 一般企业固定人员数
     */
    private Integer normalFix;
    /**
     * 重点企业固定人员数
     */
    private Integer importantFix;
    /**
     * 一般企业随机人员数
     */
    private Integer normalRandom;
    /**
     * 重点企业随机人员数
     */
    private Integer importantRandom;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 修改时间
     */
    private Date modifyDate;

    private List<ConfigRuleType> configRuleTypes;
}