package com.study.binaryTree.mytest01.binaryTree;

import com.study.binaryTree.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Path Sum
 */
public class D_TreePaths {

    TreeNode<Integer> node1 = new TreeNode<Integer>(1);
    TreeNode<Integer> node2 = new TreeNode<Integer>(2);
    TreeNode<Integer> node3 = new TreeNode<Integer>(3);

    TreeNode<Integer> node4 = new TreeNode<Integer>(5);

    {
        node1.left = node2;
        node1.right = node3;

        node2.right = node4;
    }

    @Test
    public void treePath() {
        System.out.println(treePath(node1));
    }


    public <T> List<String> treePath(TreeNode<T> node) {
        List<String> ret = new ArrayList<>();

        // 递归终止条件
        if (node == null) {
            return ret;
        }

        if (node.left == null && node.right == null) {
            ret.add(node.t.toString());
            return ret;
        }

        List<T> leftTree = treePath(node.left);
        for (T t : leftTree) {
            ret.add(node.t + "->" + t);
        }

        List<T> rightTree = treePath(node.right);
        for (T t : rightTree) {
            ret.add(node.t + "->" + t);
        }

        return ret;
    }

}
