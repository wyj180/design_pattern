package com.study.linked;

// 移除倒数第n个元素
public class RemoveNth {

    public ListNode deleteNode(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = dummyNode;

        // 设置p和q两个指针
        ListNode p = dummyNode;
        ListNode q = dummyNode;

        for (int i = 0; i < n + 1; i++) {
            q = q.next;
        }

        while (q != null) {
            p = p.next;
            q = q.next;
        }

        p.next = p.next.next;

        return dummyNode.next;
    }
}
