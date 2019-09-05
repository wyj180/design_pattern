package com.example.demo.service;

import com.example.demo.entity.EventFormSQLParam;
import com.example.demo.entity.User;
import com.example.demo.mapper.EventFormDataMapper;
import com.example.demo.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
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

    public Object getUser2(Integer id) {
        EventFormSQLParam sqlParam = new EventFormSQLParam();
        sqlParam.setTableName("user");
        sqlParam.setId(6);

        Object result = orderInfoMapper.selectOne(sqlParam);
        return result;
    }

    public List<Object> getList() {
        EventFormSQLParam sqlParam = new EventFormSQLParam();
        sqlParam.setTableName("user");

        Map<String, Object> conditions = new HashMap<>();
        conditions.put("userName", "AAA");
        //conditions.put("passWord", "AAA");
        sqlParam.setConditions(conditions);

        Map<String, String> orders = new HashMap<>();
        orders.put("userName", "desc");
        orders.put("passWord", "asc");
        sqlParam.setOrders(orders);

        List<Object> list = orderInfoMapper.selectList(sqlParam);
        return list;
    }

    public User insertUser() {
        Map<String, Object> tableParams = new HashMap<>();
        tableParams.put("userName", "用户名1");
        tableParams.put("passWord", "密码1");
        tableParams.put("realName", "真实名字1");

        String tableName = "user";

        EventFormSQLParam sqlParam = new EventFormSQLParam();
        sqlParam.setTableName(tableName);
        sqlParam.setFormData(tableParams);

        orderInfoMapper.insert(sqlParam);

        return null;
    }

    public String updateUser(Integer id) {
        Map<String, Object> tableParams = new HashMap<>();
        //tableParams.put("userName", "用户名6667");
       // tableParams.put("passWord", "密码6667");
        tableParams.put("realName", "真实名字777");

        String tableName = "user";

        EventFormSQLParam sqlParam = new EventFormSQLParam();
        sqlParam.setTableName(tableName);
        sqlParam.setFormData(tableParams);

        sqlParam.setId(6);

        orderInfoMapper.updateById(sqlParam);

        return "更新用户信息成功";
    }
}