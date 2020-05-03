package com.study.service;

import com.mongodb.QueryOperators;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.BasicUpdate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.study.utils.Constants.MongoKeys.*;

// MongoTemplate中Document查询的使用
@Service
public class MongoDBQueryBuilderService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void updateArr() {
        // updateArray();
        updateArrayPf();
    }

    /**
     * 更新数组_测试用
     *
     * @return
     */
    private void updateArray() {
        // 设置查询条件
        List<Integer> assignees = Arrays.asList(1, 2, 3, 6);

        // 查询条件，相当于where
        Query dataRowQuery = new BasicQuery($("dataname", "wyj_test"));

        // 更新内容
        Document businessData = new Document();
        businessData.append("assignees.0.name", assignees);
        BasicUpdate updateAction = new BasicUpdate($(KEY_$set, businessData));

        // 更新的collection
        String collectionName = "aaa";
        mongoTemplate.updateFirst(dataRowQuery, updateAction, collectionName);
    }

    /**
     * 更新数组_更新流程数据用
     *
     * @return
     */
    private void updateArrayPf() {
        // 设置查询条件
        List<Integer> assignees = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> roles = Arrays.asList(1,2,3);
        List<String> orgs = Arrays.asList("code1", "code2");

        // 查询条件，相当于where
        Query dataRowQuery = new BasicQuery($("app.appInstanceId", 100));

        // 更新内容
        Document updateContent = new Document();
        updateContent.append("open.0.assignees", assignees);
        updateContent.append("open.0.roles", roles);
        updateContent.append("open.0.orgs", orgs);
        BasicUpdate updateAction = new BasicUpdate($(KEY_$set, updateContent));

        // 更新的collection
        String collectionName = "app_task_all";
        mongoTemplate.updateFirst(dataRowQuery, updateAction, collectionName);
    }

    public Object testExists() {
//        Query query = getExistsQuery();
        Query query = getExistsQuery2();
        String collectionName = "app_task_all";
        ArrayList<Document> list = new ArrayList<>();
        mongoTemplate.executeQuery(query, collectionName, list::add);
        return list;
    }

    public Object getMongoDBTest01() {
        // Query query = getSimpleQuery();
        Query query = getOrListQuery();

        String collectionName = "app2";
        ArrayList<Document> list = new ArrayList<>();
        mongoTemplate.executeQuery(query, collectionName, list::add);

        return list;
    }

    private Query getOrListQuery() {
        // 设置查询条件
        Document conditon1 = new Document();//条件1
        conditon1.put("_open.assignees", 2.0);
        Document conditon2 = new Document();//条件2
        conditon2.put("_open.roles", 44);
        Document queryObj = new Document();
        queryObj.put("$or", Arrays.asList(conditon1, conditon2));

        // 设置查询的列 (默认查询所有的列)
        Document fieldObj = new Document();
        fieldObj.put("days", 1);
        fieldObj.put("reason", 1);
        // 默认返回的列： id, days, reason
        return new BasicQuery(queryObj, fieldObj);
    }

    private Query getExistsQuery() {
        // 设置查询条件
        Document conditon1 = new Document();//条件1
        conditon1.put("app.appId", 6);
        // conditon1.put("$exists", "open.issue"); // $exists错误写法一

        // $exists错误使用方式二
//        Document existsConditon = new Document();
//        existsConditon.put("open.issue", true);
//        conditon1.put("$exists", existsConditon);

        // 错误写法三
//        conditon1.put("open.issue", QueryOperators.EXISTS);

        // $exists正确写法
        Document existsConditon = new Document();
        existsConditon.put(QueryOperators.EXISTS, true);
        conditon1.put("open.issue", existsConditon);

        return new BasicQuery(conditon1);
    }

    /**
     * 模拟pf模块代码测试
     * @return
     */
    private Query getExistsQuery2() {
        // 设置查询条件
        List<Integer> appIds = Arrays.asList(1, 2, 3, 6);

        Document beforeMatch = $(KEY_app_appId, $(KEY_$in, appIds));

        Document existsConditon = new Document();
        existsConditon.put(QueryOperators.EXISTS, true);
        beforeMatch.put("open.issue", existsConditon);

        return new BasicQuery(beforeMatch);
    }

    private Query getSimpleQuery() {
        // 设置查询条件
        // 查询_open这个数组中的对象的assignees值为1
        Document queryObj = new Document();
        queryObj.put("_open.assignees", 1);

        // 设置查询的列 (默认查询所有的列)
        Document fieldObj = new Document();
        fieldObj.put("days", 1);
        fieldObj.put("reason", 1);
        // 默认返回的列： id, days, reason
        return new BasicQuery(queryObj, fieldObj);
    }

    public static Document $(Object... kvPairs) {
        Document newDoc = new Document();
        if (kvPairs != null && kvPairs.length > 1) {
            for (int i = 0; i < kvPairs.length - 1; i = i + 2) {
                newDoc.put(String.valueOf(kvPairs[i]), kvPairs[i + 1]);
            }
        }
        return newDoc;
    }
}
