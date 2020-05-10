package com.study.binaryTree.mytest01.binaryTree;

import com.study.binaryTree.TreeNode;
import org.junit.Test;

/**
 * 反转一颗二叉树
 */
public class B_InvertDeep {

    TreeNode<Integer> node1 = new TreeNode<Integer>(4);
    TreeNode<Integer> node2 = new TreeNode<Integer>(2);
    TreeNode<Integer> node3 = new TreeNode<Integer>(7);

    TreeNode<Integer> node4 = new TreeNode<Integer>(1);
    TreeNode<Integer> node5 = new TreeNode<Integer>(3);

    TreeNode<Integer> node6 = new TreeNode<Integer>(6);
    TreeNode<Integer> node7 = new TreeNode<Integer>(9);

    {
        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;
    }

    @Test
    public void invert() {
        invert(node1);
        System.out.println(node1);
    }


    public <T> TreeNode<T> invert(TreeNode<T> node) {

        if (node == null) {
            return null;
        }

        if (node.left == null && node.right == null) {
            return node;
        }

        // 先反转左子树
        TreeNode leftTree = invert(node.left);
        // 再反转右子树
        TreeNode rightTree = invert(node.right);

        node.left = rightTree;
        node.right = leftTree;

        return node;
    }

}
