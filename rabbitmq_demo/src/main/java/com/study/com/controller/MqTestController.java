package com.study.com.controller;

import com.study.com.rabbitmq.MQMailMessage;
import com.study.com.rabbitmq.MQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * MQ测试Controller
 */
@RestController
public class MqTestController {

    @Autowired
    private MQSender mqSender;

    @RequestMapping("testMq")
    public String sendMail() {
        MQMailMessage mailMessage = new MQMailMessage();
        mqSender.sendMailMessage(mailMessage);
        return "success";
    }

}
