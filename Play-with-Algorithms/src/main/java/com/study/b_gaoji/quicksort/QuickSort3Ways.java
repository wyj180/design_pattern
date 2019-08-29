package com.study.b_gaoji.quicksort;

import utils.MySortTestHelper;

public class QuickSort3Ways {

    private static int findIndex = 1;
    private static int findData = 0;

    // 递归使用快速排序,对arr[l...r]的范围进行排序
    private static void sort(int[] arr, int l, int r) {

        // 对于小规模数组, 使用插入排序
        if (l >= r) {
            return;
        }

        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        MySortTestHelper.swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);

        int v = arr[l];

        int lt = l;     // arr[l+1...lt] < v
        int gt = r + 1; // arr[gt...r] > v
        int i = l + 1;    // arr[lt+1...i) == v
        while (i < gt) {
            if (arr[i] < v) {
                MySortTestHelper.swap(arr, i, lt + 1);
                i++;
                lt++;
            } else if (arr[i] > v) {
                MySortTestHelper.swap(arr, i, gt - 1);
                gt--;
            } else { // arr[i] == v
                i++;
            }
        }

        MySortTestHelper.swap(arr, l, lt);

        // 如果排序的数的位置等于需要寻找的数的位置
        if (lt == (arr.length - findIndex)) {
            findData = arr[lt];
            return;
        }

        if (lt > (arr.length - findIndex)) {
            sort(arr, l, lt - 1);
        } else {
            sort(arr, gt, r);
        }
    }

    public static void sort(int[] arr) {

        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    // 测试 QuickSort3Ways
    public static void main(String[] args) throws InterruptedException {

        // 三路快速排序算法也是一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        int N = 1000000;
        int[] arr = {2, 1, 3, 5, 4};

        sort(arr);

        MySortTestHelper.printArr(arr);

        Thread.sleep(1000);
        System.out.println();
        System.out.println(findData);
    }
}