package com.codecrane.core.power.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


/**
 * 数据字典详情信息
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DictDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *编号
     */
    private Integer id;
    /**
     * 所属分类
     */
    private Integer dictType;

    /**
     * 所属分类名称
     */
    private String dictTypeName;

    /**
     * 名称
     */
    private String detailName;
    /**
     * 编码
     */
    private String detailCode;
    /**
     * 排序号
     */
    private String detailSort;
    /**
     * 类型
     */
    private String detailType;
    /**
     * 状态
     */
    private String detailState;
    /**
     * 内容
     */
    private String detailContent;
    /**
     * 备注
     */
    private String detailRemark;
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