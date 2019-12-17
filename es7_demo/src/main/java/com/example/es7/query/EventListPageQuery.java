/*
 * 文件名：EventListPageQuery.java
 * 版权：Copyright 1984-2019 Lenovo Group. All Rights Reserved.
 * 描述：
 * 修改人：
 * 修改时间：
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */
package com.example.es7.query;

import com.example.es7.entity.EsFieldSort;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * 功能描述：<code>EventListPageQuery</code>
 * </p>
 *
 * @author heqiang7
 * @version [1.0.0], 2019/4/3 15:09
 */

@Data
public class EventListPageQuery extends BasePageQuery {
    private String key;

    /**
     * 用于字段in条件查询
     * 示例: field1 in('value1', 'value2') and field2 in('value3', 'value4')
     */
    protected Map<String, Object[]> inConditions;

    protected String startTime;

    protected String endTime;

    protected List<EsFieldSort> fieldSorts;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    // 构造方法
    public EventListPageQuery() {
        // 由于子类重写了该方法，因此，回去调用子类的改方法
        setQueryCondition();
    }

    public void setQueryCondition() {
        System.out.println("EventListPageQuery...");
    }
}
