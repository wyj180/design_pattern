package com.neimeng.workflow.entity.pojo;

import java.util.Date;

public class DsProcessRelation {
    private Integer id;

    private Integer pigType;

    private Integer dataSetId;

    private String processInstId;

    private Date createTime;

    private Date updateTime;

    public DsProcessRelation(Integer id, Integer pigType, Integer dataSetId, String processInstId, Date createTime, Date updateTime) {
        this.id = id;
        this.pigType = pigType;
        this.dataSetId = dataSetId;
        this.processInstId = processInstId;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public DsProcessRelation() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPigType() {
        return pigType;
    }

    public void setPigType(Integer pigType) {
        this.pigType = pigType;
    }

    public Integer getDataSetId() {
        return dataSetId;
    }

    public void setDataSetId(Integer dataSetId) {
        this.dataSetId = dataSetId;
    }

    public String getProcessInstId() {
        return processInstId;
    }

    public void setProcessInstId(String processInstId) {
        this.processInstId = processInstId == null ? null : processInstId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}