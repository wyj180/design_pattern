package com.example.demo.mapper;

import com.example.demo.dongtai.MybatisSQLTemplate3;
import com.example.demo.dongtai.MybatisSQLTemplate;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.Map;

/**
 * 自定义表单处理Mapper类
 */
public interface EventFormDataMapper {

    @InsertProvider(type = MybatisSQLTemplate.class, method = "insert")
    int insert(@Param("formData") Map<String, Object> formData, @Param("tableName") String tableName);

    @UpdateProvider(type = MybatisSQLTemplate.class, method = "updateById")
    int updateById(@Param("formData") Map<String, Object> formData, @Param("tableName") String tableName, @Param("id") Integer id);
}