package com.example.demo.dongtai;

import com.example.demo.entity.EventFormSQLParam;
import org.apache.ibatis.jdbc.SQL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MybatisSQLTemplate {

    /**
     * 插入数据
     *
     * @param param
     * @return
     */
    public String insert(EventFormSQLParam param) {
        Map<String, Object> formData = param.getFormData();
        return new SQL()
                .INSERT_INTO(param.getTableName())
                .VALUES(buildFiled(formData), buildValue(formData))
                .toString();
    }

    /**
     * 更新数据
     *
     * @param param
     * @return
     */
    public String updateById(EventFormSQLParam param) {
        return new SQL()
                .UPDATE(param.getTableName())
                .SET(buildSet(param.getFormData()))
                .WHERE(buildIdWhere(param.getId()))
                .toString();
    }

    /**
     * 查询单条数据
     *
     * @param param
     * @return
     */
    public String selectOne(EventFormSQLParam param) {
        return selectList(param);
    }

    /**
     * 查询多条数据
     *
     * @param param
     * @return
     */
    public String selectList(EventFormSQLParam param) {
        return new SQL() {{
            SELECT(buildSelectFiled(param.getFormData()));
            FROM(param.getTableName());
            if (param.getConditions() != null) {
                WHERE(buildWhere(param.getConditions()));
            }
            if (param.getId() != null) {
                WHERE(buildIdWhere(param.getId()));
            }
            if (param.getOrders() != null) {
                ORDER_BY(buildOrder(param.getOrders()));
            }
            if (param.getIns() != null) {
                WHERE(buildIns(param.getIns()));
            }
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
        if (formData == null || formData.isEmpty()) {
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
        if (formData == null || formData.isEmpty()) {
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
        if (formData == null || formData.isEmpty()) {
            throw new IllegalArgumentException("The value to be modified cannot be empty");
        }
        String sets = formData.keySet().stream().map(i -> i + "=#{formData." + i + "}").collect(Collectors.toList()).toString();
        return sets.substring(1, sets.length() - 1);
    }

    /**
     * 构建in('value1', 'value2')
     * 使用方式：结合WHERE一起使用
     * 示例：WHERE(buildIns(param.getIns()));
     *
     * @param conditions
     * @return
     */
    private static String buildIns(Map<String, List<Object>> conditions) {
        if (conditions == null || conditions.isEmpty()) {
            throw new IllegalArgumentException("The value to be modified cannot be empty");
        }
        String result = " 1 = 1";
        for (Map.Entry<String, List<Object>> entry : conditions.entrySet()) {
            if (entry.getValue() == null || entry.getValue().isEmpty()) {
                continue;
            }
            result += " and " + entry.getKey() + " in (";
            String inValue = "";
            List<Object> values = entry.getValue();
            for (int i = 0; i < values.size(); i++) {
                inValue += "'" + values.get(i) + "'";
                if (i != values.size() - 1) {
                    inValue += ",";
                }
            }
            result += inValue + ")";
        }
        return result;
    }

    public static void main(String[] args) {
        Map<String, List<Object>> conditions = new HashMap<>();
        List<Object> ids = null;
//        ids.add(1);
//        ids.add(2);
//        ids.add(3);
        conditions.put("id", ids);
        List<Object> names = new ArrayList<>();
        names.add("admin");
        names.add("zs");
        names.add("lisi");
        conditions.put("name", names);

        String s = buildIns(conditions);
        System.out.println(s);
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
            return null;
        }
        String sets = conditions.keySet().stream().map(i -> i + "=#{conditions." + i + "}").collect(Collectors.toList()).toString();
        String sql = sets.substring(1, sets.length() - 1).replace(",", " and ");
        return sql;
    }

    /**
     * 构建where条件
     *
     * @param orders
     * @return
     */
    private String buildOrder(Map<String, String> orders) {
        if (orders == null || orders.size() == 0) {
            return null;
        }
        String sets = orders.keySet().stream().map(key -> key + " " + orders.get(key)).collect(Collectors.toList()).toString();
        return sets.substring(1, sets.length() - 1);
    }
}