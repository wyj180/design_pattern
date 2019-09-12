package com.study.binaryTree;

import org.junit.Test;

import java.util.Map;

/**
 * 求一颗二叉树的最高深度
 */
public class MaximumDepth {

    @Test
    public void test01() {
        TreeNode<Integer> head = new TreeNode(1);
        TreeNode<Integer> node1 = new TreeNode(2);
        TreeNode<Integer> node2 = new TreeNode(3);

        head.left = node1;
        node1.left = node2;

        System.out.println(maxDepth(head));
    }

    public int maxDepth(TreeNode<Integer> node) {
        // 递归跳出条件
        if (node == null) {
            return 0;
        }
        int leftDepth = maxDepth(node.left);
        int rightDepth = maxDepth(node.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

}
