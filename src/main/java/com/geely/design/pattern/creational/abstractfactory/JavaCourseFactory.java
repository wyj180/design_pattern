package com.geely.design.pattern.creational.abstractfactory;

/**
 * Created by geely
 */
// Java课程工厂，可以得到课程和笔记
public class JavaCourseFactory implements CourseFactory {
    @Override
    public Video getVideo() {
        return new JavaVideo();
    }

    @Override
    public Article getArticle() {
        return new JavaArticle();
    }
}
