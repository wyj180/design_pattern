package com.study.binaryTree.mytest01.binaryTree.stack;

import java.util.PriorityQueue;

public class UsePriorityQueue {

    public static void main(String[] args) {

        // 默认的PriorityQueue, 底层是最小堆
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for (int i = 0; i < 10; i++) {
            int num = (int) (Math.random() * 100);
            pq.add(num);
            System.out.println("insert " + num + " in priority queue.");
        }

        while (!pq.isEmpty())
            System.out.print(pq.poll() + " ");

        System.out.println();
        System.out.println();
    }
}
