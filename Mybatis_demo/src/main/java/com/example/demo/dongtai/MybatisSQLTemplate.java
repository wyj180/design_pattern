package com.example.demo.dongtai;

import com.example.demo.entity.EventFormSQLParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;
import java.util.stream.Collectors;

public class MybatisSQLTemplate {

    /**
     * 插入数据
     *
     * @param formData
     * @param tableName
     * @return
     */
    public String insert(Map<String, Object> formData, String tableName) {
        String sql = new SQL()
                .INSERT_INTO(tableName)
                .VALUES(buildFiled(formData), buildValue(formData))
                .toString();
        return sql;
    }

    /**
     * 更新数据
     *
     * @param formData
     * @return
     */
    public String updateById(Map<String, Object> formData, String tableName, Integer id) {
        String sql = new SQL()
                .UPDATE(tableName)
                .SET(buildSet(formData))
                .WHERE(buildIdWhere(id))
                .toString();
        return sql;
    }

    /**
     * 查询单条数据
     *
     * @param param
     * @return
     */
    public String selectOne(EventFormSQLParam param) {
        return new SQL() {{
            SELECT(buildSelectFiled(param.getFormData()));
            FROM(param.getTableName());
            if (param.getConditions() != null) {
                WHERE(buildWhere(param.getConditions()));
            }
            ORDER_BY(buildOrder(param.getConditions()));
        }}.toString();
    }

    /**
     * 构建插入字段
     *
     * @param formData
     * @return
     */
    private String buildFiled(Map<String, Object> formData) {
        if (formData.isEmpty()) {
            throw new IllegalArgumentException("Parameter name is required");
        }
        String columns = formData.keySet().toString();
        return columns.substring(1, columns.length() - 1);
    }

    /**
     * 构建查询字段，如果没有指定查询字段，则默认查询全部字段
     *
     * @param formData
     * @return
     */
    private String buildSelectFiled(Map<String, Object> formData) {
        if (formData.isEmpty()) {
            return "*";
        }
        return buildFiled(formData);
    }

    /**
     * 构建插入value值
     *
     * @param formData
     * @return
     */
    private String buildValue(Map<String, Object> formData) {
        if (formData.isEmpty()) {
            throw new IllegalArgumentException("Parameter value is required");
        }
        String columns = formData.keySet().stream().map(i -> "#{formData." + i + "}").collect(Collectors.toList()).toString();
        return columns.substring(1, columns.length() - 1);
    }

    /**
     * 构建更新set数据
     *
     * @param formData
     * @return
     */
    private String buildSet(Map<String, Object> formData) {
        if (formData.isEmpty()) {
            throw new IllegalArgumentException("The value to be modified cannot be empty");
        }
        String sets = formData.keySet().stream().map(i -> i + "=#{formData." + i + "}").collect(Collectors.toList()).toString();
        return sets.substring(1, sets.length() - 1);
    }

    /**
     * 构建id的where条件
     *
     * @param id
     * @return
     */
    private String buildIdWhere(Integer id) {
        if (id == null || id == 0) {
            throw new IllegalArgumentException("where condition id is null or 0 ");
        }
        return "id = #{id}";
    }

    /**
     * 构建where条件
     *
     * @param conditions
     * @return
     */
    private String buildWhere(Map<String, Object> conditions) {
        if (conditions == null || conditions.size() == 0) {
            throw new IllegalArgumentException("where condition is null");
        }
        String sets = conditions.keySet().stream().map(i -> i + "=#{conditions." + i + "}").collect(Collectors.toList()).toString();
        return sets.substring(1, sets.length() - 1);
    }

    /**
     * 构建where条件
     *
     * @param orders
     * @return
     */
    private String buildOrder(Map<String, Object> orders) {
        if (orders == null || orders.size() == 0) {
            throw new IllegalArgumentException("orders is null");
        }
        String sets = orders.keySet().stream().map(i -> i + "=#{orders." + i + "}").collect(Collectors.toList()).toString();
        return sets.substring(1, sets.length() - 1);
    }
}