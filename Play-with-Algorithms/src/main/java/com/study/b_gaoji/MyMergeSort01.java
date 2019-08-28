package com.study.b_gaoji;

import utils.SortTestHelper;

import java.util.Arrays;

public class MyMergeSort01 {

    /**
     * 归并操作, 将arr[left...mid]和arr[mid + 1...right]两部分进行归并
     * i, j, k，使用临时空间
     */
    public static void merge(int[] arr, int left, int middle, int right) {
        // 临时空间，用来取数据比较和取值放入到原数组中
        int[] aux = Arrays.copyOfRange(arr, left, right + 1);

        int i = left, j = middle + 1;
        for (int k = left; k <= right; k++) {
            if (i > middle) {
                // 情况一：左边的数全取完了，此时直接取右边的数
                arr[k] = aux[j - left];
                j++;
            } else if (j > right) {
                // 情况二：右边的数全取完了，此时直接取左边的数
                arr[k] = aux[i - left];
                i++;
            } else if (aux[i - left] > aux[j - left]) {
                // 情况三：右边的数小于左边的数，此时取右边的数
                arr[k] = aux[j - left];
                j++;
            } else {
                // 情况四：左边的数小于右边的数，此时取左边的数
                arr[k] = aux[i - left];
                i++;
            }
        }
    }

    /**
     * 递归使用归并排序，对arr[left...right]的范围进行排序
     */
    public static void sort(int[] arr, int left, int right) {
        // 划分只有一个元素时，向上merge
//        if (left >= right) {
//            return;
//        }

        // 元素很少的时候，使用插入排序
        if (right - left <= 15) {
            insertionSort(arr, left, right);
            return;
        }

        int mid = (left + right) / 2;
        sort(arr, left, mid); // 将数组左边部分排序好
        sort(arr, mid + 1, right); // 将数组右边部分排序好
        if (arr[mid] > arr[mid + 1]) {
            merge(arr, left, mid, right); // 归并
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 5, 4, 1};
        sort(arr, 0, arr.length - 1);
        SortTestHelper.printArr(arr);
    }

    // 插入排序
    public static void insertionSort(int[] data, int left, int right) {
        // 需要插入的值的下标
        for (int i = left + 1; i <= right; i++) {
            int temp = i; // 需要插入元素的位置
            int currentData = data[temp]; // 需要插入的元素
            // 插入排序，对于已经有序的数组，可以终止内层循环
            while (temp >= 1 && (currentData < data[temp - 1])) {
                data[temp] = data[temp - 1];
                temp--;
            }
            if (i != temp) {
                data[temp] = currentData;
            }
        }
    }

}
