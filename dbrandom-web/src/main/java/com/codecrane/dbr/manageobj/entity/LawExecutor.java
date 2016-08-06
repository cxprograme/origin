package com.codecrane.dbr.manageobj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


/**
 * 执法者基本信息
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LawExecutor implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 执法者编号
     */
    private Integer id;
    /**
     * 姓名
     */
    private String name;

    /**
     * 查询用姓名
     */
    private String searchName;

    /**
     * 所属机构
     */
    private Integer groupId;

    /**
     * 所属机构名称
     */
    private String groupName;

    /**
     * 所属科室
     */
    private Integer departmentId;

    /**
     * 所属科室名称
     */
    private String departmentName;
    /**
     * 职务编号
     */
    private String dutyId;
    /**
     * 联系电话
     */
    private String mobile;
    /**
     * 资质 1:资深2:普通
     */
    private Integer aptitudes;
    /**
     * 工作量
     */
    private Integer workload;
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