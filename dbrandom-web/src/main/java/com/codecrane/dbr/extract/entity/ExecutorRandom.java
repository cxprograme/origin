package com.codecrane.dbr.extract.entity;

import com.codecrane.dbr.enforcement.entity.ExecuteFeedback;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * 执法者抽取纪录信息
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExecutorRandom implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 执法人员抽取纪录编号
     */
    private Integer id;
    /**
     * 年份
     */
    private Integer year;
    /**
     * 抽查企业编号
     */
    private Integer companyId;

    /**
     * 企业名称
     */
    private String companyName;

    /**
     * 企业类型
     */
    private Integer companyType;

    /**
     * 监察日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date checkDate;
    /**
     * 监察人编号
     */
    private Integer executorId;

    /**
     * 监察人员姓名
     */
    private String executorName;

    /**
     * 抽取开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    /**
     * 抽取结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 抽取批次日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date recordDate;

    /**
     * 纪录编号
     */
    private String recordNo;

    /**
     * 抽取批次编号
     */
    private String batchNo;

    /**
     * 管理机构编号
     */
    private Integer groupId;

    /**
     * 管理机构名称
     */
    private String groupName;

    /**
     * 处理状态
     */
    private Integer processStatus;

    /**
     * 执法反馈信息
     */
    private ExecuteFeedback executeFeedback;


}