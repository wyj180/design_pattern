package com.study.binaryTree.mytest01.binaryTree.liklist;

import org.junit.Test;

// 交换相邻元素
public class D_swapAdjEle {

    Node node1 = new Node(1);
    Node node2 = new Node(2);
    Node node3 = new Node(3);
    Node node4 = new Node(4);

    {
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
    }

    @Test
    public void test01() {
        Node<Integer> newHead = swap(node1);
        System.out.println(newHead);
    }

    public Node<Integer> swap(Node root) {
        if (root == null) {
            return root;
        }

        Node<Integer> dummyHead = new Node<Integer>(null);
        dummyHead.next = root;

        Node<Integer> pre = dummyHead;

        while (pre.next != null && pre.next.next != null) {
            Node<Integer> curA = pre.next;
            Node<Integer> curB = curA.next;
            Node<Integer> next = curB.next;

            curB.next = curA;
            curA.next = next;
            pre.next = curB;

            pre = curA;
        }

        return dummyHead.next;
    }

}
