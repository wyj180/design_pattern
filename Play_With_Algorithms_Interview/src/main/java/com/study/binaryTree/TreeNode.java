package com.study.binaryTree;

public class TreeNode<T> {

    public T t;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(T t, TreeNode left, TreeNode right) {
        this.t = t;
        this.left = left;
        this.right = right;
    }

    public TreeNode(T t) {
        this.t = t;
    }

}
