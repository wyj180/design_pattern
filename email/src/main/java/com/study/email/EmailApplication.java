package com.study.email;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.annotation.PostConstruct;

@EnableAsync
@SpringBootApplication
public class EmailApplication {


    public static void main(String[] args) {
        SpringApplication.run(EmailApplication.class, args);
    }

    @PostConstruct
    public void test01() {
       // System.out.println("aaaa ====== " + name);
        System.out.println("启动成功====================");
    }

}

