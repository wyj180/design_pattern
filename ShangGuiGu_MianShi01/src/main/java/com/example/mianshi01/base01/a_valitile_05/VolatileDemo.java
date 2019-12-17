package com.example.mianshi01.base01.a_valitile_05;


import java.util.concurrent.TimeUnit;

/**
 * 1 验证volatile的可见性
 * 1.1 假如int number = 0; 之前没有加volatile关键字修饰，没有可见性
 */
public class VolatileDemo {

    public static void main2(String[] args) {

        // 共享资源类
        MyData myData = new MyData();

        // 开启一个线程修改共享变量的值
        new Thread(() -> {
            // 休眠3秒
            System.out.println(Thread.currentThread().getName() + "\t come in");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                e.printStackTrace();
            }

            // 修改值为60
            myData.addTo60();
            System.out.println(Thread.currentThread().getName() + "\t update number value: " + myData.number);
        }, "AAA").start();

        // 第二个线程，也就是我们的main线程
        while (myData.number == 0) {
            // main线程就一直在这里循环等待，直到number的值不再等于0
        }

        // volatile int number = 0; 只有当共享变量的前面加了volatile，代码才会走到这里
        // mission:使命
        System.out.println(
                Thread.currentThread().getName() + "\t mission is over, main get number value : " + myData.number);

    }

    /**
     * * 2 验证volatile不保证原子性
     * *   2.1 原子性指的是什么意思?
     * *       不可分割，完整性，要么同时成功，要么同时失败
     * *   2.2 volatile不保证原子性案例演示
     *
     * @param args
     */
    public static void main3(String[] args) {
        MyData2 myData = new MyData2(); // 共享资源类

        // 新建20个线程，每个线程执行1000次相加，正确的结果应该就是20000
        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 1000; j++) {
                    myData.addPlusPlus(); // i++操作
                }
            }, String.valueOf(i)).start();
        }

        while (Thread.activeCount() > 2) { // 默认一个程序最少有两个线程，一个是main线程，一个是gc线程
            Thread.yield(); // main线程等待上面的20个线程执行完
        }

        // main线程查看最终值
        System.out.println(Thread.currentThread().getName() + "\t finally number value:" + myData.number);
    }

    // AtomicInteger解决原子性问题
    public static void main(String[] args) throws InterruptedException {
        MyData3 myData = new MyData3(); // 共享资源类

        // 新建20个线程，每个线程执行1000次相加，正确的结果应该就是20000
        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 1000; j++) {
                    myData.addPlusPlus(); // i++操作
                }
            }, String.valueOf(i)).start();
        }

//        while (Thread.activeCount() > 2) { // 默认一个程序最少有两个线程，一个是main线程，一个是gc线程
//            Thread.yield(); // main线程等待上面的20个线程执行完
//        }

        TimeUnit.SECONDS.sleep(3);

        // main线程查看最终值
        System.out.println(Thread.currentThread().getName() + "\t finally number value:" + myData.atomicInteger);
    }

}
