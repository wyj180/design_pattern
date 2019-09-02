package com.example.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;

/**
 * 自定义表单内容
 */
@Getter
@Setter
@ToString
public class EventFormData {

    /**
     * 输入文本框名称和对应的值
     */
    private HashMap<String, Object> data;

    private String dataPrimary;

    private Integer dataSourceId;

    private Integer reportId;

    /**
     * 表单关联的数据库表
     */
    private String tableName;

}
