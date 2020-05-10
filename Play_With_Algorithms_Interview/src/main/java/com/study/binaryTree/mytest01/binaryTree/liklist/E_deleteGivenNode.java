package com.study.binaryTree.mytest01.binaryTree.liklist;

import org.junit.Test;

// 删除给定的一个节点
public class E_deleteGivenNode {

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
        Node<Integer> newHead = delete(node4);
        System.out.println(newHead);
    }

    public Node<Integer> delete(Node node) {
        if (node == null) {
            return null;
        }

        if (node.next == null) {
            Node delNode = node;
            node.data = null;
            node.next = null;
            return delNode;
        }

        Node next = node.next;
        node.data = next.data;
        node.next = next.next;
        next.next = null;
        next.data = null;

        return node;
    }

}
