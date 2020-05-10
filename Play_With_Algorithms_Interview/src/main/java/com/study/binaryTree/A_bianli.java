package com.study.binaryTree;

import org.junit.Test;

public class A_bianli {

    TreeNode<Integer> node1 = new TreeNode<Integer>(2);
    TreeNode<Integer> node2 = new TreeNode<Integer>(1);
    TreeNode<Integer> node3 = new TreeNode<Integer>(3);

    {
        node1.left = node2;
        node1.right = node3;
    }

    @Test
    public void preOrder() {
        //preOrder(node1);
        //midOrder(node1);
        //laterOrder(node1);

        System.out.println(contains(node1, 11));;
    }

    /**
     * 前序遍历
     *
     * @param node
     */
    public void preOrder(TreeNode<Integer> node) {
        // 递归版本

        // 递归跳出条件
        if (node == null) {
            return;
        }

        System.out.print(node.t + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 中序遍历
     * @param node
     */
    public void midOrder(TreeNode<Integer> node) {
        // 递归版本

        // 递归跳出条件
        if (node == null) {
            return;
        }
        preOrder(node.left);
        System.out.print(node.t + " ");
        preOrder(node.right);
    }

    /**
     * 后续遍历
     * @param node
     */
    public void laterOrder(TreeNode<Integer> node) {
        // 递归版本

        // 递归跳出条件
        if (node == null) {
            return;
        }
        preOrder(node.left);
        preOrder(node.right);
        System.out.print(node.t + " ");
    }

    public <T> boolean contains(TreeNode<T> node, T t) {
        // 递归版本

        // 递归跳出条件
        if (node == null) {
            return false;
        }

        if (node.t.equals(t)) {
            return true;
        }

        return contains(node.left, t) || contains(node.right, t);
    }

}
