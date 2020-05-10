package com.study.binaryTree.mytest01.binaryTree;

import com.study.binaryTree.TreeNode;
import org.junit.Test;

/**
 * Path Sum
 */
public class C_PathSum {

    TreeNode<Integer> node1 = new TreeNode<Integer>(5);
    TreeNode<Integer> node2 = new TreeNode<Integer>(4);
    TreeNode<Integer> node3 = new TreeNode<Integer>(8);

    TreeNode<Integer> node4 = new TreeNode<Integer>(11);
    TreeNode<Integer> node5 = new TreeNode<Integer>(13);

    TreeNode<Integer> node6 = new TreeNode<Integer>(4);
    TreeNode<Integer> node7 = new TreeNode<Integer>(7);
    TreeNode<Integer> node8 = new TreeNode<Integer>(2);
    TreeNode<Integer> node9 = new TreeNode<Integer>(1);

    {
        node1.left = node2;
        node1.right = node3;

        // 4
        node2.left = node4;

        node4.left = node7;
        node4.right = node8;

        node3.left = node5;
        node3.right = node6;

        node5.right = node9;
    }

    @Test
    public void pathSum() {
        //System.out.println(pathSum(node1, 22));
        System.out.println(pathSum(node1, 9));
    }


    public boolean pathSum(TreeNode<Integer> node, Integer remainSum) {
        if (node == null) {
            return false;
        }
        if (node.left == null && node.right == null) {
            return node.t == remainSum;
        }
        return pathSum(node.left, remainSum - node.t) || pathSum(node.right, remainSum - node.t);
    }

}
