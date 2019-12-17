package com.example.mianshi01.base01.b_cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS是什么？ ===> compareAndSet
 * 比较并交换
 */
public class CASDemo {

    public static void main(String[] args) {
        // 初始值：5
        AtomicInteger atomicInteger = new AtomicInteger(5);

        System.out.println(atomicInteger.compareAndSet(5, 2019) + "\t 当前值：" + atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 1024) + "\t 当前值：" + atomicInteger.get());
    }
}
