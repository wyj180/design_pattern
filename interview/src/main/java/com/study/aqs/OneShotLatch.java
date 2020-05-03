package com.study.aqs;

import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;

/**
 * 描述：自己用AQS实现一个简单的线程协作器
 */
public class OneShotLatch {

    private Sync sync = new Sync();

    // 释放锁
    public void signal() {
        // 调用AQS中的方法, 然后会调用我们重写的tryReleaseShared()方法
        sync.releaseShared(0);
    }

    // 获取锁
    public void await() {
        // 调用AQS中的方法，然后会调用我们重写的tryAcquireShared()方法
        sync.acquireShared(0);
    }

    private class Sync extends AbstractQueuedLongSynchronizer {

        /**
         * AQS中的acquireShared()方法，这里返回来调用我们的tryAcquireShared()方法
         * public final void acquireShared(long arg) {
         * if (tryAcquireShared(arg) < 0)
         * // 这个方法，会让线程去排队等待
         * doAcquireShared(arg);
         * }
         */
        // 重试获取锁的方法
        @Override
        protected long tryAcquireShared(long arg) {
            // 返回1，表示获取锁成功
            // 返回-1，这表示获取锁失败，此时会在AQS中的方法中放入阻塞队列
            return (getState() == 1) ? 1 : -1;
        }

        /**
         * AQS中的releaseShared()方法，这里会调用我们的tryReleaseShared()方法
         * <p>
         * public final boolean releaseShared(long arg) {
         * if (tryReleaseShared(arg)) {
         * // 唤醒等待的线程，让他们继续执行
         * doReleaseShared();
         * return true;
         * }
         * return false;
         * }
         */
        // 尝试释放锁的方法
        @Override
        protected boolean tryReleaseShared(long arg) {
            setState(1); // 表示开闸，让别的线程执行
            return true;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        OneShotLatch oneShotLatch = new OneShotLatch();

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " 尝试获取latch，获取失败那就等待");
                    oneShotLatch.await();
                    System.out.println(Thread.currentThread().getName() + " 开闸放行，继续运行");
                }
            }).start();
        }

        // 主线程5秒钟后去开闸放行
        Thread.sleep(5000);
        System.out.println("主线程开闸...");
        oneShotLatch.signal();
    }
}
