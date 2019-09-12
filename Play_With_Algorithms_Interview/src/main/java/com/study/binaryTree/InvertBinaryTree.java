package com.study.binaryTree;

import org.junit.Test;

/**
 * 反转一颗二叉树
 */
public class InvertBinaryTree {

    @Test
    public void test01() {
        TreeNode<Integer> head = new TreeNode(1);
        TreeNode<Integer> node1 = new TreeNode(2);
        TreeNode<Integer> node2 = new TreeNode(3);

        head.left = node1;
        head.right = node2;

        invert(head);
    }

    public TreeNode invert(TreeNode<Integer> node) {
        if (node == null) {
            return null;
        }

        TreeNode left = invert(node.left);
        TreeNode right = invert(node.right);

        node.left = right;
        node.right = left;

        return node;
    }
}
