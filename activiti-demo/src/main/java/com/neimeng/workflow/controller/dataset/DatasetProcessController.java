package com.neimeng.workflow.controller.dataset;

import com.github.pagehelper.PageInfo;
import com.neimeng.workflow.entity.Response;
import com.neimeng.workflow.entity.params.ApplyDatasetInfo;
import com.neimeng.workflow.entity.params.ProcessApproval;
import com.neimeng.workflow.entity.pojo.ProcessTask;
import com.neimeng.workflow.entity.query.BasePageQuery;
import com.neimeng.workflow.service.DatasetProcessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * 数据集流程Controller
 */
@Slf4j
@RestController
@RequestMapping("/process/dataset")
public class DatasetProcessController {

    @Autowired
    private DatasetProcessService datasetProcessService;

    /**
     * 申请数据集
     *
     * @return
     */
    @PostMapping("applyDataSet")
    public Response applyDataSet(@RequestBody ApplyDatasetInfo datasetBaseInfo, HttpServletRequest request) {
        datasetProcessService.applyDataSet(datasetBaseInfo, request);
        return Response.success();
    }

    /**
     * 获取用户需要处理的Task
     *
     * @param request
     * @return
     */
    @GetMapping("getUserTask")
    public Response getUserTask(BasePageQuery pageQuery, HttpServletRequest request) {
        PageInfo pageInfo = datasetProcessService.getUserTask(pageQuery, request);
        return Response.success(pageInfo);
    }

    /**
     * 审批任务
     *
     * @param request
     * @return
     */
    @PostMapping("approvalTask")
    public Response approvalTask(@RequestBody ProcessApproval processApproval, HttpServletRequest request) {
        datasetProcessService.approvalTask(processApproval, request);
        return Response.success();
    }

    /**
     * 获取审批历史记录
     *
     * @param processInstanceId
     * @return
     */
    @GetMapping("getApprovalHistory")
    public Response getApprovalHistory(String processInstanceId) {
        List<ProcessTask> taskApprovalHisroties = datasetProcessService.getApprovalHistory(processInstanceId);
        return Response.success(taskApprovalHisroties);
    }

}
