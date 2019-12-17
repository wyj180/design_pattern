package com.neimeng.workflow.taskHandler.command;

import org.activiti.bpmn.model.FlowNode;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.impl.cfg.IdGenerator;
import org.activiti.engine.impl.interceptor.CommandContext;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.activiti.engine.impl.persistence.entity.TaskEntityImpl;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.task.Task;

import java.util.Date;
import java.util.List;

public class AddTask {


    protected String executionId;  //execution 即流程执行线路，或者执行环境
    protected List<String> userList; //要赋值的用户集合，也可以逗号隔开的字符串
    protected FlowNode targetNode; //要复制的节点（多实例）

//    public AddTask(String executionId, List<String> userList, FlowNode targetNode) {
//        this.executionId = executionId;
//        this.userList = userList;
//        this.targetNode = targetNode;
//    }


    public void execute(CommandContext commandContext) {
        RuntimeService runtimeService = commandContext
                .getProcessEngineConfiguration().getRuntimeService();
        TaskService taskService = commandContext
                .getProcessEngineConfiguration().getTaskService();
        List<Execution> list = runtimeService.createExecutionQuery()
                .executionId(executionId).list();//executionid不会重复，查出其实就一个结果
        for (Execution execution : list) {

            ExecutionEntity ee = (ExecutionEntity) execution;
            //下面这个是重点，如果是子流程需要获取两级parent，其他get一次就好
            ExecutionEntity parent = ee.getParent().getParent();
            //创建子线路
            ExecutionEntity createExecution = commandContext.getExecutionEntityManager().createChildExecution(parent == null ? ee.getParent() : parent);
            //下面这几个跟着设就行
            createExecution.setActive(true);
            createExecution.setConcurrent(false);
            createExecution.setScope(false);
            createExecution.setCurrentFlowElement(ee.getCurrentFlowElement());
            createExecution.setProcessDefinitionId(ee.getProcessDefinitionId());
            createExecution.setProcessDefinitionKey(ee.getProcessDefinitionKey());
            //拿到id生成器
            IdGenerator idGenerator = commandContext
                    .getProcessEngineConfiguration().getIdGenerator();
            String nextId = idGenerator.getNextId();

            //查询当前的task实例，有的属性flownode没有得用taskentity赋值
            Task singleResult = taskService.createTaskQuery()
                    .executionId(executionId).singleResult();
            TaskEntity t = (TaskEntity) singleResult;
            //创建新的task
            TaskEntity taskEntity = new TaskEntityImpl();
            taskEntity.setCreateTime(new Date());
            taskEntity.setProcessDefinitionId(t.getProcessDefinitionId());
            taskEntity.setTaskDefinitionKey(targetNode.getId());
            taskEntity.setProcessInstanceId(t.getProcessInstanceId());
            //跟流程线路绑定
            taskEntity.setExecutionId(createExecution.getId());
            taskEntity.setExecution(createExecution);
            taskEntity.setName(targetNode.getName());
            //给id赋值
            taskEntity.setId(nextId);
            //等于0才会新建
            taskEntity.setRevision(0);
            //给task赋执行者，需要自己去领任务
            taskEntity.addCandidateUsers(userList);
            //存储task
            taskService.saveTask(taskEntity);

            //下面这些不用动，复制过去就行
            int loopCounter = getLoopVariable(createExecution, "nrOfInstances");
            int nrOfCompletedInstances = getLoopVariable(createExecution,
                    "nrOfActiveInstances");
            setLoopVariable(createExecution, "nrOfInstances", loopCounter + 1, true);
            setLoopVariable(createExecution, "nrOfActiveInstances",
                    nrOfCompletedInstances + 1, true);
        }
    }

    protected void setLoopVariable(ExecutionEntity execution,
                                   String variableName, Object value, boolean paretnt) {
        DelegateExecution parent = execution.getParent();
        parent.setVariableLocal(variableName, value);
    }

    protected Integer getLoopVariable(ExecutionEntity execution,
                                      String variableName) {
        Object value = execution.getVariableLocal(variableName);
        DelegateExecution parent = execution.getParent();
        while (value == null && parent != null) {
            value = parent.getVariableLocal(variableName);
            parent = parent.getParent();
        }
        return (Integer) (value != null ? value : 0);
    }

    // 最后调用执行 这个哪用放哪 上面弄一个单独的类 复用
    // processEngine.getManagementService().executeCommand(new AddTask(task.getExecutionId(), userList, targetNode));


}
