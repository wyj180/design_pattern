package com.geely.design.principle.dependenceinversion;

/**
 * Created by geely
 */
public class Test {

    //v1  需要在geely这个类中写studyJavaCourse()和studyFECourse()方法，每学习一个课程，就会新增一个方法
//    public static void main(String[] args) {
//        Geely geely = new Geely();
//        geely.studyJavaCourse();
//        geely.studyFECourse();
//    }

    //v2  学习课程的方法接收课程参数
//    public static void main(String[] args) {
//        Geely geely = new Geely();
//        geely.studyImoocCourse(new JavaCourse());
//        geely.studyImoocCourse(new FECourse());
//        geely.studyImoocCourse(new PythonCourse());
//    }

    //v3  构造方法传入课程，但是想学习别的课程时，不好设置
//    public static void main(String[] args) {
//        Geely geely = new Geely(new JavaCourse());
//        geely.studyImoocCourse();
//    }

    // v4  提供set方法设置课程
    public static void main(String[] args) {
        Geely geely = new Geely();
        geely.setiCourse(new JavaCourse());
        geely.studyImoocCourse();

        geely.setiCourse(new FECourse());
        geely.studyImoocCourse();
    }
}
