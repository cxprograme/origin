package com.codecrane.dbr.sysconfig.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * 节假日配置信息
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfigHoliday implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 配置编号
     */
    private Integer id;
    /**
     * 节假日日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date holidayDate;

    /**
     * 节假日名称
     */
    private String holidayName;

    /**
     * 设置状态0工作日 1休息日
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 修改时间
     */
    private Date modifyDate;


    /**
     * 查询开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    /**
     * 查询结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

}