package com.study.binaryTree.mytest01.binaryTree.liklist;

import org.junit.Test;

// 删除链表重复元素
// 有序链表
public class B_deleteDuplicate {

    Node node1 = new Node(1);
    Node node2 = new Node(1);
    Node node3 = new Node(3);
    Node node4 = new Node(3);

    {
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
    }

    @Test
    public void test01() {
        Node<Integer> newHead = deleteDuplicate(node1);
        System.out.println(newHead);
    }

    public Node<Integer> deleteDuplicate(Node root) {
        if (root == null) {
            return root;
        }

        Node<Integer> cur = root;

        while (cur.next != null) {
            Node<Integer> next = cur.next;
            if (cur.data == next.data) {
                // 删除
                cur.next = next.next;
                next.next = null;
            } else {
                // 指针后移一位
                cur = cur.next;
            }
        }

        return root;
    }

}
