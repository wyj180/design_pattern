package com.example.mianshi01.base02;

import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Set不安全问题
 */
public class SetNotSafeDemo {

    public static void main(String[] args) {
        // Set<String> set = new HashSet<>(); // 共享资源； 多线程下会出现异常 ConcurrentModificationException
        //Set<String> set = Collections.synchronizedSet(new HashSet<>()); // 解决办法一：使用synchronized版本的HashSet
        Set<String> set = new CopyOnWriteArraySet<>(); // 解决办法二：使用CopyOnWriteArraySet

        // 三个线程，每个线程添加一个值
        for (int i = 0; i <= 30; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }
    }

}
