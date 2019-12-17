package com.example.mianshi01.base01.c_aba;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicStampedReferenceDemo {

    /**
     * 100为初始值，1 理解为版本号
     */
    private static AtomicStampedReference<Integer> atomicStampedReference =
            new AtomicStampedReference<>(100, 1);

    // ABA问题的解决，使用AtomicStampedReference类，这个类通过版本号来解决
    public static void main(String[] args) {
        System.out.println("===============以下是ABA问题的解决===============");

        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + "第一次版本号:" + stamp);

            // t3线程暂停1秒钟，保证t4线程和t3线程能拿到一样的版本号
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            atomicStampedReference.compareAndSet(100, 101, atomicStampedReference.getStamp(),
                    atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + "第二次版本号:" + atomicStampedReference.getStamp());

            atomicStampedReference.compareAndSet(101, 100, atomicStampedReference.getStamp(),
                    atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + "第三次版本号:" + atomicStampedReference.getStamp());
        }, "t3").start();

        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + "第一次版本号:" + atomicStampedReference.getStamp());
            // t4线程暂停3秒钟，保证上面的t3线程完成一次ABA操作
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean result = atomicStampedReference.compareAndSet(100, 2019, stamp, stamp + 1);

            System.out.println(Thread.currentThread().getName() + "修改成功否:" + result + "当前最新实际版本号："
                    + atomicStampedReference.getStamp());
            System.out.println(Thread.currentThread().getName() + "当前实际最新值:" + atomicStampedReference.getReference());
        }, "t4").start();
    }

}
