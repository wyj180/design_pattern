package com.study.service;

import com.study.entity.LearnSample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

// MongoTemplate中Query和Criteria的使用
@Service
public class MongoDBService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Object getMongoDBTest01() {
        // 用来构建条件  这里写is和in都可以，in则可以写多个值
        //Criteria criteria = Criteria.where("tasks.roles").is("wangyj");
        Criteria criteria = Criteria.where("tasks.roles").in("wangyj");

        // 用来封装所有条件的对象
        Query query = new Query();
        query.addCriteria(criteria);

        // 查询后的值转为指定类型
        String collectionName = "learn_sample";
        List<LearnSample> learnSamples = mongoTemplate.find(query, LearnSample.class, collectionName);
        System.out.println(learnSamples);

        // 使用Object接收全部字段,Object默认返回LinkedHashMap (成功)
        List<Object> learnSamples2 = mongoTemplate.find(query, Object.class, collectionName);
        System.out.println(learnSamples2);

        // 分页查询 , skip下标从0开始，limit表示每次查询的数据条数,即pageSize
//        query.skip(0);
//        query.limit(3);

        // 排序 (测试成功)
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "created");
        Sort sort = Sort.by(order);
//        query.with(sort);

        List<Object> learnSamples3 = mongoTemplate.find(query, Object.class, collectionName);
        System.out.println(learnSamples3);

        // 分页
//        query.skip(1);
//        query.limit(3);

        //query.with()

        // 使用Pageable分页
        Pageable pageable = PageRequest.of(1, 3, sort);
        query.with(pageable);

        List<Object> learnSamples4 = mongoTemplate.find(query, Object.class, collectionName);
        System.out.println(learnSamples4);

        return learnSamples;
    }
}
