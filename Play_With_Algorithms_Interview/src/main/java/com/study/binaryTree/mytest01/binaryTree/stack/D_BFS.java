package com.study.binaryTree.mytest01.binaryTree.stack;

import java.util.LinkedList;

public class D_BFS {

    public int numSquares(int n) {

        if (n == 0)
            return 0;

        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<Pair<Integer, Integer>>();
        queue.addLast(new Pair<Integer, Integer>(n, 0));

        boolean[] visited = new boolean[n + 1]; // 这里从0开始，所以需要+1
        visited[n] = true;

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> front = queue.removeFirst();
            int num = front.k;
            int step = front.v;

            if (num == 0)
                return step;

            for (int i = 1; num - i * i >= 0; i++) { // 寻找和num相连接的节点
                int a = num - i * i; // 和num相连接的节点值, 如果为0节点，表示就是最短路径
                if (!visited[a]) { // 表示a这个数是否被访问过

                    if (a == 0) // 找到了最短路径
                        return step + 1;

                    queue.addLast(new Pair(a, step + 1)); // 把和num相邻的节点a放入队列中
                    visited[a] = true; // 标记该路径已经被访问过
                }
            }
        }

        throw new IllegalStateException("No Solution.");
    }

    public static void main(String[] args) {

        System.out.println((new D_BFS()).numSquares(5));
        //System.out.println((new D_BFS()).numSquares(13));
    }

}
