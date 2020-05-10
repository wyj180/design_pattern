package com.study.binaryTree.mytest01.binaryTree;

import com.study.binaryTree.TreeNode;
import org.junit.Test;

/**
 * Path Sum III
 * <p>
 * 给出一颗二叉树以及一个数字sum，判断这棵二叉树上存在多少条路径，其路径上的所有节点和为sum
 * <p>
 * 其中路径不一定要起始于根节点，终止于叶子节点
 * 路径可以从任意节点开始，但是只能是往下走的
 */
public class E_PathSum {

    TreeNode<Integer> node1 = new TreeNode<Integer>(10);
    TreeNode<Integer> node2 = new TreeNode<Integer>(5);
    TreeNode<Integer> node3 = new TreeNode<Integer>(-3);

    TreeNode<Integer> node4 = new TreeNode<Integer>(3);
    TreeNode<Integer> node5 = new TreeNode<Integer>(2);
    TreeNode<Integer> node6 = new TreeNode<Integer>(11);

    TreeNode<Integer> node7 = new TreeNode<Integer>(3);
    TreeNode<Integer> node8 = new TreeNode<Integer>(-2);
    TreeNode<Integer> node9 = new TreeNode<Integer>(1);

    {
        node1.left = node2;
        node1.right = node3;

        node3.right = node6;

        node2.left = node4;
        node2.right = node5;

        node4.left = node7;
        node4.right = node8;

        node5.right = node9;
    }

    @Test
    public void pathSum() {
        int ret = pathSum(node1, 10);
        System.out.println(ret);
    }

    public int pathSum(TreeNode<Integer> node, int num) {

        if (node == null) {
            return 0;
        }

        // 以当前节点为根节点查找和为num的路径
        int res = findSum(node, num);

        // 以当前节点左节点为根节点查找
        res += pathSum(node.left, num);

        // 以当前节点右节点为根节点查找
        res += pathSum(node.right, num);

        return res;
    }


    /**
     * 查找从一个节点开始，返回路径和为sum的数量
     */
    public int findSum(TreeNode<Integer> node, Integer sum) {

        int ret = 0;

        // 递归跳出条件
        if (node == null) {
            return ret;
        }

        if (node.t == sum) {
            ret++;
        }

        ret += findSum(node.left, sum - node.t);

        ret += findSum(node.right, sum - node.t);

        return ret;
    }

}
