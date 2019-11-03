package com.segmentTree.basic;

/**
 * 线段树的实现
 */
public class segmentTree<E> {

    private E[] tree; // 树的节点
    private E[] data; // 树的元素

    public segmentTree(E[] arr) {
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        tree = (E[]) new Object[4 * arr.length];
    }

    public int getSize() {
        return data.length;
    }

    public E get(int index) {
        assert index >= 0 && index < data.length;
        return data[index];
    }

    // 返回完全二叉树的数组表示中，指定索引的左孩子的索引
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    // 返回完全二叉树的数组表示中，指定索引的右孩子的索引
    private int rightChild(int index) {
        return 2 * index + 2;
    }

}
