/*
 * 文件名：ElasticSearchServiceImpl.java
 * 版权：Copyright 1984-2019 Lenovo Group. All Rights Reserved.
 * 描述：
 * 修改人：
 * 修改时间：
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */
package com.example.es7.service.impl;

import com.example.es7.assistant.ElasticSearchDeleteRequest;
import com.example.es7.assistant.ElasticSearchPageQuery;
import com.example.es7.assistant.SearchResult;
import com.example.es7.entity.EventOnePageVO;
import com.example.es7.query.EventListPageQuery;
import com.example.es7.query.EventOnePageQuery;
import com.example.es7.service.ElasticSearchManager;
import com.example.es7.service.EventSearchService;
import com.github.pagehelper.Page;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.search.aggregations.metrics.ParsedCardinality;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import static com.example.es7.constants.EventElasticSearchConstant.*;

/**
 * 功能描述：<code>ElasticSearchServiceImpl</code>
 * </p>
 *
 * @author heqiang7
 * @version [1.0.0], 2019/6/10 18:22
 */
@Service
@Slf4j
public class ElasticSearchServiceImpl implements EventSearchService {

    @Autowired
    private ElasticSearchManager elasticSearchManager;


    @Override
    public boolean deleteSifById(BigInteger id) {
        ElasticSearchDeleteRequest request = ElasticSearchDeleteRequest.of(INDEX_EVENT_SIF);
        request.setField("id", id);
        return deleteDoc(request);
    }

    @Override
    public boolean deleteOnePageById(BigInteger id) {
        ElasticSearchDeleteRequest request = ElasticSearchDeleteRequest.of(INDEX_EVENT_ONE_PAGE);
        request.setField("id", id);
        return deleteDoc(request);
    }

    private boolean deleteDoc(ElasticSearchDeleteRequest request) {
        try {
            BulkByScrollResponse response = elasticSearchManager.deleteByMatchQuery(request);
            log.info("delete sif,total process num=[{}],deleted num=[{}].", response.getTotal(), response.getDeleted());
        } catch (IOException e) {
            log.error("delete sif error from es", e);
            return false;
        }
        return true;
    }

    @Override
    public Page<EventOnePageVO> searchOnePageByPage(EventOnePageQuery pageQuery) {
        ElasticSearchPageQuery searchPageQuery = convertPageQuery(pageQuery,
                INDEX_EVENT_ONE_PAGE);
        SearchResult<EventOnePageVO> searchResult = elasticSearchManager
                .compositeSearchByFullText(searchPageQuery, "id", EventOnePageVO.class);

        return aggregationWarpToPage(searchPageQuery, searchResult);
    }

    @Override
    public List<EventOnePageVO> searchOnePageId(EventOnePageQuery pageQuery) {
        ElasticSearchPageQuery searchPageQuery = convertPageQuery(pageQuery,
                INDEX_EVENT_ONE_PAGE);
        SearchResult<EventOnePageVO> searchResult = elasticSearchManager
                .simpleAggregationSearchByFullText(searchPageQuery, "id", EventOnePageVO.class);
        return searchResult.getResult();
    }

    private ElasticSearchPageQuery convertPageQuery(EventListPageQuery listPageQuery) {
        ElasticSearchPageQuery searchPageQuery = new ElasticSearchPageQuery();
        searchPageQuery.setQueryKey(listPageQuery.getKey());
        searchPageQuery.setInConditions(listPageQuery.getInConditions());
        searchPageQuery.setPageNum(listPageQuery.getPageNum());
        searchPageQuery.setPageSize(listPageQuery.getPageSize());
        return searchPageQuery;
    }

    private ElasticSearchPageQuery convertPageQuery(EventListPageQuery listPageQuery, String... index) {
        ElasticSearchPageQuery searchPageQuery = convertPageQuery(listPageQuery);
        searchPageQuery.addIndices(index);
        return searchPageQuery;
    }

    private <T> Page<T> warpToPage(ElasticSearchPageQuery pageQuery, long total, List<T> result) {
        Page<T> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        page.setTotal(total);
        page.addAll(result);
        return page;
    }

    private <T> Page<T> warpToPage(ElasticSearchPageQuery pageQuery, SearchResult<T> searchResult) {
        Page<T> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        page.setTotal(searchResult.getTotal());
        page.addAll(searchResult.getResult());
        return page;
    }

    private <T> Page<T> aggregationWarpToPage(ElasticSearchPageQuery pageQuery, SearchResult<T> searchResult) {
        Page<T> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());

        List<ParsedCardinality> aggregations = searchResult.getAggregations();
        if (!CollectionUtils.isEmpty(aggregations)) {
            Optional<ParsedCardinality> optional = aggregations.stream()
                    .filter(aggregation -> StringUtils.equals("count", aggregation.getName())).findFirst();
            page.setTotal(optional.orElse(new ParsedCardinality()).getValue());
        }
        page.addAll(searchResult.getResult());
        return page;
    }

    private <T> Page<T> warpToPage(ElasticSearchPageQuery searchPageQuery, Class<T> clazz) {
        SearchResult<T> searchResult = elasticSearchManager
                .simpleSearchByFullText(searchPageQuery, clazz);
        return warpToPage(searchPageQuery, searchResult);
    }

}
