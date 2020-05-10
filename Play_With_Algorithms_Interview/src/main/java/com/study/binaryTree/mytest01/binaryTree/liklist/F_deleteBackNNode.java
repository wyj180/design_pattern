package com.study.binaryTree.mytest01.binaryTree.liklist;

import org.junit.Test;

// 删除倒数第n个数
public class F_deleteBackNNode {

    Node node1 = new Node(1);
//    Node node2 = new Node(2);
//    Node node3 = new Node(3);
//    Node node4 = new Node(4);

    {
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
    }

    @Test
    public void test01() {
        Node<Integer> newHead = deleteBackN(node1, 1);
        System.out.println(newHead);
    }

    public Node<Integer> deleteBackN(Node node, int num) {
        if (node == null) {
            return null;
        }

        // 创建虚拟节点
        Node<Integer> dummyNode = new Node<Integer>(-1);
        dummyNode.next = node;

        Node<Integer> p = dummyNode;
        Node<Integer> q = dummyNode;

        // 滑动窗口的距离，post先往后移动
        for (int i = 0; i <= num; i++) {
            if(q == null){
                throw new IllegalArgumentException("不存在该元素");
            }
            q = q.next;
        }

        // cur和post同时往后移动
        while (q != null) {
            p = p.next;
            q = q.next;
        }

        Node<Integer> delNode = p.next;

        p.next = delNode.next;
        delNode.data = null;
        delNode.next = null;

        return dummyNode.next;
    }

}
