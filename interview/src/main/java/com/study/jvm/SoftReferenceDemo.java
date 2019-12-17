package com.study.jvm;

import java.lang.ref.SoftReference;

public class SoftReferenceDemo {

    // 软引用，内存够用的情况
    public static void softRef_Memory_Enough() {
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(softReference.get()); // 获取软引用中的对象，用get()方法

        o1 = null;
        System.gc();

        System.out.println(o1);
        System.out.println(softReference.get());
    }

    // JVM配置，故意产生大对象并配置小内存，让内存不够用产生OOM,看软引用的回收情况
    // -Xms5m -Xmx5m -XX:+PrintGCDetails
    public static void softRef_Memory_NotEnough() {
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(softReference.get()); // 获取软引用中的对象，用get()方法

       // o1 = null;

        try {
            byte[] bytes = new byte[1 * 1024 * 1024]; // 30M大对象
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(o1);
            System.out.println(softReference.get());
        }
    }

    public static void main(String[] args) {
       // softRef_Memory_Enough();

        softRef_Memory_NotEnough();
    }
}