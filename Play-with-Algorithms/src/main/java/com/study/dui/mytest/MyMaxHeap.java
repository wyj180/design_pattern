package com.study.dui.mytest;

import utils.MySortTestHelper;

public class MyMaxHeap {

    private int[] data;
    private int count;
    private int capacity;

    public MyMaxHeap(int[] arr) {
        int n = arr.length;
        data = new int[n + 1];
        count = n;

        // 将需要拷贝的数组元素放入heap中
        for (int i = 1; i <= n; i++) {
            data[i] = arr[i - 1];
        }

        // heapify排序操作，从最后一个非叶子节点开始做shiftDown操作
        for (int i = n / 2; i >= 1; i--) {
            shiftDown(i);
        }
    }

    // 使用下标从1开始存储，0号位置不使用
    public MyMaxHeap(int n) {
        data = new int[n + 1];
        capacity = n;
        count = 0;
    }

    // 插入元素，先把元素放入数组末尾，再继续shiftUp操作
    public void insert(int k) {
        // 判断容量

        // 插入元素
        data[count + 1] = k;
        count++;
        shiftUp(count);
    }

    public int extract() {
        int res = data[1];
        MySortTestHelper.swap(data, 1, count);
        count--;
        shiftDown(1);
        return res;
    }

    private void shiftUp(int i) {
        // 如果存在父节点，则和父节点比较，若插入值大于父节点，则交换
        while (i / 2 > 1 && data[i] > data[i / 2]) { // 注意这里不能 == 1
            MySortTestHelper.swap(data, i, i / 2);
            i = i / 2;
        }
    }

    private void shiftDown(int i) {
        while (2 * i <= count) {
            int j = 2 * i; // 左右孩子中数值更大的下标，默认取左孩子
            if (j + 1 <= count && data[j + 1] > data[j]) {
                j++;
            }
            if (data[i] >= data[j]) { // 如果父节点大于左右孩子中大的一个，说明已经排序好
                break;
            }
            MySortTestHelper.swap(data, i, j);
            i = j;
        }
    }

}
