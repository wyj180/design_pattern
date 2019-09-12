package com.study.duilie;

import org.junit.Test;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

// 二叉树层序遍历
public class LevelOrder {

    private class TreeNode {
        Integer val;
        TreeNode left;
        TreeNode right;
    }

    @Test
    public void test01() {
        TreeNode head = null;

        List<List<Integer>> result = new ArrayList<>();

        LinkedList<Pair<TreeNode, Number>> queue = new LinkedList();
        queue.push(new Pair<>(head, 0));

        while (!queue.isEmpty()) {
            Pair<TreeNode, Number> firstNode = queue.removeFirst();

            TreeNode node = firstNode.getNode();
            int level = firstNode.getNumber().intValue();

            if (level == result.size()) {
                result.add(new ArrayList<>());
            }
            result.get(level).add(node.val);

            if (node.left != null) {
                queue.add(new Pair<>(node.left, level + 1));
            }

            if (node.right != null) {
                queue.add(new Pair<>(node.right, level + 1));
            }
        }
    }

    // 给出一个正整数，寻找最少的完全平方数，使他们的和为n
    public void test02() {

        int n = 9;

        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();

        // 访问根节点，并把根节点放入队列里面
        boolean[] marked = new boolean[n + 1];
        marked[n] = true;
        queue.add(new Pair<>(9, 0));

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> node = queue.removeFirst();
            Integer node1 = node.getNode();
            Integer number = node.getNumber();

            // 查找成功
            if (node1 == 0) {
                System.out.println("level = " + number);
                return;
            }

            // 访问领边(边的权值相差n*n)
            for (int i = 1; (n - i * i) >= 0; i++) {
                int num = n - i * i;

                if (marked[num] != true) {
                    if (num == 0) {
                        System.out.println("level = " + number + 1);
                        return;
                    }
                    marked[num] = true;
                    queue.addLast(new Pair<>(num, number + 1));
                }
            }
        }
    }

    @Test
    public void test03() {
        // 默认从小到大，即构建的堆是最小堆
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < 10; i++) {
            int v = (int) (Math.random() * 100);
            queue.add(v);
            System.out.print(v + " ");
        }
        System.out.println();

        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
    }

    private class Pair<T, V> {
        T node;
        V number;

        public Pair(T node, V v) {
            this.node = node;
            this.number = v;
        }

        public T getNode() {
            return node;
        }

        public V getNumber() {
            return number;
        }
    }

}
