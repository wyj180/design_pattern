package com.study.concurrent.pool;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test01 {

    @Test
    public void test01() {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        ExecutorService executorService1 = Executors.newSingleThreadExecutor();

    }

    @Test
    public void test02() {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Executors.newScheduledThreadPool(10);
    }

    @Test
    public void test03() {
        System.out.println(Integer.MAX_VALUE); // 2 147 483 647
        System.out.println(2);
        System.out.println(Integer.MIN_VALUE);
    }

}
