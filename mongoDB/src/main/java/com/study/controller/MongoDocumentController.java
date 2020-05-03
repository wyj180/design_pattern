package com.study.controller;

import com.study.service.MongoDBQueryBuilderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MongoDocumentController {

    @Autowired
    private MongoDBQueryBuilderService mongoDBService;

    private int count = 0;

    @RequestMapping("/getFromMongoDBA")
    public String getLessonSampleFromMongo() {
        Object mongoDBTest01 = mongoDBService.getMongoDBTest01();
        System.out.println(mongoDBTest01);
        return "success";
    }

}
