package com.study.linked;

import org.junit.Test;

// 交换两个相邻的节点
public class SwapNodesInPairs {

    ListNode node = new ListNode(5);

    {
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1);

        node.next = node4;
        node4.next = node3;
        node3.next = node2;
        node2.next = node1;
    }


    @Test
    public void test01() {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = node;

        printLinkedList(dummyNode.next);
        System.out.println();

        ListNode pre = dummyNode;

        while (pre.next != null && pre.next.next != null) {
            ListNode node1 = pre.next;
            ListNode node2 = pre.next.next;
            ListNode next = pre.next.next.next;

            // 交换操作
            pre.next = node2;
            node2.next = node1;
            node1.next = next;

            // 设置pre的值，为下一次交换做准备
            pre = node1;
        }

        printLinkedList(dummyNode.next);
    }

    // 删除给定的指定节点
    @Test
    public void test02() {
        ListNode node = null;
        ListNode delNode = node.next;
        node.val = delNode.val;
        node.next = delNode.next;
        delNode.next = null;
    }

    public void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
