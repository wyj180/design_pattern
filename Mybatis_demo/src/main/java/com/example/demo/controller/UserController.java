package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("getUser/{id}")
    public User GetUser(@PathVariable Integer id) {
        return userService.sel(id);
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