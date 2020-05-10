package com.study.binaryTree.mytest01.binaryTree;

import com.study.binaryTree.TreeNode;
import org.junit.Test;

/**
 * 求二叉树的最大深度
 */
public class A_MaxDeep {

    TreeNode<Integer> node1 = new TreeNode<Integer>(2);
    TreeNode<Integer> node2 = new TreeNode<Integer>(1);
    TreeNode<Integer> node3 = new TreeNode<Integer>(3);

    {
        node1.left = node2;
        node1.right = node3;
    }

    @Test
    public void maxDeep() {
        System.out.println(maxDeep(node1));
    }


    public <T> int maxDeep(TreeNode<T> node) {
        if (node == null) {
            return 0;
        }
        return Math.max(maxDeep(node.left), maxDeep(node.right)) + 1;
    }

}
