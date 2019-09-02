package com.example.demo.entity;

import lombok.Data;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.Map;

/**
 * 表单查询参数
 */
@Data
public class EventFormSQLParam {

    Integer id;

    /**
     * 数据库表名称
     */
    String tableName;

    /**
     * 自定义表单信息，key对应数据库的字段名
     */
    Map<String, Object> formData;

    /**
     * 删除/更新/查询的条件
     */
    Map<String, Object> conditions;

    /**
     * 排序字段
     */
    Map<String, String> orders = new HashMap<>();

    /**
     * 获取需要排序的字段
     *
     * @return
     */
    public Map<String, String> getOrders() {
        if (orders.size() == 0) {
            return getDefaultOrder();
        }
        return orders;
    }

    /**
     * 默认根据创建时间倒序排序
     *
     * @return
     */
    public Map<String, String> getDefaultOrder() {
        orders.put("gmt_create", "desc");
        return orders;
    }

}
