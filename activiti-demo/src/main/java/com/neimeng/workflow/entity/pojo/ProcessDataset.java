package com.neimeng.workflow.entity.pojo;

import java.util.Date;

/**
 * 流程-数据集申请 关联信息
 */
public class ProcessDataset {
    private Integer id;

    private String creator;

    private Integer processStatus;

    private Integer datasetId;

    private String procInstId;

    private String datasetName;

    private Integer priority;

    private Date createTime;

    private Date updateTime;

    public ProcessDataset(Integer id, String creator, Integer processStatus, Integer datasetId, String procInstId, String datasetName, Integer priority, Date createTime, Date updateTime) {
        this.id = id;
        this.creator = creator;
        this.processStatus = processStatus;
        this.datasetId = datasetId;
        this.procInstId = procInstId;
        this.datasetName = datasetName;
        this.priority = priority;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public ProcessDataset() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Integer getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(Integer processStatus) {
        this.processStatus = processStatus;
    }

    public Integer getDatasetId() {
        return datasetId;
    }

    public void setDatasetId(Integer datasetId) {
        this.datasetId = datasetId;
    }

    public String getProcInstId() {
        return procInstId;
    }

    public void setProcInstId(String procInstId) {
        this.procInstId = procInstId == null ? null : procInstId.trim();
    }

    public String getDatasetName() {
        return datasetName;
    }

    public void setDatasetName(String datasetName) {
        this.datasetName = datasetName == null ? null : datasetName.trim();
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
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