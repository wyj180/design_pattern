/*
 * 文件名：ElasticSearchPageQuery.java
 * 版权：Copyright 1984-2019 Lenovo Group. All Rights Reserved.
 * 描述：
 * 修改人：
 * 修改时间：
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */
package com.example.es7.assistant;

import com.example.es7.entity.EsFieldSort;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 功能描述：<code>ElasticSearchPageQuery</code>
 * </p>
 *
 * @author heqiang7
 * @version [1.0.0], 2019/6/10 14:38
 */
@Data
public class ElasticSearchPageQuery {

	private int pageNum = 1;
	private int pageSize = 10;
	private boolean isPage = true;

	/**
	 * 索引
	 */
	private List<String> indices;

	public ElasticSearchPageQuery(){
		indices = new ArrayList<>();
	}

	/**
	 * 查询关键字
	 */
	private String queryKey;

	/**
	 * 字段in条件查询
	 * 示例: field1 in('value1', 'value2') and field2 in('value3', 'value4')
	 */
	private Map<String, Object[]> inConditions;

	/**
	 * 开始时间（根据创建时间gmt_create字段查）
	 */
	private String startTime;

	private List<EsFieldSort> fieldSorts;

	/**
	 * 结束时间（根据创建时间gmt_create字段查）
	 */
	private String endTime;

	public int getFrom(){
		return (pageNum - 1) * pageSize;
	}

	public void addIndex(String index) {
		indices.add(index);
	}

	public void addIndices(String... indices){
		this.indices.addAll(Arrays.stream(indices).collect(Collectors.toList()));
	}

	public String[] getIndices(){
		return indices.stream().toArray(String[]::new);
	}
}
