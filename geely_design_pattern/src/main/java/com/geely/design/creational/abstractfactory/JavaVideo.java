package com.geely.design.creational.abstractfactory;

/**
 * Created by geely
 */
// java视频实现类
public class JavaVideo extends Video {
    @Override
    public void produce() {
        System.out.println("录制Java课程视频");
    }
}
