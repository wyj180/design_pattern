package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.entity.queryParam.EventListPageQuery;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("insertMuiti")
    public String insertMuiti() {
        userService.insertMuiti();
        return "success";
    }

    @RequestMapping("getUser/{id}")
    public User getUser(@PathVariable Integer id) {
        return userService.sel(id);
    }

    @RequestMapping("getUser2/{id}")
    public Object getUser2(@PathVariable Integer id) {
        return userService.getUser2(id);
    }

    // 分页查询
    @RequestMapping("getUserByPage")
    public Object getUserByPage(EventListPageQuery pageQuery) {
        return userService.getByPage(pageQuery);
    }

    @RequestMapping("getList")
    public List<Object> getList() {
        return userService.getList();
    }

    @RequestMapping("insertUser")
    public User insertUser() {
        return userService.insertUser();
    }

    @GetMapping("updateUser/{id}")
    public String updateUser(@PathVariable Integer id) {
        return userService.updateUser(id);
    }
}