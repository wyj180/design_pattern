package com.study.syn;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class ListAdd3 {

    private volatile static List list = new ArrayList();

    public void add() {
        list.add("bjsxt");
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) throws InterruptedException {
        final ListAdd3 list1 = new ListAdd3();

        //1.实例化出来一个lock
        //当使用wait和notify的时候，一定要配合synchronized关键字
        //final Object lock = new Object(); //把这个对象当成一把锁

        //该工具类可以做到实时通知的效果
        //CountDownLatch(1) 这里的1不能改成2
        //2可以理解为两次countDown()，之后await()才收到通知
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //synchronized (lock) {
                    for (int i = 0; i < 10; i++) {
                        list1.add();
                        System.out.println("当前线程：" + Thread.currentThread().getName() + "添加了一个元素..");
                        Thread.sleep(500);
                        if (list1.size() == 5) {
                            System.out.println("已经发出通知...");
                            countDownLatch.countDown(); //
                            //notify()方法是不会释放锁的
                            //lock.notify(); //此时t1是不会释放锁的
                        }
                    }
                    //}
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "t1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                //synchronized (lock) {
                if (list1.size() != 5) {
                    try {
                        System.out.println("t2线程执行了await()方法");
                        countDownLatch.await(); //表示等待
                        //lock.wait(); //wait()会释放锁
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                //i = 5的时候打印的信息
                System.out.println("当前线程收到通知：" + Thread.currentThread().getName()
                        + "线程停止..");
                throw new RuntimeException();
                //}
            }
        }, "t2");
        //注意：这里先启动t2，再启动t1线程
        t2.start();
        Thread.sleep(10);
        t1.start();
    }
}