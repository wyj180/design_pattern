package com.study.rabbitmq_demo2.controller;

import com.study.rabbitmq_demo2.rabbitmq.MsgProducer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private MsgProducer msgProducer;

    @RequestMapping("testMQ")
    public String testMQ() {
        msgProducer.sendMsg("发送内容");
        return "success";
    }

}
