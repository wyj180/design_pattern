package com.study.binaryTree.mytest01.binaryTree.liklist;

import org.junit.Test;

// 反转链表
public class A_revert {

    Node node1 = new Node(1);
    Node node2 = new Node(2);
    Node node3 = new Node(3);

    {
        node1.next = node2;
        node2.next = node3;
    }

    @Test
    public void test01() {
        Node<Integer> newHead = revert(node1);
        System.out.println(newHead);
    }

    public Node<Integer> revert(Node root) {

        Node<Integer> pre = null;
        Node<Integer> cur = root;

        while (cur != null) {
            Node<Integer> next = cur.next;

            // 反转一个节点
            cur.next = pre;

            // 指针往下
            pre = cur;
            cur = next;
        }

        return pre;
    }

}
