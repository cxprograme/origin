package com.codecrane.dbr.sysconfig.entity;

import java.util.Date;

/**
 * 日志管理实体类
 * Created by cx on 16/6/15.
 */
public class LogOperation {

    public enum LogName{
        ADD("添加",1),DEL("删除",2),UPDATE("更新",3),QUERY("查询",4);

        private String key;
        private int value;
        private LogName(String key, int value) {
            this.key=key;
            this.value=value;
        }

        public String getKey(){
            return key;
        }
        public int getValue(){
            return value;
        }
    }

    private int id; //主键

    private String opType;  //操作类型

    private String opName;  //操作名称

    private int opObjId;    //操作对象编号

    private String opDesc;  //操作描述

    private Date createDate;    //创建时间

    private String createMan;   //创建人


    private Date startTime;    //开始时间
    private Date endTime;   //结束时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreateMan() {
        return createMan;
    }

    public void setCreateMan(String createMan) {
        this.createMan = createMan;
    }

    public String getOpType() {
        return opType;
    }

    public void setOpType(String opType) {
        this.opType = opType;
    }

    public String getOpName() {
        return opName;
    }

    public void setOpName(String opName) {
        this.opName = opName;
    }

    public int getOpObjId() {
        return opObjId;
    }

    public void setOpObjId(int opObjId) {
        this.opObjId = opObjId;
    }

    public String getOpDesc() {
        return opDesc;
    }

    public void setOpDesc(String opDesc) {
        this.opDesc = opDesc;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "LogOperation{" +
                "id=" + id +
                ", opType='" + opType + '\'' +
                ", opName='" + opName + '\'' +
                ", opObjId=" + opObjId +
                ", opDesc='" + opDesc + '\'' +
                ", createDate=" + createDate +
                ", createMan='" + createMan + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
