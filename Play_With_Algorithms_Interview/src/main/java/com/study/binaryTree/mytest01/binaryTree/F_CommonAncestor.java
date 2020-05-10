package com.study.binaryTree.mytest01.binaryTree;

import com.study.binaryTree.TreeNode;
import org.junit.Test;

// 求两个节点的公共祖先
public class F_CommonAncestor {

    TreeNode<Integer> node1 = new TreeNode<Integer>(6);
    TreeNode<Integer> node2 = new TreeNode<Integer>(2);
    TreeNode<Integer> node3 = new TreeNode<Integer>(8);

    TreeNode<Integer> node4 = new TreeNode<Integer>(0);
    TreeNode<Integer> node5 = new TreeNode<Integer>(4);

    TreeNode<Integer> node6 = new TreeNode<Integer>(7);
    TreeNode<Integer> node7 = new TreeNode<Integer>(9);

    TreeNode<Integer> node8 = new TreeNode<Integer>(3);
    TreeNode<Integer> node9 = new TreeNode<Integer>(5);

    {
        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        node5.left = node8;
        node5.right = node9;
    }

    @Test
    public void commonAncestor() {
        TreeNode<Integer> commonAncestor = commonAncestor(node1, 3, 9);
        System.out.println(commonAncestor.t);
    }

    public TreeNode<Integer> commonAncestor(TreeNode<Integer> node, Integer p, Integer q) {

        // 递归跳出条件
        if (node == null) {
            return null;
        }

        if (p > node.t && q > node.t) {
            return commonAncestor(node.right, p, q);
        }

        if (p < node.t && q < node.t) {
            return commonAncestor(node.left, p, q);
        }

        return node;
    }

}
