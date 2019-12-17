package com.geely.design.creational.abstractfactory;

/**
 * Created by geely
 */
// Python课程工厂，可以得到课程和笔记
public class PythonCourseFactory implements CourseFactory {
    @Override
    public Video getVideo() {
        return new PythonVideo();
    }

    @Override
    public Article getArticle() {
        return new PythonArticle();
    }
}
