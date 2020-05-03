package com.study.email.demo01;

import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

@Component
public class MailServiceImpl {

    @Autowired
    @Qualifier("saMailSender")
    private JavaMailSender mailSender;


    // 发送邮件的模板引擎
    @Autowired
    private FreeMarkerConfigurer configurer;

    @Value("${spring.mail.username}")
    private String from;

    public void sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from); // 邮件发送者
        message.setTo(to); // 邮件接收者
        message.setSubject(subject); // 主题
        message.setText(content); // 内容

        mailSender.send(message);
    }

    // 富文本邮件--发送带图片的邮件
    public void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId)
            throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content, true);

        File file = new File(rscPath);
        FileSystemResource res = new FileSystemResource(file);
        helper.addInline(rscId, res);

        mailSender.send(message);
    }

    public void sendAttachmentsMail(String to, String subject, String content, String filePath) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content, true);
        FileSystemResource file = new FileSystemResource(new File(filePath));
        String fileName = file.getFilename();
        helper.addAttachment(fileName, file);

        mailSender.send(message);
    }

    public void sendHtmlMail(String to, String subject, String content) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        //true 表⽰示需要创建⼀一个 multipart message
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content, true);
        mailSender.send(message);
    }

    /**
     * @param params       发送邮件的主题对象 object
     * @param title        邮件标题
     * @param templateName 模板名称
     */
    public void sendMessageMail(Object params, String title, String templateName) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(from);
            //helper.setTo("1915418799@qq.com");// 发送给谁
            //multi to
            InternetAddress[] to = InternetAddress.parse("1915418799@qq.com");
            mimeMessage.setRecipients(Message.RecipientType.TO, to);
            helper.setSubject("【" + title + "-" + LocalDate.now() + " " + LocalTime.now().withNano(0) + "】");// 邮件标题

            Map<String, Object> model = new HashMap<>();
            model.put("params", params); // 注意：这里的params名称和<td>${(params.cause)!""}</td> 中的params必须一样，否则取不到数据
            Template template = configurer.getConfiguration().getTemplate(templateName);
            String text = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);

            helper.setText(text, true);
            mailSender.send(mimeMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 带有照片的邮件
     */
    @Async("taskExecutor")
    public void sendImgMail(String to, String subject, String content, String imgPath, String imgId, String templateName, Map<String, Object> model) {
        try {
            //创建message
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            //发件人
            helper.setFrom(from);
            //收件人
            helper.setTo(to);
            //标题
            helper.setSubject(subject);
            //true指的是html邮件，false指的是普通文本

            // 使用freemarker发送邮件，text从freemarker获取即可
            Template template = configurer.getConfiguration().getTemplate(templateName);
            String text = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
            helper.setText(text, true);

            // 添加图片
            File imgFile = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "templates\\claims\\mcar_email_photo.png");
            FileSystemResource file = new FileSystemResource(imgFile);
            helper.addInline(imgId, file);

            // 添加附件
            FileSystemResource fileSystemResource = new FileSystemResource(new File("D:\\testDir\\0_excel\\2007.xlsx"));
            String fileName = file.getFilename();
            helper.addAttachment(fileName, fileSystemResource);

            //发送邮件
            mailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
