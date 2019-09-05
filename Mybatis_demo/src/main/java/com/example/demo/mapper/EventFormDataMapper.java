package com.example.demo.mapper;

import com.example.demo.dongtai.MybatisSQLTemplate;
import com.example.demo.entity.EventFormSQLParam;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;
import java.util.Map;

/**
 * 自定义表单处理Mapper类
 */
public interface EventFormDataMapper<T> {

    @InsertProvider(type = MybatisSQLTemplate.class, method = "insert")
    int insert(EventFormSQLParam sqlParam);

    @UpdateProvider(type = MybatisSQLTemplate.class, method = "updateById")
    int updateById(EventFormSQLParam sqlParam);

    @SelectProvider(type = MybatisSQLTemplate.class, method = "selectOne")
    Map<String, Object> selectOne(EventFormSQLParam sqlParam);

    @SelectProvider(type = MybatisSQLTemplate.class, method = "selectList")
    List<Map<String, Object>> selectList(EventFormSQLParam sqlParam);

}