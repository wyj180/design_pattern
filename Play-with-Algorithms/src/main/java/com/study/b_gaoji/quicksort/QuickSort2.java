package com.study.b_gaoji.quicksort;


import utils.MySortTestHelper;

public class QuickSort2 {

    // 对arr[left...right]部分进行partition操作
    // 返回p, 使得arr[left...p-1] < arr[p] ; arr[p+1...right] > arr[p]
    private static int partition(int[] arr, int left, int right) {
        int v = arr[left]; // v作为partition的对比元素

        int j = left; // arr[left+1...j] < v ; arr[j+1...i) > v
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] < v) {
                j++;
                MySortTestHelper.swap(arr, j, i);
            }
        }
        // 交互left和j的元素位置
        MySortTestHelper.swap(arr, left, j);

        return j;
    }

    // 递归使用快速排序,对arr[left...right]的范围进行排序
    private static void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int p = partition(arr, left, right);
        sort(arr, left, p - 1);
        sort(arr, p + 1, right);
    }

    public static void sort(int[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    // 测试 QuickSort
    public static void main(String[] args) {
        // Quick Sort也是一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        int N = 10;
        int[] arr = MySortTestHelper.generateRandomArray(N, 1, 10000);

        sort(arr);

        MySortTestHelper.printArr(arr);
        // 测试结果1 2 4 5 5 6 7 8 8 9
    }
}
