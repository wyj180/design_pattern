package com.study.binaryTree;

public class TreeNode<T> {

    T t;
    TreeNode left;
    TreeNode right;

    public TreeNode(T t, TreeNode left, TreeNode right) {
        this.t = t;
        this.left = left;
        this.right = right;
    }

    public TreeNode(T t) {
        this.t = t;
    }

}
