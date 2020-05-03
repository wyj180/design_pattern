package com.study.queue;

import java.util.concurrent.ConcurrentLinkedQueue;

public class A_Test_ConcurrentLinkedQueue {

    public static void main(String[] args) {
        ConcurrentLinkedQueue<String> q = new ConcurrentLinkedQueue<String>();
        q.offer("a");
        q.offer("b");
        q.offer("c");
        q.offer("d");
        q.add("e");

        System.out.println(q.poll());
        System.out.println(q.size());
        System.out.println(q.peek());
        System.out.println(q.size());
        /**
         * 输出：
         *  a
         4
         b
         4
         */
    }
}
