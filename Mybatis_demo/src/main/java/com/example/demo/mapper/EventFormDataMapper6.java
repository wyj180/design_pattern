package com.example.demo.mapper;

import com.example.demo.dongtai.MybatisSQLTemplate;
import com.example.demo.dongtai.MybatisSQLTemplate3;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.Map;

/**
 * 自定义表单处理Mapper类
 */
public interface EventFormDataMapper6 {

    @InsertProvider(type = MybatisSQLTemplate3.class, method = "insert")
    int insert(Map<String, Object> params);

    @UpdateProvider(type = MybatisSQLTemplate3.class, method = "update")
    int update(Map<String, Object> params);
}