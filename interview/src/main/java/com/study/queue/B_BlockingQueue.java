package com.study.queue;

import java.util.concurrent.CopyOnWriteArraySet;

public class B_BlockingQueue {

//    public static void main(String[] args) throws InterruptedException {
//        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(5);
////        queue.put("a");
//
//        System.out.println(queue.poll());
//
//        System.out.println("程序运行结束");
//    }

    public static void main(String[] args) {

        //CopyOnWriteArrayList<String> cwal = new CopyOnWriteArrayList<String>();
        CopyOnWriteArraySet<String> cwas = new CopyOnWriteArraySet<String>();
        //然后之后的使用和使用List和Set一样
        cwas.add("aaa");
        cwas.add("aaa");

        cwas.forEach(x -> System.out.println(x));

    }

    public void method1(){
        synchronized (this){

        }
    }

    static Object  lock = new Object();
    public void printNum(String tag){
        synchronized (lock.getClass()){
        // 上锁的代码
        }
    }
}
