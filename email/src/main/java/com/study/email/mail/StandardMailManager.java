/*
 * 文件名：StandardMailManager.java
 * 版权：Copyright 1984-2019 Lenovo Group. All Rights Reserved.
 * 描述：
 * 修改人：
 * 修改时间：
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */
package com.study.email.mail;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

/**
 * 发送邮件工具
 */
@Component
public class StandardMailManager {

    private Logger logger = LoggerFactory.getLogger(StandardMailManager.class);

    @Autowired
    @Qualifier("saMailSender")
    private JavaMailSender javaMailSender;

    @Autowired
    private Configuration configuration;

    @Value("${spring.mail.username}")
    private String emailFrom;

    @Async("asyncEmailExecutor")
    public void sendMailto(MailTemplate mailTemplate) throws MessagingException, IOException, TemplateException {
        setMailFrom(mailTemplate);
        sendMail(mailTemplate);
    }

    public void sendMail(MailTemplate mailTemplate) throws MessagingException, IOException, TemplateException {
        MimeMessage mimeMessage = getMimeMessage(mailTemplate);

        // 设置邮件收件人、抄送人、发送时间
        MimeMessageHelper helper = setEmailBaseInfo(mailTemplate, mimeMessage);

        //
        Template template = configuration.getTemplate(mailTemplate.getTemplateName());
        String text = FreeMarkerTemplateUtils.processTemplateIntoString(template, mailTemplate.getData());
        helper.setText(text, true);

        // 添加附件
        addAttachments(mailTemplate, helper);

        // 添加照片
        addImgs(mailTemplate, helper);

        // 发送邮件
        javaMailSender.send(mimeMessage);
    }

    private void setMailFrom(MailTemplate mailTemplate) {
        mailTemplate.setFrom(emailFrom);
    }

    private MimeMessageHelper setEmailBaseInfo(MailTemplate mailTemplate, MimeMessage mimeMessage) throws MessagingException {
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom(mailTemplate.getFrom());
        helper.setSubject(mailTemplate.getSubject());

        //multi to
        InternetAddress[] to = InternetAddress.parse(mailTemplate.getTo());
        mimeMessage.setRecipients(Message.RecipientType.TO, to);

        //multi cc
        if (StringUtils.isNotBlank(mailTemplate.getCc())) {
            InternetAddress[] cc = InternetAddress.parse(mailTemplate.getCc());
            mimeMessage.setRecipients(Message.RecipientType.CC, cc);
        }

        mimeMessage.setSentDate(new Date());
        return helper;
    }

    private void addAttachments(MailTemplate mailTemplate, MimeMessageHelper helper) {
        String attachmentName = mailTemplate.getAttachment();
        if (StringUtils.isNotBlank(attachmentName)) {
            String[] fileNames = attachmentName.split(",");
            Arrays.stream(fileNames).forEach(fileName -> {
                File file = new File(fileName);
                FileSystemResource attachment = new FileSystemResource(file);
                try {
                    helper.addAttachment(file.getName(), attachment);
                } catch (MessagingException e) {
                    e.printStackTrace();
                    logger.error("Mail add attachment error:", e);
                }
            });
        }
    }

    private void addImgs(MailTemplate mailTemplate, MimeMessageHelper helper) throws MessagingException {
        if (StringUtils.isNotEmpty(mailTemplate.getImgPath())) {
            File imgFile = new File(mailTemplate.getImgPath());
            FileSystemResource file = new FileSystemResource(imgFile);
            helper.addInline(mailTemplate.getImgId(), file);
        }
    }

    private MimeMessage getMimeMessage(MailTemplate templateMail) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        return mimeMessage;
    }

}
