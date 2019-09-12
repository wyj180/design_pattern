package com.study.linked;

// 在链表中删除值为val的所有节点
public class RemoveElement {

    public ListNode removeElement(ListNode head, int val) {

        // 设置虚拟头节点
        ListNode summ = new ListNode(0);
        summ.next = head;

        ListNode cur = summ;
        while (cur.next != null) {
            if (cur.next.val == val) { // 删除操作
                ListNode delNode = cur.next;
                cur.next = delNode.next;
            } else {
                cur = cur.next;
            }
        }

        return summ.next;
    }
}
