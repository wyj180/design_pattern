package com.study.controller;

import com.study.service.MongoDBQueryBuilderService;
import com.study.service.MongoDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class MongoController {

    @Autowired
    private MongoDBService mongoDBService;

    @Autowired
    private MongoDBQueryBuilderService builderService;

    private int count = 0;

    @RequestMapping("/")
    public String index() {
        return "请求成功";
    }

    // mongoDB更新 $set
    @RequestMapping("/testUpdate")
    public String updateArr() {
        builderService.updateArr();
        return "success";
    }

    // 判断是否存在某个字段查询 $exists
    @RequestMapping("/testExists")
    public String testExists() {
        Object testExists = builderService.testExists();
        System.out.println("testExists : " + testExists);
        return "success";
    }

    @RequestMapping("/getFromMongoDB")
    public String getLessonSampleFromMongo() {
        Object mongoDBTest01 = mongoDBService.getMongoDBTest01();
        return "success";
    }

    @RequestMapping("/testJmeter")
    public String testJmeter() {
        synchronized (this.getClass()) {
            count++;
        }
        System.out.println("count = " + count);
        return "success";
    }

    @PostMapping("/uploadFile")
    public String fdfsUploadFile(@RequestParam("file") MultipartFile multipartFile) {
        if (multipartFile.getSize() == 0) {
            return "Please select the file you want to upload";
        }
        System.out.println("上传文件名：" + multipartFile.getOriginalFilename() + ",文件大小: " + multipartFile.getSize());
        return "success";
    }

}
