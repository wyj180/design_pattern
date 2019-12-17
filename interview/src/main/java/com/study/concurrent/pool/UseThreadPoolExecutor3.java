package com.study.concurrent.pool;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class UseThreadPoolExecutor3 implements Runnable {

    private static AtomicInteger count = new AtomicInteger(0);

    @Override
    public void run() {
        try {
            int temp = count.incrementAndGet();
            System.out.println("任务" + temp);
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        //System.out.println(Runtime.getRuntime().availableProcessors());
        BlockingQueue<Runnable> queue =
//                new LinkedBlockingQueue<Runnable>(); //无界队列
				new ArrayBlockingQueue<Runnable>(10); //有界队列
        //ExecutorService executor1 = Executors.newCachedThreadPool();
        ExecutorService executor1 = Executors.newFixedThreadPool(5);
        ThreadPoolExecutor executor = (ThreadPoolExecutor)executor1;

        queue = executor.getQueue();

        System.out.println("核心线程数量" + executor.getCorePoolSize()); //
        System.out.println("线程存活的数量" + executor.getActiveCount());

        for (int i = 0; i < 20; i++) {
            executor.execute(new UseThreadPoolExecutor3());
        }
        Thread.sleep(1000);
        System.out.println("线程存活的数量" + executor.getActiveCount());
        System.out.println("queue size:" + queue.size());        //10
        Thread.sleep(2000);

        Thread.sleep(5000);
        System.out.println("核心线程数量" + executor.getCorePoolSize()); //
        System.out.println("线程总数量" + executor.getActiveCount()); //
    }
}
