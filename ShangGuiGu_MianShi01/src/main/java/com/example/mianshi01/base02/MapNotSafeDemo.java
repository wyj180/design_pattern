package com.example.mianshi01.base02;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Set不安全问题
 */
public class MapNotSafeDemo {

    public static void main(String[] args) {
        // Map<String, Object> map = new HashMap<>(); // 共享资源； 多线程下会出现异常 ConcurrentModificationException
        // Map<String, Object> map = Collections.synchronizedMap(new HashMap<>()); // 解决办法一：使用synchronized版本的Map
        //Map<String, Object> map = new Hashtable<>(); // 解决办法二：使用Hashtable，底层也是使用的synchronized
        Map<String, Object> map = new ConcurrentHashMap<>(); // 解决办法三：使用ConcurrentHashMap

        // 三个线程，每个线程添加一个值
        for (int i = 0; i <= 30; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 8));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }
    }

}
