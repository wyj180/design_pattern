package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @RequestMapping("hello")
    @ResponseBody
    public String helloWorld() {
        return "success";
    }

    // @RequestMapping("/") // 访问失败
    @GetMapping("/") // spring boot 1.5.6版本的写法，2.0版本之后不可以再这么写
    public String index() {
        return "/index.html"; // 写法正确
        // return "index"; // 写法错误，找不到index.html页面
    }
}
