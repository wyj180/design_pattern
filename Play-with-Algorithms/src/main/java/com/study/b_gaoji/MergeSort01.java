package com.study.b_gaoji;

import org.junit.Test;
import utils.SortTestHelper;

import java.util.Arrays;

// 归并排序
public class MergeSort01 {

    // 将arr[l...mid]和arr[mid+1...r]两部分进行归并
    private static void merge(int[] arr, int l, int mid, int r) {

        int[] aux = Arrays.copyOfRange(arr, l, r + 1); // 临时空间，存放需要排序的数据

        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i = l, j = mid + 1;  // 比较i和j索引位置的元素，取小的元素插入k的位置
        for (int k = l; k <= r; k++) {
            if (i > mid) { // 如果左半部分元素已经全部处理完毕
                arr[k] = aux[j - l]; // 疑问：这里为什么是j - L ? 注意是L而不是1,2,3的1,这里是取临时数组的值来比较和赋值
                j++;
            } else if (j > r) { // 如果右半部分元素已经全部处理完毕
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l] < aux[j - l]) { // 左半部分所指元素 < 右半部分所指元素
                arr[k] = aux[i - l];
                i++;
            } else { // 左半部分所指元素 >= 右半部分所指元素
                arr[k] = aux[j - l];
                j++;
            }
        }
    }

    // 递归使用归并排序,对arr[l...r]的范围进行排序
    private static void sort(int[] arr, int l, int r) {

        if (l >= r) {
            return;
        }

        int mid = (l + r) / 2;
        sort(arr, l, mid);          // 将数组左半部分排好序，递归调用自己，将左边不断的一分为二做排序
        sort(arr, mid + 1, r);   // 将数组右半部分排好序
        merge(arr, l, mid, r);      // 将排好序的左右两边做归并
    }

    public static void sort(int[] arr) {

        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    // 测试MergeSort
    public static void main(String[] args) {

        // Merge Sort是我们学习的第一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        // 注意：不要轻易尝试使用SelectionSort, InsertionSort或者BubbleSort处理100万级的数据
        // 否则，你就见识了O(n^2)的算法和O(nlogn)算法的本质差异：）
        int[] arr = {2, 1};
        sort(arr);

        // 打印数组
        SortTestHelper.printArr(arr);
    }

}
