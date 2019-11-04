package com.neimeng.workflow.entity.params;

import com.neimeng.workflow.entity.enums.PriorityEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * 申请数据集的基本信息
 */
@Getter
@Setter
@ToString
@ApiModel
public class ApplyDatasetInfo {

    @ApiModelProperty(value = "数据集ID", required = true)
    @NotNull
    protected Integer dataSetId;

    @ApiModelProperty(value = "数据集名称", required = true)
    @NotNull
    protected String dataSetName;

    // 优先级
    private PriorityEnum priority;

    public PriorityEnum getPriority() {
        if (priority == null) {
            return PriorityEnum.NOMAL;
        }
        return priority;
    }

}
