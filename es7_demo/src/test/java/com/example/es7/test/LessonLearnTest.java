package com.example.es7.test;

import com.example.es7.Es7ApplicationTests;
import com.example.es7.constants.EventElasticSearchConstant;
import com.example.es7.query.EventLessonLearnQuery;
import com.example.es7.service.EventSearchService;
import com.github.pagehelper.Page;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LessonLearnTest extends Es7ApplicationTests {

    @Autowired
    private EventSearchService eventSearchService;

    @Autowired
    private RestHighLevelClient client;

    // 使用流程状态范围查询 31条成功
    @Test
    public void test01() {
        EventLessonLearnQuery query = new EventLessonLearnQuery();
        List<Object> llTypes = new ArrayList<>();
        llTypes.add("EWG");
        llTypes.add("Project");
        query.setLlTypes(llTypes);

//        query.setLlTypes(llTypes);
//        query.setStartTime("2019-12-10 18:55:56");
//        query.setEndTime("2019-12-11 14:51:48");

        Page<Map<String, Object>> result = eventSearchService.compositeSearchMapByPage(query.buildEsConditions(), EventElasticSearchConstant.INDEX_EVENT_IESSON_LEARN);
        System.out.println(result);
    }

    // 使用时间范围查询 测试中
    @Test
    public void test02() {
        EventLessonLearnQuery query = new EventLessonLearnQuery();
        List<Object> llTypes = new ArrayList<>();
        llTypes.add("EWG");
        llTypes.add("Project");
        query.setLlTypes(llTypes);

        // 时间范围
        query.setStartTime("2019-12-10 00:00:00");
        query.setEndTime("2019-12-11 14:51:48");

        query.setKey("Project");

        Page<Map<String, Object>> result = eventSearchService.compositeSearchMapByPage(query.buildEsConditions(), EventElasticSearchConstant.INDEX_EVENT_IESSON_LEARN);
        List<Map<String, Object>> result1 = result.getResult();
        for (Map<String, Object> stringObjectMap : result1) {
            System.out.println("id = " + stringObjectMap.get("id") + ", no = " + stringObjectMap.get("no"));
        }
    }

}
