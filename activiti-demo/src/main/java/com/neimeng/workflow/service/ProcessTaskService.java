package com.neimeng.workflow.service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Attachment;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 运行中的Task相关的Service
 */
@Slf4j
@Service
@Transactional
public class ProcessTaskService {

    @Autowired
    private TaskService taskService;

    /**
     * 完成任务，不设置流程变量
     *
     * @param taskId
     */
    public void completeTask(String taskId) {
        taskService.complete(taskId);
    }

    /**
     * 完成任务，并设置流程变量
     *
     * @param taskId
     * @param variables
     */
    public void complete(String taskId, Map<String, Object> variables) {
        taskService.complete(taskId, variables);
    }

    /**
     * 查询指定用户任务
     *
     * @param assignee
     * @return
     */
    public List<Task> getUserTasks(String assignee) {
        List<Task> list = taskService.createTaskQuery().taskAssignee(assignee).orderByTaskCreateTime().asc().list();
        return list;
    }

    /**
     * 指派用户任务
     *
     * @param taskId
     * @param userId
     */
    public void setAssigneeTask(String taskId, String userId) {
        taskService.setAssignee(taskId, userId);
    }

    /**
     * 根据任务id获取任务实例
     *
     * @param taskId
     * @return
     */
    public Task getTaskByTaskId(String taskId) {
        List<Task> tasks = taskService.createTaskQuery().taskId(taskId).list();
        if (tasks == null || tasks.size() == 0) {
            return null;
        } else if (tasks.size() != 1) {
            throw new RuntimeException("获取任务信息出错");
        }
        return tasks.get(0);
    }

    /**
     * 读取直接分配给当前人的任务
     *
     * @param taskAssignee
     * @return
     */
    public List<Task> getTasksByUserId(String taskAssignee) {
        return taskService.createTaskQuery().taskAssignee(taskAssignee).list();
    }

    /**
     * 设置变量
     *
     * @param taskId
     * @param variableName
     * @param value
     */
    public void setVariable(String taskId, String variableName, Object value) {
        taskService.setVariable(taskId, variableName, value);
    }

    /**
     * 根据流程定义key和任务处理人查找相关任务
     *
     * @param assignee
     * @param processDefinitionKey
     * @return
     */
    public List<Task> getTaskCandidateOrAssignedByKey(String assignee, String processDefinitionKey) {
        List<Task> tasks = taskService.createTaskQuery().taskCandidateOrAssigned(assignee)
                .processDefinitionKey(processDefinitionKey).list();
        return tasks;
    }

    /**
     * Purpose：创建文件类型的附件
     *
     * @param attachmentType        文件类型
     * @param taskId                任务id
     * @param processInstanceId     流程id
     * @param attachmentName        文件名称
     * @param attachmentDescription 文件描述
     * @param content               文件内容
     * @return Attachment
     */
    public Attachment createAttachment(String attachmentType, String taskId, String processInstanceId,
                                       String attachmentName, String attachmentDescription, InputStream content) {
        return taskService.createAttachment(attachmentType, taskId, processInstanceId, attachmentName,
                attachmentDescription, content);
    }

    /**
     * Purpose：修改后保存文件
     *
     * @param attachment
     */
    public void saveAttachment(Attachment attachment) {
        taskService.saveAttachment(attachment);
    }

    /**
     * 删除附件
     *
     * @param attachmentId
     */
    public void deleteAttachment(String attachmentId) {
        taskService.deleteAttachment(attachmentId);
    }

    /**
     * 根据任务id获取相应附件信息
     *
     * @param taskId
     * @return
     */
    public List<Attachment> getTaskAttachments(String taskId) {
        return taskService.getTaskAttachments(taskId);
    }

    /**
     * 根据附件id获取附件信息
     *
     * @param attachmentId
     * @return
     */
    public Attachment getAttachment(String attachmentId) {
        return taskService.getAttachment(attachmentId);
    }

    /**
     * 根据附件id获取附件内容
     *
     * @param attachmentId
     * @return
     */
    public InputStream getAttachmentContent(String attachmentId) {
        return taskService.getAttachmentContent(attachmentId);
    }

    /**
     * 获取流程变量
     *
     * @param taskId
     * @param variableName
     * @return
     */
    public Object getVariable(String taskId, String variableName) {
        return taskService.getVariable(taskId, variableName);
    }

    /**
     * 根据流程定义id获取相关附件信息列表
     *
     * @param processInstanceId
     * @return
     */
    public List<Attachment> getAttachmentByProcessInstanceId(String processInstanceId) {
        return taskService.getProcessInstanceAttachments(processInstanceId);
    }

    /**
     * 删除当前任务相关附件
     *
     * @param taskId
     */
    public void deleteTaskAttachment(String taskId) {
        List<Attachment> attachments = taskService.getTaskAttachments(taskId);
        if (attachments != null) {
            for (Attachment attachment : attachments) {
                taskService.deleteAttachment(attachment.getId());
            }
        }
    }

}