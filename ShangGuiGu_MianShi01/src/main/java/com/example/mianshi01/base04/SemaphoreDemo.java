package com.example.mianshi01.base04;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

    // 6个车抢3个车位
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3); // 模拟3个停车位

        for (int i = 0; i <= 6; i++) { // 模拟6部汽车
            new Thread(() -> {
                try {
                    semaphore.acquire(); // 获取停车位
                    System.out.println(Thread.currentThread().getName() + "\t抢到车位");
                    Thread.sleep(3000); // 模拟每个车停3s钟
                    System.out.println(Thread.currentThread().getName() + "\t停车3秒后离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release(); // 释放停车位
                }
            }, String.valueOf(i)).start();
            ;
        }

    }

}
