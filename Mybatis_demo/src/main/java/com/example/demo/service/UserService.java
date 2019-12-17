package com.example.demo.service;

import com.example.demo.entity.EventFormSQLParam;
import com.example.demo.entity.User;
import com.example.demo.entity.queryParam.EventListPageQuery;
import com.example.demo.mapper.EventFormDataMapper;
import com.example.demo.mapper.UserMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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

        int result = orderInfoMapper.insert(sqlParam);
        System.out.println("插入的数据id : " + result);

        return null;
    }

    public PageInfo<Map<String, Object>> getByPage(EventListPageQuery pageQuery) {
        Page<Map<String, Object>> pageList = null;
        //if (StringUtils.isNotBlank(pageQuery.getKey())) {
        if (false) {
            //search from elastic service
            //pageList = eventSearchService.searchOnePageByPage(pageQuery);
        } else {
            String tableName = "user";
            PageHelper.startPage(pageQuery.getPageNum(), pageQuery.getPageSize());

            Map<String, List<Object>> ins = new HashMap<>();
            List<Object> names = new ArrayList<>();
            names.add("admin");
            names.add("abc");
            ins.put("userName", names);
            List<Object> pass = new ArrayList<>();
            pass.add("1");
            pass.add("2");
            ins.put("id", pass);


            EventFormSQLParam formSQLParam = new EventFormSQLParam.Builder(tableName).setDefaultOrders().build();
            formSQLParam.setIns(ins);

            pageList = orderInfoMapper.selectByPage(formSQLParam);
        }
        return new PageInfo<>(pageList);
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