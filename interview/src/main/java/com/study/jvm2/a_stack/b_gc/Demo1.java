package com.study.jvm2.a_stack.b_gc;

public class Demo1 {

    private Object next;

    private byte[] bytes;

    public Demo1() {
        // 创建20M的大对象
        bytes = new byte[1024 * 1024 * 20];
    }

    public static void main(String[] args) {
        Demo1 a = new Demo1();
        Demo1 b = new Demo1();
        a.next = b;
        b.next = a;
        a = null;
        b = null;

        System.gc();
        // 打印GG情况 -verbose:gc -XX:+PrintGCDetails
        System.out.println("end...");
    }

}
