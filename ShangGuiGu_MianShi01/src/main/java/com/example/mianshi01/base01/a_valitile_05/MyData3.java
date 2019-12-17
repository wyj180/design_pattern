package com.example.mianshi01.base01.a_valitile_05;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用原子类保证原子性
 */
public class MyData3 {

    /**
     * 共享变量
     */
    AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * 修改共享变量
     */
    public void addPlusPlus() {
        atomicInteger.getAndIncrement();
    }

}
