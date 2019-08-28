package com.geely.design.pattern.creational.abstractfactory;

/**
 * Created by geely
 */
// Python视频实现类
public class PythonVideo extends Video {
    @Override
    public void produce() {
        System.out.println("录制Python课程视频");
    }
}
