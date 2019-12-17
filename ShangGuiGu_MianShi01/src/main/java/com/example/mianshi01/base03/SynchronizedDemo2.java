package com.example.mianshi01.base03;

import java.util.concurrent.locks.ReentrantLock;

// 代码二：ReentrantLock可重入锁代码
class Phone2 implements Runnable {

    ReentrantLock lock = new ReentrantLock(); // 注意这里的get()和set()使用的是同一把锁

    @Override
    public void run() {
        get();
    }

    public void get() {
        lock.lock();
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t invoked get()");
            Thread.sleep(3000);
            set();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void set() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t ### invoked set()");
        } finally {
            lock.unlock();
        }
    }
}

public class SynchronizedDemo2 {

    public static void main(String[] args) {

        Phone2 phone = new Phone2();

        Thread t3 = new Thread(phone, "t3");
        Thread t4 = new Thread(phone, "t4");

        t3.start();
        t4.start();
    }

}
