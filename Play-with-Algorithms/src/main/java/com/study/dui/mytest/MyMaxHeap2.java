package com.study.dui.mytest;

import utils.MySortTestHelper;

// 使用0这个下标
public class MyMaxHeap2 {

    private int[] data;
    private int count;
    private int capacity;

    // 使用下标从1开始存储，0号位置不使用
    public MyMaxHeap2(int n) {
        data = new int[n + 1];
        capacity = n;
        count = 0;
    }

    /**
     * 对n个元素进行shiftDown操作
     * @param arr
     * @param n
     */
    public void shiftDown(int[] arr, int n, int i) {
        while (2 * i + 1 <= n - 1) {
            int j = 2 * i + 1 ; // 左右孩子中数值更大的下标，默认取左孩子
            if (j + 1 <= n - 1 && arr[j + 1] > arr[j]) {
                j++;
            }
            if (arr[i] >= arr[j]) { // 如果父节点大于左右孩子中大的一个，说明已经排序好
                break;
            }
            MySortTestHelper.swap(arr, i, j);
            i = j;
        }
    }

}
