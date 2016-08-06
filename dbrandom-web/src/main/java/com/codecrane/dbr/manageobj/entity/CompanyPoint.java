package com.codecrane.dbr.manageobj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


/**
 * 企业监管点位信息
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyPoint implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 点位编号
     */
    private Integer id;
    /**
     * 所属企业编号
     */
    private Integer companyId;

    /**
     * 所属管理机构编号
     */
    private Integer groupId;

    /**
     * 点位名称
     */
    private String pointName;

    /**
     * 排序号
     */
    private Integer orderId;

    /**
     * 点位描述
     */
    private String pointDesc;
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

}