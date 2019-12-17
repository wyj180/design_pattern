package com.study.concurrent.pool;

class SuperCla {
    public String test01() {
        System.out.println("父类...");
        return "aaa";
    }
}

public class TestSubClass extends SuperCla {

    public String test01() {
        System.out.println("子类...");
        return null;
    }

    public static void main(String[] args) {
        TestSubClass test = new TestSubClass();
        test.test01();
    }

}
