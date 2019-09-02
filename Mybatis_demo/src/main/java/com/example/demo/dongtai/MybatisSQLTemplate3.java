package com.example.demo.dongtai;

import org.apache.ibatis.jdbc.SQL;

import java.util.Map;
import java.util.stream.Collectors;

public class MybatisSQLTemplate3 {

    private final String TABLE_NAME = "tableName";

    /**
     * 插入数据
     *
     * @param params
     * @return
     */
    public String insert(Map<String, Object> params) {
        return new SQL()
                .INSERT_INTO(getTableName(params))
                .VALUES(buildFiled(params), buildValue(params))
                .toString();
    }

    /**
     * 更新数据
     *
     * @param params
     * @return
     */
    public String update(Map<String, Object> params) {
        return new SQL()
                .UPDATE(getTableName(params))
                .SET(buildSet(params))
                .WHERE(buildWhere(params))
                .toString();
    }

    /**
     * 获取表名
     *
     * @param params
     * @return
     */
    private String getTableName(Map<String, Object> params) {
        if (params == null || params.get(TABLE_NAME) == null) {
            throw new IllegalArgumentException("Table name is required..");
        } else {
            return params.get(TABLE_NAME).toString();
        }
    }

    /**
     * 构建插入字段
     *
     * @param params
     * @return
     */
    private String buildFiled(Map<String, Object> params) {
        params.remove(TABLE_NAME);
        if (params.isEmpty()) {
            throw new IllegalArgumentException("Parameter name is required..");
        }
        String columns = params.keySet().toString();
        return columns.substring(1, columns.length() - 1);
    }

    /**
     * 构建插入value值
     *
     * @param params
     * @return
     */
    private String buildValue(Map<String, Object> params) {
        params.remove(TABLE_NAME);
        if (params.isEmpty()) {
            throw new IllegalArgumentException("Parameter value is required..");
        }
        String columns = params.keySet().stream().map(i -> "#{" + i + "}").collect(Collectors.toList()).toString();
        return columns.substring(1, columns.length() - 1);
    }

    /**
     * 构建更新set数据
     *
     * @param params
     * @return
     */
    private String buildSet(Map<String, Object> params) {
        params.remove(TABLE_NAME);
        if (params.isEmpty()) {
            throw new IllegalArgumentException("The value to be modified cannot be empty..");
        }
        Object temp = params.remove(TABLE_NAME);
        String sets = params.keySet().stream().map(i -> i + "=#{" + i + "}").collect(Collectors.toList()).toString();
        params.put(TABLE_NAME, temp);
        return sets.substring(1, sets.length() - 1);
    }

    /**
     * 构建where条件（目前只支持单个条件）
     *
     * @param params
     * @return
     */
    private String buildWhere(Map<String, Object> params) {
        params.remove(TABLE_NAME);
        if (params.isEmpty() || params.get(TABLE_NAME) == null) {
            throw new IllegalArgumentException("Missing where condition..");
        }
        Object where = params.get(TABLE_NAME);
        //可以做多类型判断以兼容更复杂where条件
        if (where instanceof String) {
            String temp = (String) where;
            return temp + "= #{" + where + "}";
        } else {
            throw new IllegalArgumentException("Where argument is illegal..");
        }
    }
}