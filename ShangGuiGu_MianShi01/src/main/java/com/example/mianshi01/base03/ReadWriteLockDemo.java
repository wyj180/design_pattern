package com.example.mianshi01.base03;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 */

class MyCache {

    Map<String, Object> map = new HashMap<>();

    ReadWriteLock rwLock = new ReentrantReadWriteLock();

    public void put(String key, Object value) {
        try {
            rwLock.writeLock().lock();

            System.out.println(Thread.currentThread().getName() + " 正在写入:" + key);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + " 写入完成");
        } finally {
            rwLock.writeLock().unlock();
        }
    }

    public void get(String key) {
        try {
            rwLock.readLock().lock();

            System.out.println(Thread.currentThread().getName() + " 正在读取:" + key);
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Object value = map.get(key);
            System.out.println(Thread.currentThread().getName() + " 读取完成: " + value);
        } finally {
            rwLock.readLock().unlock();
        }
    }

    // 模拟清除缓存
    public void clearMap() {
        map.clear();
    }

}

public class ReadWriteLockDemo {

    public static void main(String[] args) {
        MyCache myCache = new MyCache();

        for (int i = 1; i <= 5; i++) {
            final int tempInt = i;
            new Thread(() -> {
                myCache.put(tempInt + "", tempInt + "");
            }, String.valueOf(i)).start();
        }

        for (int i = 1; i <= 5; i++) {
            final int tempInt = i;
            new Thread(() -> {
                myCache.get(tempInt + "");
            }, String.valueOf(i)).start();
        }
    }

}
