package com.study.email.mail;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MailTemplate implements Serializable {

    private static final long serialVersionUID = -167729929675195778L;

    private String from;
    private String to;
    private String cc;
    private String subject;

    // 邮件模板中需要动态变化的数据
    private Map<String, Object> data = new HashMap<>();

    // 邮件模板
    private String templateName;

    // 抄送人
    private Set<String> ccEmails = new HashSet<>();

    // 邮件附件
    private String attachment;

    // 邮件照片路径
    private String imgPath;
    /**
     * 照片ID，需要和freeMarker中的imgId的值保持一致
     * 示例：<img src='cid:${imgId}' />
     */
    private String imgId;

    private Integer appId;

    // 流程定义Key
    private String processDeployId;

    /**
     * 任务定义Key
     */
    private String taskKey;

    // 任务ID
    private String taskId;

    /**
     * 添加邮件抄送人
     */
    public void addCC(String cc) {
        if (StringUtils.isNotBlank(cc)) {
            ccEmails.add(cc);
        }
    }

    /**
     * 添加邮件抄送人
     */
    public void addCcEmails(Set<String> ccEmails) {
        if (!CollectionUtils.isEmpty(ccEmails)) {
            ccEmails.addAll(ccEmails);
        }
    }

    public void addMailContent(String key, Object value) {
        this.data.put(key, value);
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getImgId() {
        return imgId;
    }

    public void setImgId(String imgId) {
        this.imgId = imgId;
    }

    public String getTaskKey() {
        return taskKey;
    }

    public void setTaskKey(String taskKey) {
        this.taskKey = taskKey;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public String getProcessDeployId() {
        return processDeployId;
    }

    public void setProcessDeployId(String processDeployId) {
        this.processDeployId = processDeployId;
    }

    public Set<String> getCcEmails() {
        return ccEmails;
    }

    public void setCcEmails(Set<String> ccEmails) {
        this.ccEmails = ccEmails;
    }
}