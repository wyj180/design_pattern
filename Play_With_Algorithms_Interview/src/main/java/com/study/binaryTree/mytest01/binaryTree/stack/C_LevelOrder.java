package com.study.binaryTree.mytest01.binaryTree.stack;

import com.study.binaryTree.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 层序遍历
 */



public class C_LevelOrder {

    TreeNode<Integer> node1 = new TreeNode<Integer>(4);
    TreeNode<Integer> node2 = new TreeNode<Integer>(2);
    TreeNode<Integer> node3 = new TreeNode<Integer>(7);

    TreeNode<Integer> node4 = new TreeNode<Integer>(1);
    TreeNode<Integer> node5 = new TreeNode<Integer>(3);


    {
        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;
    }

    @Test
    public void test01() {
        List<List<Integer>> levelOrder = levelOrder(node1);
        System.out.println(levelOrder);
    }

    // 使用队列实现二叉树的层序遍历
    public List<List<Integer>> levelOrder(TreeNode node) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(node, 0));

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> ele = queue.pop();
            TreeNode<Integer> curNode = ele.k;
            Integer level = ele.v;

            // 第一次添加元素到List<List>>中时，先添加List
            if (result.size() == level) {
                result.add(level, new ArrayList<>());
            }

            result.get(level).add(curNode.t);

            // 添加左右子树
            if (curNode.left != null) {
                queue.add(new Pair<>(curNode.left, level + 1));
            }
            if (curNode.right != null) {
                queue.add(new Pair<>(curNode.right, level + 1));
            }
        }

        return result;
    }

}
