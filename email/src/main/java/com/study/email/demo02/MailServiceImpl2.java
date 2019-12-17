package com.study.email.demo02;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import freemarker.template.Template;

@Component
public class MailServiceImpl2 {

    @Autowired
    private JavaMailSender mailSender;

    //发送邮件的模板引擎
    @Autowired
    private FreeMarkerConfigurer configurer;

    @Value("${spring.mail.username}")
    private String from;

    /**
     * @param model        发送邮件的主题对象 object
     * @param title        邮件标题
     * @param templateName 模板名称
     */
    public void sendMessageMail(Map<String, Object> model, String title, String templateName) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(from);
            //helper.setTo("1915418799@qq.com");// 发送给谁 写法一
            //multi to
            InternetAddress[] to = InternetAddress.parse("1915418799@qq.com");
            mimeMessage.setRecipients(Message.RecipientType.TO, to); // 发送给指定用户，写法二
            helper.setSubject("【" + title + "-" + LocalDate.now() + " " + LocalTime.now().withNano(0) + "】");// 邮件标题

            //model.put("params", params); // 注意：这里的params名称和<td>${(params.cause)!""}</td> 中的params必须一样，否则取不到数据
            Template template = configurer.getConfiguration().getTemplate(templateName);
            String text = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);

            // 添加附件
            FileSystemResource file = new FileSystemResource(new File("D:\\excel\\SA_template_map05_5.xlsx"));
            String fileName = file.getFilename();
            helper.addAttachment(fileName, file);

            helper.setText(text, true);
            mailSender.send(mimeMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
