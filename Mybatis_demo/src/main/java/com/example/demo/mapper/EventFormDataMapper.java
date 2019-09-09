package com.example.demo.mapper;

import com.example.demo.dongtai.MybatisSQLTemplate;
import com.example.demo.entity.EventFormSQLParam;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * 自定义表单处理Mapper类
 */
public interface EventFormDataMapper<T> {

    @InsertProvider(type = MybatisSQLTemplate.class, method = "insert")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
        //@SelectKey(statement = "select last_insert_id()" ,keyProperty = "id",keyColumn = "id",resultType = long.class,before = false)
    int insert(EventFormSQLParam sqlParam);

    @UpdateProvider(type = MybatisSQLTemplate.class, method = "updateById")
    int updateById(EventFormSQLParam sqlParam);

    @SelectProvider(type = MybatisSQLTemplate.class, method = "selectOne")
    Map<String, Object> selectOne(EventFormSQLParam sqlParam);

    @SelectProvider(type = MybatisSQLTemplate.class, method = "selectList")
    List<Map<String, Object>> selectList(EventFormSQLParam sqlParam);

    @SelectProvider(type = MybatisSQLTemplate.class, method = "selectList")
    Page<Map<String, Object>> selectByPage(EventFormSQLParam sqlParam);

}