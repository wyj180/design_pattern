package com.study.email.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

/**
 * 发送邮件的JavaMailSenderImpl，可以不写该类，此时使用读取配置文件中的邮件配置构建的JavaMailSenderImpl发送邮件
 */
@Configuration
public class MailSender {

    @Autowired
    private LocalMailConfig localMailConfig;

    @Bean
    @Primary
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.163.com");
        mailSender.setUsername("root1994vip@163.com");
        mailSender.setPassword("111111zxc");
        mailSender.setDefaultEncoding("utf-8");

//        Properties properties = new Properties();
//        properties.setProperty("mail.smtp.auth", "true");
//        properties.setProperty("mail.smtp.starttls.enable", "false");
//        properties.setProperty("mail.smtp.starttls.required", "false");
//        mailSender.setJavaMailProperties(properties);
        return mailSender;
    }

    /**
     * sa mail sender
     *
     * @return
     */
    @Bean(name = "saMailSender")
    public JavaMailSender saMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.163.com");
        mailSender.setUsername("18010626471@163.com");
        mailSender.setPassword("wyj18010626471");
        mailSender.setDefaultEncoding("utf-8");

        Properties properties = new Properties();
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "false");
        properties.setProperty("mail.smtp.starttls.required", "false");
        mailSender.setJavaMailProperties(properties);
        return mailSender;
    }
}
