/*
 * 文件名：ElasticSearchManager.java
 * 版权：Copyright 1984-2019 Lenovo Group. All Rights Reserved.
 * 描述：
 * 修改人：
 * 修改时间：
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */
package com.example.es7.service;

import com.example.es7.assistant.ElasticSearchDeleteRequest;
import com.example.es7.assistant.ElasticSearchPageQuery;
import com.example.es7.assistant.SearchResult;
import org.elasticsearch.index.reindex.BulkByScrollResponse;

import java.io.IOException;
import java.util.List;


/**
 * 功能描述：<code>ElasticSearchManager</code>
 * </p>
 *
 * @author heqiang7
 * @version [1.0.0], 2019/6/10 10:12
 */
public interface ElasticSearchManager {

	/**
	 * Simple Search
	 * @param pageQuery
	 * @return
	 */
	SearchResult<String> simpleSearchByFullText(ElasticSearchPageQuery pageQuery);

	/**
	 * @param pageQuery
	 * @param groupByField
	 * @return
	 */
	SearchResult<String> simpleAggregationSearchByFullText(ElasticSearchPageQuery pageQuery, String groupByField);

	/**
	 *
	 * @param pageQuery
	 * @param groupByField
	 * @return
	 */
	SearchResult<String> compositeAggregationSearch(ElasticSearchPageQuery pageQuery, String groupByField);

	/**
	 * @param pageQuery
	 * @param groupByField
	 * @param clazz
	 * @return
	 * @param <T>
	 */
	<T> SearchResult<T> simpleAggregationSearchByFullText(ElasticSearchPageQuery pageQuery, String groupByField,
                                                          Class<T> clazz);

	/**
	 * Composite Search
	 *
	 * @param pageQuery
	 * @param groupByField
	 * @param clazz
	 * @param <T>
	 * @return
	 */
	<T> SearchResult<T> compositeSearchByFullText(ElasticSearchPageQuery pageQuery, String groupByField, Class<T> clazz);

	/**
	 * Simple Search
	 * @param pageQuery
	 * @param clazz
	 * @param <T>
	 * @return
	 */
	<T> SearchResult<T> simpleSearchByFullText(ElasticSearchPageQuery pageQuery, Class<T> clazz);

	/**
	 * 查询所有满足条件的数据
	 *
	 * @param pageQuery
	 * @param clazz
	 * @param <T>
	 * @return
	 */
	<T> List<T> searchAllByFullText(ElasticSearchPageQuery pageQuery, Class<T> clazz);

	/**
	 * @param deleteRequest
	 * @return
	 * @throws IOException
	 */
	BulkByScrollResponse deleteByMatchQuery(ElasticSearchDeleteRequest deleteRequest) throws IOException;

}

