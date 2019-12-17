package com.study.concurrent.ProviderConsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * 消费者
 */
public class Consumer implements Runnable {

    private BlockingQueue<MyData> queue;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    //随机对象
    private static Random r = new Random();

    @Override
    public void run() {
        while (true) {
            try {
                //获取数据
                MyData data = this.queue.take();
                //进行数据处理。休眠0 - 1000毫秒模拟耗时
                Thread.sleep(r.nextInt(1000));
                System.out.println("消费者线程：" + Thread.currentThread().getName() + "， 消费成功，消费数据为id: " + data.getId());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}