package com.neimeng.workflow.muitiInstance;

import com.neimeng.workflow.WorkflowApplicationTests;
import com.neimeng.workflow.taskHandler.command.AddMultiInstanceCmd;
import com.neimeng.workflow.taskHandler.command.DeleteMultiInstanceCmd2;
import org.activiti.engine.ManagementService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试通过一个流程变量设置子流程多个任务处理人(测试ing)
 */
public class MuitiInstanceAndSubProcessTest06 extends WorkflowApplicationTests {

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
                .name("子流程_设置处理人")// 添加部署的名称
                .addClasspathResource("processes/muitiProcess007.bpmn20.xml")// 从classpath的资源中加载，一次只能加载一个文件
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
        // 根据流程定义的key启动流程
        String processDefinitionKey = "muitiSubProcess0007";

        // 通过流程变量，给子流程第一个任务设置处理人
        Map<String, Object> variables = new HashMap<>();
        variables.put("userNameList", Arrays.asList("MM", "NN"));

        ProcessInstance pi = runtimeService
                .startProcessInstanceByKey(processDefinitionKey, variables);// 使用流程定义的key启动流程实例，key对应bpmn文件中id的属性值，使用key值启动，默认是按照最新版本的流程定义启动

        System.out.println("流程实例ID:" + pi.getId());// 流程实例ID    101
        System.out.println("流程定义ID:" + pi.getProcessDefinitionId());// 流程定义ID   key01:1:4

        completeTask(pi);
    }

    /**
     * 第四步：完成我的任务
     */
    @Test
    public void completeTask() {
        String taskId = "310033";
        Map<String, Object> variables = new HashMap<>();
        variables.put("endAllSubProcess", 1); // 错误，这样设置不会结束所有子流程

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

    @Test
    public void setVariables(){
        runtimeService.setVariable("247529", "endAllSubProcess", 1);

        //completeTask();

        System.out.println("运行完成");
    }

    /**
     * 第五步：删除多实例任务
     * 添加一个子流程实例，act_ru_task会删除一个task任务，act_ru_execution表会也会删除两条执行实例信息
     */
    @Test
    public void deleteMultiInstance() {
        // 100026(根据taskId获取到的执行实例ID) -> (100018) -> (100013(根据该执行实例可以获取正在运行的执行实例数量、总执行实例数量)) -> (100005) -> (null)
        DeleteMultiInstanceCmd2 deleteMultiInstanceCmd = new DeleteMultiInstanceCmd2("267514", false);
        managementService.executeCommand(deleteMultiInstanceCmd);

        DeleteMultiInstanceCmd2 deleteMultiInstanceCmd2 = new DeleteMultiInstanceCmd2("265040", false);
        managementService.executeCommand(deleteMultiInstanceCmd2);

        System.out.println("运行完成");
    }

    /**
     * 第五步：添加多实例任务
     * 添加一个子流程实例，act_ru_task会多出一个task任务，act_ru_execution表会多出两条执行实例信息
     */
    @Test
    public void addMultiInstance() {
        // 这里的10013，数据库对应的执行实例数据中，IS_ACTIVE_ 的值为0，其他的值为1

        // 给子流程设置第一个任务处理人
        runtimeService.setVariable("265011", "userName", "GGG");
        runtimeService.setVariable("265011", "endAllSubProcess", 1);

        AddMultiInstanceCmd addMultiInstanceCmd =
                new AddMultiInstanceCmd("265011", "BBB");
        managementService.executeCommand(addMultiInstanceCmd);

        AddMultiInstanceCmd addMultiInstanceCmd2 =
                new AddMultiInstanceCmd("265011", "CCC");
        managementService.executeCommand(addMultiInstanceCmd2);
    }

}
