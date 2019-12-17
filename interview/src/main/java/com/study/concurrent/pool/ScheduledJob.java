package com.study.concurrent.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class Temp extends Thread {

    public void run() {
        System.out.println("run");
    }
}

public class ScheduledJob {
    public static void main(String args[]) throws Exception {

        Temp command = new Temp();

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        /**
         * 5 : 表示延迟5秒初始化
         * 1 : 表示1秒钟执行一次任务
         */
        ScheduledFuture<?> scheduleTask = scheduler.scheduleWithFixedDelay(command, 1, 1, TimeUnit.SECONDS);
    }
}
