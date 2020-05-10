package com.study.juc.a_jiagou;

/**
 * 描述：演示栈封闭的两种情况，基本变量和对象
 * 先演示线程争抢带来的错误结果，然后把变量放到方法内，情况就变了
 */
public class StackConfinement implements Runnable{

    int index = 0;

    public void inThread(){
        int neverGoOut = 0;
        for (int i = 0; i < 10000; i++) {
            neverGoOut ++;
        }
        System.out.println("栈内保护的数字是线程安全的：" + neverGoOut);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            index++;
        }
        inThread();
    }

    // 测试一：测试i++线程不安全
//    public static void main(String[] args) throws InterruptedException {
//        // 共享变量
//        StackConfinement r1 = new StackConfinement();
//
//        Thread t1 = new Thread(r1);
//        Thread t2 = new Thread(r1);
//        t1.start();
//        t2.start();
//        t1.join();
//        t2.join();
//
//        System.out.println(r1.index);
//    }

    // 测试一：测试i++线程不安全
    public static void main(String[] args) throws InterruptedException {
        // 共享变量
        StackConfinement r1 = new StackConfinement();

        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(r1);
            t.start();
        }

        Thread.sleep(5000);
        System.out.println(r1.index);
        // 输出: 991751
    }

}
