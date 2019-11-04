package com.neimeng.workflow.dao;

import com.neimeng.workflow.entity.pojo.ProcessDataset;

public interface ProcessDatasetMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProcessDataset record);

    int insertSelective(ProcessDataset record);

    ProcessDataset selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProcessDataset record);

    int updateByPrimaryKey(ProcessDataset record);

    /**
     * 根据流程实例ID查询关联的数据集基本信息
     *
     * @param processInstanceId
     * @return
     */
    ProcessDataset selectByProcessInstanceId(String processInstanceId);
}