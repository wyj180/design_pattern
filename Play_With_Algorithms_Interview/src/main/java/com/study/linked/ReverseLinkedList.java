package com.study.linked;

import org.junit.Test;

import java.util.List;

// 反转一个链表
// 思路：需要三个指针，初始值为：pre = null， cur = first，next = second
public class ReverseLinkedList {
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
        printLinkedList(node);
        System.out.println();

        ListNode pre = null;
        ListNode cur = node;
        while (cur != null) {
            ListNode next = cur.next;

            // 第一步：cur.next指向pre
            cur.next = pre;

            // 第二步：移动位置
            pre = cur;
            cur = next;
        }

        printLinkedList(pre);
    }

    public void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
