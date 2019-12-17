package com.neimeng.workflow.subProcess;

import com.neimeng.workflow.WorkflowApplicationTests;
import org.activiti.engine.ManagementService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * 子流程测试(测试成功)
 * <p>
 * 注意：不是子流程多实例，这里是纯子流程
 * <p>
 * 功能点描述：
 * 1、注意在muiti_instance.bpmn20.xml中，没有给子流程设置处理人，也没有设置子流程为多实例，
 * 因此在走到子流程时，默认只会开启一个子流程，而且没有指派任务处理人
 */
public class SubProcessTest01 extends WorkflowApplicationTests {

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
                .createDeployment() // 创建一个部署对象
                .name("流程") // 添加部署的名称
                .addClasspathResource("processes/subProcess001.bpmn20.xml") // 从classpath的资源中加载，一次只能加载一个文件
                .deploy(); // 部署

        System.out.println("部署ID：" + deployment.getId());
        System.out.println("部署名称：" + deployment.getName());

        startProcessInstance();
    }

    /**
     * 第二步：启动流程实例
     */
    @Test
    public void startProcessInstance() {
        // 根据流程定义的key启动流程
        String processDefinitionKey = "subProcessKey001";

        ProcessInstance pi = runtimeService
                .startProcessInstanceByKey(processDefinitionKey);// 使用流程定义的key启动流程实例，key对应bpmn文件中id的属性值，使用key值启动，默认是按照最新版本的流程定义启动

        System.out.println("流程实例ID:" + pi.getId());
        System.out.println("流程定义ID:" + pi.getProcessDefinitionId());
    }

    /**
     * 第四步：完成我的任务
     */
    @Test
    public void completeMyPersonalTask() {
        String taskId = "82509";
        Map<String, Object> variables = new HashMap<>();
        taskService.complete(taskId, variables);
        System.out.println("完成任务，任务ID = ：" + taskId);
    }

}
