package com.example.mianshi01.base03;

/**
 * 可重入锁(也叫做递归锁)
 */
public class LockDemo01 {

    public synchronized void method01() {
        System.out.println("进入方法method01()");
        method2();
    }

    private synchronized void method2() {
        System.out.println("进入方法method02()");
    }

}
