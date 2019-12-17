package com.neimeng.workflow.muitiInstance;

import com.neimeng.workflow.WorkflowApplicationTests;
import com.neimeng.workflow.taskHandler.command.AddMultiInstanceCmd;
import com.neimeng.workflow.taskHandler.command.DeleteMultiInstanceCmd;
import org.activiti.engine.ManagementService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 子流程多实例测试(测试成功)
 *
 * 说明：运行到子流程这一步时，创建多个子流程实例
 *       多个子流程第一个任务处理人从接口中获取，需要在第一个任务配置处理人${userName}
 *
 */
public class MuitiInstanceAndSubProcessTest02 extends WorkflowApplicationTests {

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private ManagementService managementService;

    /**
     * 第一步：部署流程定义
     */
    @Test
    public void deploymentProcessDefinition() {
        Deployment deployment = repositoryService
                .createDeployment()// 创建一个部署对象
                .name("子流程一")// 添加部署的名称
                .addClasspathResource("processes/muitiProcess004.bpmn20.xml")// 从classpath的资源中加载，一次只能加载一个文件
                .deploy(); // 部署

        System.out.println("部署ID：" + deployment.getId());
        System.out.println("部署名称：" + deployment.getName());
        System.out.println("部署Key：" + deployment.getKey()); // 这个key并不是我们画流程里面的key

        startProcessInstance();
    }

    /**
     * 第二步：启动流程实例
     */
    @Test
    public void startProcessInstance() {
        //根据流程定义的key启动流程
        String processDefinitionKey = "muitiSubProcess004";

        ProcessInstance pi = runtimeService
                .startProcessInstanceByKey(processDefinitionKey);// 使用流程定义的key启动流程实例，key对应bpmn文件中id的属性值，使用key值启动，默认是按照最新版本的流程定义启动

        System.out.println("流程实例ID:" + pi.getId());// 流程实例ID    101
        System.out.println("流程定义ID:" + pi.getProcessDefinitionId());// 流程定义ID   key01:1:4

        completeTask(pi);
    }

    /**
     * 第四步：完成我的任务
     */
    @Test
    public void completeMyPersonalTask() {
        String taskId = "95033";
        Map<String, Object> variables = new HashMap<>();
        taskService.complete(taskId, variables);
        System.out.println("完成任务，任务ID = ：" + taskId);
    }

    public void completeTask(ProcessInstance processInstance) {
        List<Task> list = taskService.createTaskQuery().processInstanceId(processInstance.getId()).list();
        String taskId = list.get(0).getId();

        Map<String, Object> variables = new HashMap<>();
        taskService.complete(taskId, variables);
        System.out.println("完成任务，任务ID = ：" + taskId);
    }

    /**
     * 第五步：删除多实例任务
     */
    @Test
    public void deleteMultiInstance() {
        // TODO删除子流程功能未实现
        DeleteMultiInstanceCmd deleteMultiInstanceCmd = new DeleteMultiInstanceCmd("15001", true);
        managementService.executeCommand(deleteMultiInstanceCmd);
    }

    /**
     * 第五步：添加多实例任务
     */
    @Test
    public void addMultiInstance() {
        AddMultiInstanceCmd addMultiInstanceCmd =
                new AddMultiInstanceCmd("17501", "AA");
        managementService.executeCommand(addMultiInstanceCmd);
    }

}
