package com.study.a_base;

import utils.SortTestHelper;

/**
 * 选择排序
 * 思想：
 * 1.首先找出最小的一个数，和第一个数交互
 * 2.找出第二小的数，和第二个数交互
 * ...
 */
public class SelectionSort01 {

    public static void sort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            // 寻找[i, n)区间里最小的元素
            int k = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[k]) {
                    k = j;
                }
            }
            SortTestHelper.swap(arr, i, k);
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 1, 4, 2, 2, 5};
        sort(arr);
        SortTestHelper.printArr(arr);
        // 输出：1 2 2 3 4 5 5
    }
}
