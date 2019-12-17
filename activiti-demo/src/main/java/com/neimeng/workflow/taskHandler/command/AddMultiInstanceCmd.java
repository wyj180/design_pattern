package com.neimeng.workflow.taskHandler.command;

import org.activiti.bpmn.model.*;
import org.activiti.engine.ActivitiException;
import org.activiti.engine.impl.bpmn.behavior.AbstractBpmnActivityBehavior;
import org.activiti.engine.impl.bpmn.behavior.ParallelMultiInstanceBehavior;
import org.activiti.engine.impl.history.HistoryManager;
import org.activiti.engine.impl.interceptor.Command;
import org.activiti.engine.impl.interceptor.CommandContext;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.ExecutionEntityManager;
import org.activiti.engine.impl.util.ProcessDefinitionUtil;

/**
 * 新增 多实例任务 或 多实例子流程 命令
 */
public class AddMultiInstanceCmd implements Command {

    // 流程变量，该流程变量是Activit自动添加的，标记子流程执行实例总个数
    protected final String NUMBER_OF_INSTANCES = "nrOfInstances";

    // 流程变量，该流程变量是Activit自动添加的，标记正在运行的子流程执行实例个数
    protected final String NUMBER_OF_ACTIVE_INSTANCES = "nrOfActiveInstances";

    // 子流程的父执行实例ID
    private String multiRootExecutionId;

    // 任务处理人，只针对任务实例有效，对于子流程的第一个任务处理人，可以使用流程变量指派
    private String addUserTaskAssign;

    public AddMultiInstanceCmd(String multiRootExecutionId) {
        this.multiRootExecutionId = multiRootExecutionId;
    }

    public AddMultiInstanceCmd(String multiRootExecutionId, String addUserTaskAssign) {
        this.multiRootExecutionId = multiRootExecutionId;
        this.addUserTaskAssign = addUserTaskAssign;
    }

    public Object execute(CommandContext commandContext) {
        ExecutionEntityManager executionEntityManager = commandContext.getExecutionEntityManager();
        //获取多实例父级执行实例
        ExecutionEntity multiExecutionEntity = executionEntityManager.findById(multiRootExecutionId);
        //判断当前执行实例的节点是否是多实例节点
        BpmnModel bpmnModel = ProcessDefinitionUtil.getBpmnModel(multiExecutionEntity.getProcessDefinitionId());
        Activity miActivityElement = (Activity) bpmnModel.getFlowElement(multiExecutionEntity.getCurrentActivityId());
        MultiInstanceLoopCharacteristics loopCharacteristics = miActivityElement.getLoopCharacteristics();
        if (loopCharacteristics == null) {
            throw new ActivitiException("此节点不是多实例节点");
        }
        //判断是否是并行多实例
        if (loopCharacteristics.isSequential()) {
            throw new ActivitiException("此节点为串行节点");

        }
        //创建新的子执行实例
        ExecutionEntity childExecution = executionEntityManager.createChildExecution(multiExecutionEntity);
        //获取并为新的执行实例设置当前活动节点
        FlowElement flowElement = multiExecutionEntity.getCurrentFlowElement();
        if (flowElement instanceof UserTask) {
            // 给多实例任务设置处理人
            UserTask userTask = (UserTask) flowElement;
            userTask.setAssignee(addUserTaskAssign);
        } else if (flowElement instanceof SubProcess) {
            SubProcess subProcess = (SubProcess) flowElement;
        } else {
            throw new IllegalArgumentException("目前暂不支持新增该类型的任务，请扩展");
        }
        childExecution.setCurrentFlowElement(flowElement);

        //获取设置变量
        Integer nrOfInstances = (Integer) multiExecutionEntity.getVariableLocal(NUMBER_OF_INSTANCES);
        Integer nrOfActiveInstances = (Integer) multiExecutionEntity.getVariableLocal(NUMBER_OF_ACTIVE_INSTANCES);

        multiExecutionEntity.setVariableLocal(NUMBER_OF_INSTANCES, nrOfInstances + 1);
        multiExecutionEntity.setVariableLocal(NUMBER_OF_ACTIVE_INSTANCES, nrOfActiveInstances + 1);

        //通知活动开始
        HistoryManager historyManager = commandContext.getHistoryManager();
        historyManager.recordActivityStart(childExecution);
        //获取处理行为类
        ParallelMultiInstanceBehavior prallelMultiInstanceBehavior = (ParallelMultiInstanceBehavior) miActivityElement.getBehavior();
        AbstractBpmnActivityBehavior innerActivityBehavior = prallelMultiInstanceBehavior.getInnerActivityBehavior();
        //执行
        innerActivityBehavior.execute(childExecution);
        return null;
    }

}