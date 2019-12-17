package com.example.es7;

import com.alibaba.fastjson.JSON;
import com.example.es7.assistant.SearchResult;
import com.example.es7.entity.EventOnePageVO;
import com.example.es7.query.EventOnePageQuery;
import com.example.es7.service.EventSearchService;
import com.github.pagehelper.Page;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.SimpleQueryStringBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.metrics.CardinalityAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.ParsedCardinality;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.collapse.CollapseBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Es7ApplicationTests {

    @Autowired
    private EventSearchService eventSearchService;

    @Autowired
    @Qualifier("esClient")
    private RestHighLevelClient client;

    @Test
    public void testSearchOnePage() {
        EventOnePageQuery pageQuery = new EventOnePageQuery();
        pageQuery.setKey("ALPHA");

//		List<Object> products = new ArrayList<>();
//        products.add("Affinity 13M");
//        pageQuery.setProducts(products);

//		List<Object> suppliers = new ArrayList<>();
//        suppliers.add("ALPHA");
//        pageQuery.setSuppliers(suppliers);

        pageQuery.buildEsConditions();

        Page<EventOnePageVO> onePageResult = eventSearchService.searchOnePageByPage(pageQuery);
        System.out.println(onePageResult);
    }

    @Test
    public void test01() throws IOException {
        // 设置查询的索引
        SearchRequest searchRequest = new SearchRequest("event_one_page");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();

        // BoolQueryBuilder使用总结
        // 1、不设置条件时，默认会查询全部
        BoolQueryBuilder boolBuilder = QueryBuilders.boolQuery();
        // boolBuilder.must(QueryBuilders.matchQuery("category", "Antenna")); // 正确的写法
        // boolBuilder.filter(QueryBuilders.termsQuery("category", new Object[]{"Antenna"})); // 错误的写法
        // boolBuilder.must(QueryBuilders.termsQuery("category", "Antenna")); // 错误的写法
        //sourceBuilder.query(boolBuilder);

        // 创建in查询builder
        BoolQueryBuilder inBuilder = QueryBuilders.boolQuery();
        //放入in后面的参数（相当于 select ... where column in (1,2,3)）
        inBuilder.should(QueryBuilders.matchQuery("category", "Antenna"));
        inBuilder.should(QueryBuilders.matchQuery("category", "Battery>Cell"));
        sourceBuilder.query(inBuilder);

        // 创建in查询builder
        BoolQueryBuilder inBuilder2 = QueryBuilders.boolQuery();
        //放入in后面的参数（相当于 select ... where column in (1,2,3)）
        inBuilder2.should(QueryBuilders.matchQuery("supplier", "AKM"));
        sourceBuilder.query(inBuilder2);

        // 分页查询
        //sourceBuilder.from(0); // 可以不设置，也会查询到数据
        //sourceBuilder.size(100); // 获取记录数，默认10

        //query
        // SimpleQueryStringBuilder queryBuilder = QueryBuilders.simpleQueryStringQuery("AKM"); // 只写AK时查询不到数据
        //SimpleQueryStringBuilder queryBuilder = QueryBuilders.simpleQueryStringQuery("liyq13@lenovo.com"); //
        // sourceBuilder.query(queryBuilder);
        // sourceBuilder.query(queryBuilder);

        // SearchReqest和SearchSourceBuilder关联
        searchRequest.source(sourceBuilder);

        SearchResult<String> result = searchForSource(searchRequest);
        printResult(result);

        System.out.println();
    }

    // 测试 f1 in(v1, v2) and f2 in(v3, v4) 成功
    @Test
    public void test02() throws IOException {
        // 设置查询的索引
        SearchRequest searchRequest = new SearchRequest("event_one_page");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();

        // 一、in查询
        // 1、创建最外层的builder
        BoolQueryBuilder boolBuilder = QueryBuilders.boolQuery();

        // 2、创建内层in查询的builder
        BoolQueryBuilder inBuilder = QueryBuilders.boolQuery();
        //放入in后面的参数（相当于 select ... where column in (1,2,3)）
//        inBuilder.should(QueryBuilders.matchQuery("supplier", "Acbel")); //success
//        inBuilder.should(QueryBuilders.matchQuery("supplier", "ALPHA")); //success
        inBuilder.should(QueryBuilders.matchQuery("product", "Affinity 13M"));
        inBuilder.should(QueryBuilders.matchQuery("product", "Basil,Bounce"));
        boolBuilder.must(inBuilder);

        // 3、创建内层in查询的builder
        //BoolQueryBuilder inBuilder2 = QueryBuilders.boolQuery();
        //放入in后面的参数（相当于 select ... where column in (1,2,3)）
        //inBuilder2.should(QueryBuilders.matchQuery("supplier", "AKM"));
        //inBuilder2.should(QueryBuilders.matchQuery("supplier", "AKM"));
        // boolBuilder.must(inBuilder2);

        // 二、like查询
        //SimpleQueryStringBuilder queryBuilder = QueryBuilders.simpleQueryStringQuery("AKM"); // 只写AK时查询到数据了
        SimpleQueryStringBuilder queryBuilder = QueryBuilders.simpleQueryStringQuery("Affinity 13M"); // 只写AK时查询到数据了
        boolBuilder.must(queryBuilder); // 正确

        //sourceBuilder.query(queryBuilder);

        String field = "id";
        //collapse
        CollapseBuilder collapseBuilder = new CollapseBuilder(field);
        sourceBuilder.collapse(collapseBuilder);
        //aggs
        CardinalityAggregationBuilder cardinalityAggregationBuilder = AggregationBuilders.cardinality("count").field(field);
        sourceBuilder.aggregation(cardinalityAggregationBuilder);

        // 最外层的boolBuilder和sourceBuilder关联
        sourceBuilder.query(boolBuilder);

        // SearchReqest和SearchSourceBuilder关联
        searchRequest.source(sourceBuilder);

        SearchResult<String> result = searchForSource(searchRequest);
        printResult(result);

        System.out.println();
    }

    @Test
    public void onePageTest() throws IOException {
        EventOnePageQuery pageQuery = new EventOnePageQuery();
        pageQuery.setKey("Affinity 13M");

        List<Object> products = new ArrayList<>();
        products.add("Affinity 13M");
        products.add("Basil,Bounce");

        pageQuery.setProducts(products);
        pageQuery.buildEsConditions();

        Page<EventOnePageVO> onePageResult = eventSearchService.searchOnePageByPage(pageQuery);

        System.out.println(onePageResult);
    }

    @Test
    public void ppapTest() throws IOException {
        EventOnePageQuery pageQuery = new EventOnePageQuery();
        pageQuery.setKey("Affinity 13M");

        List<Object> products = new ArrayList<>();
        products.add("Affinity 13M");
        products.add("Basil,Bounce");

        pageQuery.setProducts(products);
        pageQuery.buildEsConditions();

        Page<EventOnePageVO> onePageResult = eventSearchService.searchOnePageByPage(pageQuery);

        System.out.println(onePageResult);
    }

    /**
     * es查询操作
     *
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
        }
        return result;
    }

    /**
     * 搜索
     *
     * @param index
     * @param type
     * @param name
     * @throws IOException
     */
    public void search(String index, String type, String name) throws IOException {
        BoolQueryBuilder boolBuilder = QueryBuilders.boolQuery();
        boolBuilder.must(QueryBuilders.matchQuery("name", name)); // 这里可以根据字段进行搜索，must表示符合条件的，相反的mustnot表示不符合条件的
        // boolBuilder.must(QueryBuilders.matchQuery("id", tests.getId().toString()));
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(boolBuilder);
        sourceBuilder.from(0);
        sourceBuilder.size(100); // 获取记录数，默认10
        sourceBuilder.fetchSource(new String[]{"id", "name"}, new String[]{}); // 第一个是获取字段，第二个是过滤的字段，默认获取全部

        SearchRequest searchRequest = new SearchRequest(index);
        searchRequest.types(type);
        searchRequest.source(sourceBuilder);

        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);

        System.out.println("search: " + JSON.toJSONString(response));
        SearchHits hits = response.getHits();
        SearchHit[] searchHits = hits.getHits();
        for (SearchHit hit : searchHits) {
            System.out.println("search -> " + hit.getSourceAsString());
        }
    }

    @Test
    public void test03() {
        boolean isVerify = false;
        //data permission
        boolean isExists = true;
        if (!(isExists || isVerify)) {
            System.out.println("aaa");
        } else {
            System.out.println("bbb");
        }
    }

    // 打印查询结果
    private void printResult(SearchResult<String> result) {
        List<String> reList = result.getResult();
        for (String s : reList) {
            System.out.println(s);
        }
    }

}
