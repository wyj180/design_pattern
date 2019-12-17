package com.geely.design.principle.singleresponsibility;

/**
 * Created by geely
 */
// 单一职责原则在接口中的使用
// 四个接口都放在一起
public interface ICourse {
    String getCourseName();

    byte[] getCourseVideo();

    void studyCourse();

    void refundCourse();
}
