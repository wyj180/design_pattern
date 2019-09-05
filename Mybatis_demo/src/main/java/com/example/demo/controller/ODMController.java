package com.example.demo.controller;

import com.example.demo.entity.BaseEventFormData;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ODMController {

    @RequestMapping("sqm/event/odm/process/sqeScore")
    public String GetUser(@RequestBody BaseEventFormData eventOdmVo) {
        System.out.println("接收到的参数 : " + eventOdmVo);
        return "success";
    }

}