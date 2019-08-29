package com.study.b_gaoji.quicksort;

import utils.MySortTestHelper;

public class QuickSort2Ways {

    // 双路快速排序的partition
    // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
    private static int partition(int[] arr, int l, int r) {

        // 优化二：随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        //MySortTestHelper.swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);

        int v = arr[l];

        int i = l + 1, j = r;
        while (true) {
            // 从左边开始，寻找>=v的元素
            while (i <= r && arr[i] < v) {
                i++;
            }
            // 从右边开始，寻找<=v的元素
            while (j >= l + 1 && arr[j] > v) {
                j--;
            }

            if (i > j) {
                break;
            }
            // 交换i和j位置的元素
            MySortTestHelper.swap(arr, i, j);
            i++;
            j--;
        }

        MySortTestHelper.swap(arr, l, j);

        return j;
    }

    // 递归使用快速排序,对arr[l...r]的范围进行排序
    private static void sort(int[] arr, int l, int r) {

        // 优化一：对于小规模数组, 使用插入排序
//        if (r - l <= 15) {
//            MySortTestHelper.insertionSort(arr, l, r);
//            return;
//        }

        if (l >= r) {
            return;
        }

        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    public static void sort(int[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    // 测试 QuickSort
    public static void main(String[] args) {

        // 双路快速排序算法也是一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        int N = 10;
//        int[] arr = MySortTestHelper.generateRandomArray(N, 0, 100);
        int[] arr = {2, 2, 1, 5, 3, 1};
        sort(arr);

        MySortTestHelper.printArr(arr);

        return;
    }
}