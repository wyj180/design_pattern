package com.example.mianshi01.base02;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/**
 * 集合类不安全问题
 */
public class ContainerNotSafeDemo {

    public static void main1(String[] args) {
        List<String> list = new ArrayList<>(); // 共享资源

        // 三个线程，每个线程添加一个值
        for (int i = 0; i <= 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println(list);
        // java.util.ConcurrentModificationException  并发修改异常
    }

    // 解决办法一：使用Vector类
    public static void main2(String[] args) {
        Vector<String> list = new Vector<>(); // 共享资源

        // 三个线程，每个线程添加一个值
        for (int i = 0; i <= 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println(list);
    }

    // 解决办法二：Collections.synchronizedList(new ArrayList<>());
    public static void main3(String[] args) {
        List<String> list = Collections.synchronizedList(new ArrayList<>());

        // 三个线程，每个线程添加一个值
        for (int i = 0; i <= 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println(list);
    }

    // 解决办法三：使用CopyOnWriteArrayList这个类
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

        // 三个线程，每个线程添加一个值
        for (int i = 0; i <= 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println(list);
    }

}
