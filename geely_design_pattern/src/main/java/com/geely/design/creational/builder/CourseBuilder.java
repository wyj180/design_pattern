package com.geely.design.creational.builder;

/**
 * Created by geely
 */
public abstract class CourseBuilder {

    // 设置课程属性的方法
    public abstract void buildCourseName(String courseName);

    public abstract void buildCoursePPT(String coursePPT);

    public abstract void buildCourseVideo(String courseVideo);

    public abstract void buildCourseArticle(String courseArticle);

    public abstract void buildCourseQA(String courseQA);

    // 获取课程的方法
    public abstract Course makeCourse();
}
