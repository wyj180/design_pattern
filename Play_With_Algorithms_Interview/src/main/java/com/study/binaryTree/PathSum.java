package com.study.binaryTree;

import org.junit.Test;

/**
 * 给出一颗二叉树和一个数字sum，判断是否存在一条从根到叶子的路径，使得其路径上的节点的和为sum
 */
public class PathSum {

    @Test
    public void test01() {

    }

    public boolean hasPath(TreeNode<Integer> node, int sum) {

        if (node == null) {
            return false;
        }

        if (node.left == null && node.right == null) {
            return node.t == sum;
        }

        // 左节点查找
        if (hasPath(node.left, sum - node.t)) {
            return true;
        }

        //右节点查找
        if (hasPath(node.right, sum - node.t)) {
            return true;
        }

        return false;
    }
}
