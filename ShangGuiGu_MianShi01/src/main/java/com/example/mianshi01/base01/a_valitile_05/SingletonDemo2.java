package com.example.mianshi01.base01.a_valitile_05;

public class SingletonDemo2 {

    private static volatile SingletonDemo2 instance;

    private SingletonDemo2() {
        System.out.println(Thread.currentThread().getName() + "构造方法");
    }

    // DCL（Double Check Lock双端检锁机制）
    public static SingletonDemo2 getInstance() {
        if (instance == null) {
            synchronized (SingletonDemo2.class) {
                if (instance == null) {
                    instance = new SingletonDemo2();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                SingletonDemo2.getInstance();
            }, String.valueOf(i)).start();
        }

    }
}
