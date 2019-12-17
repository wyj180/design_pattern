package com.example.demo.entity;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
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
     * in('value1', 'value2')查询条件
     */
    Map<String, List<Object>> ins;

    /**
     * 排序字段
     */
    Map<String, String> orders;

    public EventFormSQLParam() {

    }

    public EventFormSQLParam(BaseEventFormData formData) {
        HashMap<String, Object> data = formData.getFormData().getData();
        if (data != null && data.get("id") != null) {
            this.id = Integer.parseInt(data.get("id").toString());
        }
        this.tableName = formData.getFormData().getTableName();
        this.formData = data;
    }

    /**
     * 添加表单属性
     *
     * @param key
     * @param value
     */
    public void setFormData(String key, Object value) {
        formData = (formData == null) ? new HashMap<>() : formData;
        formData.put(key, value);
    }

    /**
     * 使用构建者模式创建对象
     *
     * @param builder
     */
    public EventFormSQLParam(Builder builder) {
        this.id = builder.id;
        this.tableName = builder.tableName;
        this.formData = builder.formData;
        this.conditions = builder.conditions;
        this.orders = builder.orders;
    }

    /**
     * 使用构建者模式创建对象
     */
    public static class Builder {
        private Integer id;
        private String tableName;
        private Map<String, Object> formData;
        private Map<String, Object> conditions;
        private Map<String, String> orders;
        Map<String, List<Object>> ins;

        public Builder(String tableName) {
            this.tableName = tableName;
        }

        public Builder(String tableName, Map<String, Object> formData) {
            this.tableName = tableName;
            this.formData = formData;
        }

        public Builder setCondition(Map<String, Object> conditions) {
            this.conditions = conditions;
            return this;
        }

        public Builder setOrders(Map<String, String> orders) {
            this.orders = orders;
            return this;
        }

        public Builder setIns(Map<String, List<Object>> ins) {
            this.ins = ins;
            return this;
        }

        public Builder setDefaultOrders() {
            // 默认根据创建时间倒序排序
            orders = (orders == null) ? new HashMap<>() : orders;
            orders.put("gmt_create", "desc");
            return this;
        }

        public Builder setId(Integer id) {
            this.id = id;
            return this;
        }

        public EventFormSQLParam build() {
            return new EventFormSQLParam(this);
        }
    }

}
