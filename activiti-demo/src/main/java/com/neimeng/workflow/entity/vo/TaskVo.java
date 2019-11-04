package com.neimeng.workflow.entity.vo;

import com.neimeng.workflow.entity.params.ApplyDatasetInfo;
import com.neimeng.workflow.entity.pojo.ProcessDataset;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 前端展示任务信息
 */
@Getter
@Setter
@ToString
public class TaskVo extends ProcessDataset {

    private String taskId;

    private String taskName;

}
