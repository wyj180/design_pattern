package com.study.dui.mytest;

import utils.MySortTestHelper;

public class HeapSort {

    // 这种排序方式，使用了额外的空间
    public void sort(int[] arr) {
        int n = arr.length;

        // 堆
        MyMaxHeap heap = new MyMaxHeap(n);
        // 使用逐一插入元素的方式构建最大堆，shiftUp
        for (int i = 0; i < n; i++) {
            heap.insert(arr[i]);
        }

        // 从堆中取出数据排序
        for (int i = n; i >= 1; i--) {
            arr[i - 1] = heap.extract();
        }
    }

    // 这种排序方式，使用了额外的空间
    public void sort2(int[] arr) {
        int n = arr.length;

        // 构建最大堆，使用shiftDown的方式构建
        MyMaxHeap heap = new MyMaxHeap(arr);

        // 从堆中取出数据排序
        for (int i = n; i >= 1; i--) {
            arr[i - 1] = heap.extract();
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 1, 4};
        int[] array = MySortTestHelper.copyIntArray(arr);
        new HeapSort().sort(arr);
        MySortTestHelper.printArr(arr);

        System.out.println();
        // 排序方式二
        MyMaxHeap myMaxHeap = new MyMaxHeap(array);
        MySortTestHelper.printArr(array);
    }
}
