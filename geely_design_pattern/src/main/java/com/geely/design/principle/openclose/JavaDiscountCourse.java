package com.geely.design.principle.openclose;

/**
 * Created by geely
 */
// 新增一个类来获取Java课程的打折价格
public class JavaDiscountCourse extends JavaCourse {

    public JavaDiscountCourse(Integer id, String name, Double price) {
        super(id, name, price);
    }

    // 新增一个打折价格的方法
    public Double getDiscountPrice() {
        return super.getPrice() * 0.8;
    }
}
