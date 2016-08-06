package com.codecrane.dbr.manageobj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * 企业单位基本信息
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 企业编号
     */
    private Integer id;
    /**
     * 企业名称
     */
    private String name;

    /**
     * 企业名称(用于表单搜索)
     */
    private String searchName;

    /**
     * 分类属性编号
     */
    private Integer type;
    /**
     * 企业所属行业
     */
    private String trade;
    /**
     * 环保负责人
     */
    private String evManager;
    /**
     * 联系手机
     */
    private String mobile;
    /**
     * 联系固定电话
     */
    private String phone;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 修改时间
     */
    private Date modifyDate;
    /**
     * 删除标志
     */
    private Integer deleted;
    /**
     * 联系地址
     */
    private String address;
    /**
     * 管理机构编号
     */
    private Integer groupId;

    /**
     * 管理机构名称
     */
    private String groupName;

    /**
     * 企业管理模式
     */
    private CompanyManageConfig companyManageConfig;

    /**
     * 企业下级节点
     */
    private List<CompanyPoint> companyPoints;


}