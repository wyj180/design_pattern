package com.geely.design.principle.openclose;

/**
 * Created by geely
 */
public interface ICourse {
    Integer getId(); // 获取课程id

    String getName();// 获取课程名称

    Double getPrice();// 获取课程价格

    // 随着需求的变更，新增的打折价格的方法
    // 如果写在这里的话，那么所有的实现类都要实现这个方法
    // Double getDiscountPrice(); // 获取打折价格
}
