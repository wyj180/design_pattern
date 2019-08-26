package com.geely.design.principle.singleresponsibility;

/**
 * Created by geely
 */
// 单一职责原则在接口中的使用
// 根据接口中的方法类型提取两个方法成为一个单独的接口
public interface ICourseContent {
    String getCourseName();
    byte[] getCourseVideo();
}
