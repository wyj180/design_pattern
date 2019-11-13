package com.study.com.rabbitmq;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * MQ发送的消息
 */
@Setter
@Getter
@ToString
public class MQMailMessage {

    private Integer id;

    private String name;

}
