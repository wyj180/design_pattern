package com.study.dui;

import utils.MySortTestHelper;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 最大堆
 * 数组下标从1开始的经典实现，0索引为空
 */
public class MaxHeap {

    private int[] data;
    private int count;
    private int capacity;

    public MaxHeap(int n) {
        data = new int[n + 1];
        capacity = n;
    }

    // heapify
    public MaxHeap(int[] arr, int n) {
        data = new int[n + 1];
        capacity = n;

        // 将需要排序的元素放入堆中
        for (int i = 0; i < n; i++) {
            data[i + 1] = arr[i];
        }
        count = n;
        // 从最后一个非叶子节点到根节点，做shiftDown操作
        for (int i = count / 2; i >= 1; i--) {
            shiftDown(i);
        }
    }

    // 插入元素k
    public void insert(int k) {
        data[count + 1] = k;
        count++;
        shiftUp(count);
    }

    // 新增元素
    public void shiftUp(int k) {
        while (k > 1 && data[k] > data[k / 2]) {
            MySortTestHelper.swap(data, k, k / 2);
            k = k / 2;
        }
    }

    // 移除堆元素，只能移除第一个元素
    public int extractMax() {
        int result = data[1];
        data[1] = data[count];
        count--;
        shiftDown(1);
        return result;
    }

    // 移除元素
    public void shiftDown(int k) {
        int n = count;
        while (2 * k <= n) { // 如果存在左孩子
            int j = 2 * k; // 指向左右孩子更大的那一个
            // 从左右孩子中选出大的一个
            while ((j + 1 <= n) && (data[j + 1] > data[j])) {
                j++;
            }
            // 如果根节点大于
            if (data[k] >= data[j]) {
                break;
            }

            // 交换
            MySortTestHelper.swap(data, k, j);
            k = j;
        }
    }

    // 测试 MaxHeap
//    public static void main(String[] args) {
//
//        MaxHeap maxHeap = new MaxHeap(10);
//        maxHeap.insert(62);
//        maxHeap.insert(41);
//        maxHeap.insert(30);
//        maxHeap.insert(28);
//        maxHeap.insert(16);
//        maxHeap.insert(22);
//        maxHeap.insert(13);
//        maxHeap.insert(52);
//        System.out.println(Arrays.toString(maxHeap.data));
//        // [0, 62, 52, 30, 41, 16, 22, 13, 28, 0, 0]
//
//        maxHeap.extractMax();
//        System.out.println(Arrays.toString(maxHeap.data));
//        // [0, 52, 41, 30, 28, 16, 22, 13, 28, 0, 0]
//    }

    public static void main(String[] args) {
        int[] arr = {62, 41, 30, 28, 16, 22, 13, 52};
        MaxHeap heap = new MaxHeap(arr, arr.length);
        System.out.println(Arrays.toString(heap.data));
        // [0, 62, 41, 30, 28, 16, 22, 13]
    }
}
