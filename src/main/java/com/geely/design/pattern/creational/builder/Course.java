package com.geely.design.pattern.creational.builder;

import lombok.Data;

@Data
public class Course {
    private String courseName;
    private String coursePPT;
    private String courseVideo;
    private String courseArticle;
    //question & answer
    private String courseQA;
}
