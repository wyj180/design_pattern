package com.example.demo.controller;

import com.example.demo.entity.BaseEventFormData;
import com.example.demo.entity.EventFormTable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ODMController {

    @RequestMapping("sqm/event/odm/process/sqeScore")
    public String GetUser(@RequestBody BaseEventFormData eventOdmVo) {
        System.out.println("接收到的参数 : " + eventOdmVo);
        return "success";
    }

    @RequestMapping("sqm/onePage")
    public String onePage(@RequestBody List<EventFormTable> formTables) {
        System.out.println("接收到的参数 : " + formTables);
        return "success";
    }

}