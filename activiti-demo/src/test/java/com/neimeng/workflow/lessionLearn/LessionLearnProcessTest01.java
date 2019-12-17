package com.neimeng.workflow.lessionLearn;

import com.neimeng.workflow.WorkflowApplicationTests;
import com.neimeng.workflow.taskHandler.command.AddMultiInstanceCmd;
import org.activiti.engine.ManagementService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Lesson Learn 流程
 */
public class LessionLearnProcessTest01 extends WorkflowApplicationTests {

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
                .name("Lesson Learn") // 添加部署的名称
                .addClasspathResource("processes/EVENT_LESSON_LEARN.bpmn20_002.xml") // 从classpath的资源中加载，一次只能加载一个文件
                .deploy();// 部署

        System.out.println("部署ID：" + deployment.getId());
        System.out.println("部署名称：" + deployment.getName());
    }

    /**
     * 第二步：启动流程实例
     */
    @Test
    public void startProcessInstance() {
        //根据流程定义的key启动流程
        String processDefinitionKey = "EVENT_LESSON_LEARN";

        Map<String, Object> variables = new HashMap<>();
        variables.put("peOnly", false);

        ProcessInstance pi = runtimeService
                .startProcessInstanceByKey(processDefinitionKey, variables);//使用流程定义的key启动流程实例，key对应bpmn文件中id的属性值，使用key值启动，默认是按照最新版本的流程定义启动

        System.out.println("流程实例ID:" + pi.getId());
        System.out.println("流程定义ID:" + pi.getProcessDefinitionId());
    }

    /**
     * 第三步：查询当前人的个人任务
     */
    @Test
    public void findMyPersonalTask() {
        String assignee = "王五";

        List<Task> taskList = taskService.createTaskQuery().processInstanceId("5001").list();
        System.out.println("当前任务处理人：" + taskList.get(0).getAssignee());
        System.out.println("指派任务新处理人：" + assignee);
        taskService.setAssignee(taskList.get(0).getId(), assignee);

        // 查询新处理人的任务
        List<Task> list = taskService
                .createTaskQuery()//创建任务查询对象
                .taskAssignee(assignee)//指定个人任务查询，指定办理人
                .list();

        printTaskInfo(list);
    }

    private void printTaskInfo(List<Task> list) {
        if (list != null && list.size() > 0) {
            for (Task task : list) {
                System.out.println("------------------------------------------------");
                System.out.println("任务ID:" + task.getId());
                System.out.println("任务名称:" + task.getName());
                System.out.println("任务的创建时间:" + task.getCreateTime());
                System.out.println("任务的办理人:" + task.getAssignee());
                System.out.println("流程实例ID：" + task.getProcessInstanceId());
                System.out.println("执行对象ID:" + task.getExecutionId());
                System.out.println("流程定义ID:" + task.getProcessDefinitionId());
                System.out.println("------------------------------------------------");
            }
        }
    }

    /**
     * 第四步：完成我的任务
     */
    @Test
    public void completeMyPersonalTask() {
        String taskId = "77506";  // 任务ID
        Map<String, Object> variables = new HashMap<>();
        variables.put("result", 1);

        taskService.complete(taskId, variables);
        System.out.println("完成任务，任务ID = ：" + taskId);
    }

    /**
     * 第四步：完成我的任务
     */
    @Test
    public void pqmCompleteTask() {
        String taskId = "60004";  // 任务ID


        Map<String, Object> variables = new HashMap<>();
        List<String> owerList = new ArrayList<>();
        owerList.add("zs");
        owerList.add("zs2");
        owerList.add("zs3");

        variables.put("ownerList", owerList);
        variables.put("subProcessEnd", false);

        taskService.complete(taskId, variables);
        System.out.println("完成任务，任务ID = ：" + taskId);
    }

    /**
     * 第五步：删除多实例任务
     */
    @Test
    public void deleteMultiInstance() {
//        DeleteMultiInstanceCmd deleteMultiInstanceCmd = new DeleteMultiInstanceCmd("15001", true);
//        managementService.executeCommand(deleteMultiInstanceCmd);

        AddMultiInstanceCmd addMultiInstanceCmd =
                new AddMultiInstanceCmd("17501", "AA");
        managementService.executeCommand(addMultiInstanceCmd);
    }

    /**
     * 第五步：添加多实例任务
     */
    @Test
    public void addMultiInstance() {
//        DeleteMultiInstanceCmd deleteMultiInstanceCmd = new DeleteMultiInstanceCmd("15001", true);
//        managementService.executeCommand(deleteMultiInstanceCmd);

        AddMultiInstanceCmd addMultiInstanceCmd =
                new AddMultiInstanceCmd("17501", "AA");
        managementService.executeCommand(addMultiInstanceCmd);
    }

    @Test
    public void queryCurrentTask() {
        List<Task> list = taskService.createTaskQuery().processInstanceId("5001").list();
        printTaskInfo(list);
    }

}
