package com.study.dui.mytest;

import utils.MySortTestHelper;

public class HeapSort2 {

    // 这种排序方式，不使用额外空间
    public void sort(int[] arr) {
        int n = arr.length;

        MyMaxHeap2 heap = new MyMaxHeap2(n);
        // 使用shiftDown，对数组进行原地排序
        for (int i = (n - 1) / 2; i >= 0; i--) {
            heap.shiftDown(arr, n, i);
        }

        // 依次将第一个元素放到数组后面，然后进行shiftDown操作
        for (int i = n - 1; i >= 0; i--) {
            MySortTestHelper.swap(arr, 0, i);
            heap.shiftDown(arr, i, 0);
        }
    }


    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 1, 4};
        new HeapSort2().sort(arr);
        MySortTestHelper.printArr(arr);
    }
}
