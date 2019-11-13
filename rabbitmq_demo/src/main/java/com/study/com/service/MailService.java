package com.study.com.service;

import org.springframework.stereotype.Service;

/**
 * 发送邮件Service
 */
@Service
public class MailService {

    public void sendMail() {
        System.out.println("发送邮件成功...");
    }
}
