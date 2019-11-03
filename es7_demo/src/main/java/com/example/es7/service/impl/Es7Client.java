package com.example.es7.service.impl;

import com.example.es7.assistant.ElasticSearchDeleteRequest;
import com.example.es7.assistant.ElasticSearchPageQuery;
import com.example.es7.assistant.SearchResult;
import com.example.es7.constants.EventElasticSearchConstant;
import com.example.es7.service.ElasticSearchManager;
import com.example.es7.utils.JsonUtils;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.SimpleQueryStringBuilder;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.DeleteByQueryRequest;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.metrics.CardinalityAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.ParsedCardinality;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.collapse.CollapseBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 功能描述：<code>Es7Client</code>
 * </p>
 *
 * @author heqiang7
 * @version [1.0.0], 2019/6/10 10:23
 */
@Component
public class Es7Client implements ElasticSearchManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(Es7Client.class);

    @Autowired
    @Qualifier("esClient")
    private RestHighLevelClient client;

    @Override
    public SearchResult<String> simpleSearchByFullText(ElasticSearchPageQuery pageQuery) {
        SearchRequest searchRequest = new SearchRequest(pageQuery.getIndices());
        SearchSourceBuilder searchSourceBuilder = buildPageSearchSourceBuilder(pageQuery);
        SimpleQueryStringBuilder queryBuilder = QueryBuilders.simpleQueryStringQuery(pageQuery.getQueryKey());
        searchSourceBuilder.query(queryBuilder);
        searchRequest.source(searchSourceBuilder);

        return searchForSource(searchRequest);
    }

    @Override
    public <T> SearchResult<T> simpleSearchByFullText(ElasticSearchPageQuery pageQuery, Class<T> clazz) {
        SearchResult<String> jsonResult = simpleSearchByFullText(pageQuery);
        List<T> results = JsonUtils.parseJson(jsonResult.getResult(), clazz);

        SearchResult<T> searchResult = new SearchResult<>(results);
        searchResult.setTotal(jsonResult.getTotal());
        return searchResult;
    }

    @Override
    public <T> List<T> searchAllByFullText(ElasticSearchPageQuery pageQuery, Class<T> clazz) {
        List<T> result = new ArrayList<>();
        pageQuery.setPageSize(EventElasticSearchConstant.PAGE_MAX_SIZE);
        int curPage = pageQuery.getPageNum();
        while (true) {
            pageQuery.setPageNum(curPage++);
            SearchResult<T> searchResult = simpleSearchByFullText(pageQuery, clazz);
            List<T> pageList = searchResult.getResult();
            result.addAll(pageList);
            if (pageList.size() < EventElasticSearchConstant.PAGE_MAX_SIZE) {
                break;
            }
        }
        return result;
    }

    @Override
    public SearchResult<String> simpleAggregationSearchByFullText(ElasticSearchPageQuery pageQuery, String groupByField) {
        SearchRequest searchRequest = new SearchRequest(pageQuery.getIndices());
        SearchSourceBuilder searchSourceBuilder = buildPageSearchSourceBuilder(pageQuery);

        //query
        SimpleQueryStringBuilder queryBuilder = QueryBuilders.simpleQueryStringQuery(pageQuery.getQueryKey());
        searchSourceBuilder.query(queryBuilder);

        //collapse
        CollapseBuilder collapseBuilder = new CollapseBuilder(groupByField);
        searchSourceBuilder.collapse(collapseBuilder);

        //aggs
        CardinalityAggregationBuilder cardinalityAggregationBuilder = AggregationBuilders.cardinality("count").field(groupByField);
        searchSourceBuilder.aggregation(cardinalityAggregationBuilder);

        searchRequest.source(searchSourceBuilder);

        return searchForSource(searchRequest);
    }

    @Override
    public SearchResult<String> compositeAggregationSearch(ElasticSearchPageQuery pageQuery, String groupByField) {
        SearchRequest searchRequest = new SearchRequest(pageQuery.getIndices());
        SearchSourceBuilder searchSourceBuilder = buildPageSearchSourceBuilder(pageQuery);

        // 1、创建外层的boolBuilder
        BoolQueryBuilder boolBuilder = QueryBuilders.boolQuery();

        // 设置in(v1, v2)查询条件
        setInQueryCondition(pageQuery, boolBuilder);

        // 3、最外层的boolBuilder和sourceBuilder关联
        searchSourceBuilder.query(boolBuilder);

        //query
        SimpleQueryStringBuilder queryBuilder = QueryBuilders.simpleQueryStringQuery(pageQuery.getQueryKey());
        boolBuilder.must(queryBuilder);

        //collapse
        CollapseBuilder collapseBuilder = new CollapseBuilder(groupByField);
        searchSourceBuilder.collapse(collapseBuilder);

        //aggs
        CardinalityAggregationBuilder cardinalityAggregationBuilder = AggregationBuilders.cardinality("count").field(groupByField);
        searchSourceBuilder.aggregation(cardinalityAggregationBuilder);

        searchRequest.source(searchSourceBuilder);

        return searchForSource(searchRequest);
    }

    /**
     * 设置in查询条件
     *
     * @param pageQuery
     * @param boolBuilder
     */
    private void setInQueryCondition(ElasticSearchPageQuery pageQuery, BoolQueryBuilder boolBuilder) {
        Map<String, Object[]> inConditionMap = pageQuery.getInConditions();
        if (CollectionUtils.isEmpty(inConditionMap)) {
            return;
        }

        for (Map.Entry<String, Object[]> entry : inConditionMap.entrySet()) {
            // 创建内层in查询的builder
            BoolQueryBuilder inBuilder = QueryBuilders.boolQuery();
            for (Object value : entry.getValue()) {
                inBuilder.should(QueryBuilders.matchQuery(entry.getKey(), value));
            }
            // inBuilder和外层的boolBuilder关联
            boolBuilder.must(inBuilder);
        }
    }

    @Override
    public <T> SearchResult<T> compositeSearchByFullText(ElasticSearchPageQuery pageQuery, String groupByField, Class<T> clazz) {
        SearchResult<String> jsonResult = compositeAggregationSearch(pageQuery, groupByField);
        SearchResult<T> searchResult = getSearchResult(clazz, jsonResult);
        return searchResult;
    }

    /**
     * 封装es查询结果
     *
     * @param clazz
     * @param jsonResult
     * @param <T>
     * @return
     */
    private <T> SearchResult<T> getSearchResult(Class<T> clazz, SearchResult<String> jsonResult) {
        List<T> results = JsonUtils.parseJson(jsonResult.getResult(), clazz);

        SearchResult<T> searchResult = new SearchResult<>(results);
        searchResult.setTotal(jsonResult.getTotal());
        searchResult.setAggregations(jsonResult.getAggregations());
        return searchResult;
    }

    @Override
    public BulkByScrollResponse deleteByMatchQuery(ElasticSearchDeleteRequest deleteRequest) throws IOException {
        DeleteByQueryRequest request = new DeleteByQueryRequest(deleteRequest.getIndices());
        //query
        request.setQuery(QueryBuilders.matchQuery(deleteRequest.getField(), deleteRequest.getValue()));
        //refresh
        request.setRefresh(true);

        return client.deleteByQuery(request, RequestOptions.DEFAULT);
    }

    @Override
    public <T> SearchResult<T> simpleAggregationSearchByFullText(ElasticSearchPageQuery pageQuery,
                                                                 String groupByField, Class<T> clazz) {
        SearchResult<String> jsonResult = simpleAggregationSearchByFullText(pageQuery, groupByField);
        List<T> results = JsonUtils.parseJson(jsonResult.getResult(), clazz);

        SearchResult<T> searchResult = new SearchResult<>(results);
        searchResult.setTotal(jsonResult.getTotal());
        searchResult.setAggregations(jsonResult.getAggregations());
        return searchResult;
    }

    /**
     * @param pageQuery
     * @return
     */
    private SearchSourceBuilder buildPageSearchSourceBuilder(ElasticSearchPageQuery pageQuery) {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        if (pageQuery.isPage()) {
            searchSourceBuilder.from(pageQuery.getFrom());
            searchSourceBuilder.size(pageQuery.getPageSize());
        }
        return searchSourceBuilder;
    }

    /**
     * @param searchRequest
     * @return
     */
    private SearchResult<String> searchForSource(SearchRequest searchRequest) {
        SearchResult<String> result = new SearchResult<>(new ArrayList<>());
        try {
            SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
            result.setTotal(response.getHits().getTotalHits().value);
            if (response.getAggregations() != null) {
                result.setAggregations(response.getAggregations().asList().stream().map(aggregation -> (ParsedCardinality) aggregation)
                        .collect(Collectors.toList()));
            }
            Arrays.stream(response.getHits().getHits())
                    .forEach(hit -> result.add(hit.getSourceAsString()));
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("simple search io exception from elasticsearch;", e);
        }
        return result;
    }

}
