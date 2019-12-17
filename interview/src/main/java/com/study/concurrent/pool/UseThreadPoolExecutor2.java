package com.study.concurrent.pool;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class UseThreadPoolExecutor2 implements Runnable {

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
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                5,        //core
                10,    //max
                1L,    //2fenzhong
                TimeUnit.SECONDS,
                queue);

        System.out.println("核心线程数量" + executor.getCorePoolSize()); //
        System.out.println("线程存活的数量" + executor.getActiveCount());

        for (int i = 0; i < 20; i++) {
            executor.execute(new UseThreadPoolExecutor2());
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
