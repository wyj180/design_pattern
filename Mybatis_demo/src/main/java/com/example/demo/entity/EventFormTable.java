package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 自定义表单内容
 */
@Getter
@Setter
@ToString
public class EventFormTable {

    /**
     * 表格里面的值
     */
    private ArrayList<HashMap<String, Object>> data;

    /**
     * 表单关联的数据库表
     */
    private String tableName;

}
