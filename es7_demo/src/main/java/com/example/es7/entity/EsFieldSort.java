package com.example.es7.entity;

import lombok.Data;
import org.elasticsearch.search.sort.SortOrder;

/**
 * es查询结果排序
 */
@Data
public class EsFieldSort {

    private String fieldName;

    private SortOrder order;
}
