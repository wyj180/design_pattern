package com.study.com.controller;

import com.study.com.entity.PostParams;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class JacksonController {

    @GetMapping("getListParam")
    public String getListParam(ArrayList<String> params) {
        System.out.println("获取到的参数：" + params);
        return "success";
    }

    @PostMapping("getListPostParam")
    public String getListPostParam(ArrayList<String> params) {
        System.out.println("获取到的参数：" + params);
        return "success";
    }

    @PostMapping("getPostBodyParam")
    public String getPostBodyParam(@RequestBody ArrayList<String> params) {
        System.out.println("获取到的参数：" + params);
        return "success";
    }

    @PostMapping("getPostBodyParam2")
    public String getPostBodyParam2(@RequestBody PostParams postParams) {
        System.out.println("获取到的参数：" + postParams);
        return "success";
    }

    @PostMapping("getPostBodyString")
    public String getPostBodyParam2(@RequestBody String postParams) {
        System.out.println("获取到的参数：" + postParams);
        return "success";
    }

}
