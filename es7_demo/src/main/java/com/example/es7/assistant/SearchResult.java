/*
 * 文件名：SearchResult.java
 * 版权：Copyright 1984-2019 Lenovo Group. All Rights Reserved.
 * 描述：
 * 修改人：
 * 修改时间：
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */
package com.example.es7.assistant;

import lombok.Getter;
import lombok.Setter;
import org.elasticsearch.search.aggregations.metrics.ParsedCardinality;

import java.util.List;

/**
 * 功能描述：<code>SearchResult</code>
 * </p>
 *
 * @author heqiang7
 * @version [1.0.0], 2019/6/11 14:06
 */
@Getter
@Setter
public class SearchResult<T> {

    public SearchResult() {
    }

    public SearchResult(List<T> result) {
        this.result = result;
    }

    private long total;

    private List<T> result;

    private List<ParsedCardinality> aggregations;

    public void add(T value) {
        result.add(value);
    }
}
