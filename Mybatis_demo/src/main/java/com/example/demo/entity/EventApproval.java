package com.example.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigInteger;

@Data
@ApiModel("事件审批")
public class EventApproval {

    @ApiModelProperty(value = "Event ID", required = true)
    @NotNull
    private BigInteger eventId;

    @ApiModelProperty(value = "Event 编号", required = true)
    private String eventCode;

    @ApiModelProperty(value = "审批状态:0 不同意，1 同意，2 驳回", required = true)
    @NotNull
    @Pattern(regexp = "^(0|1|2|3|4|5)$", message = "{message.event.approving.option}")
    private String approvalStatus;

    @ApiModelProperty(value = "审批意见")
    private String comment;

    /**
     * 当前审批人
     */
    @ApiModelProperty(hidden = true)
    private String assignee;

    @ApiModelProperty(value = "下个节点审批人")
    private String nextAssignee;

    @ApiModelProperty(hidden = true)
    public Integer getApproval() {
        return Integer.parseInt(approvalStatus);
    }

    @ApiModelProperty(hidden = true)
    public EventApprovalEnum getEventApproval() {
        return EventApprovalEnum.to(getApproval());
    }

}
