package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.mapper.EventFormDataMapper;
import com.example.demo.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    @Resource
    UserMapper userMapper;

    @Resource
    EventFormDataMapper orderInfoMapper;

    public User sel(Integer id) {
        return userMapper.sel(id);
    }

    public User insertUser() {
        Map<String, Object> tableParams = new HashMap<>();
        tableParams.put("userName", "用户名1");
        tableParams.put("passWord", "密码1");
        tableParams.put("realName", "真实名字1");

        String tableName = "user";

        orderInfoMapper.insert(tableParams, tableName);

        return null;
    }

    public String updateUser(Integer id) {
        Map<String, Object> tableParams = new HashMap<>();
        tableParams.put("userName", "用户名666");
        tableParams.put("passWord", "密码666");
        tableParams.put("realName", "真实名字666");

        String tableName = "user";

        orderInfoMapper.updateById(tableParams, tableName, id);

        return "更新用户信息成功";
    }
}