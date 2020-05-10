package com.study.binaryTree.mytest01.binaryTree.liklist;

import org.junit.Test;

// 删除链表值为val的元素
// 需要使用虚拟头结点，因为删除的数可能是第一个
public class C_deleteVal {

    Node node1 = new Node(1);
    Node node2 = new Node(2);
    Node node3 = new Node(3);
    Node node4 = new Node(3);

    {
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
    }

    @Test
    public void test01() {
        Node<Integer> newHead = deleteVal(node1, 3);
        System.out.println(newHead);
    }

    public Node<Integer> deleteVal(Node root, Integer val) {
        if (root == null) {
            return root;
        }

        Node<Integer> dummyHead = new Node<Integer>(null);
        dummyHead.next = root;

        Node<Integer> cur = dummyHead;

        while (cur.next != null) {
            Node<Integer> next = cur.next;
            if (val == next.data) {
                // 删除
                cur.next = next.next;
                next.next = null;
            } else {
                // 指针后移一位
                cur = cur.next;
            }
        }

        return dummyHead.next;
    }

}
