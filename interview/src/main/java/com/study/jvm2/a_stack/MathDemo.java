package com.study.jvm2.a_stack;

public class MathDemo {

    public void add() {
        int a = 100;
        int b = 200;
        int c = a * b;
    }

    public static void main(String[] args) {
        MathDemo mathDemo = new MathDemo();
        mathDemo.add();
    }
}
