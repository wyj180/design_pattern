package com.study.dui.mytest;

/**
 * 最大索引堆
 */
public class MyIndexMaxHeap {

    private int[] data;
    private int[] index;
    private int count;
    private int capacity;

    public MyIndexMaxHeap(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        data = new int[capacity + 1];
        index = new int[capacity + 1];
    }

    public void insert(int item, int i) {
        assert count + 1 <= capacity;

        data[count + 1] = item;
        index[count + 1] = count + 1;

        count++;
        shiftUp(i);
    }

    private void shiftUp(int i) {
        while (i / 2 > 1 && data[index[i]] > data[index[i / 2]]) {
            swapIndex(i, i / 2);
            i /= 2;
        }
    }

    private void swapIndex(int i, int j) {
        int temp = index[i];
        index[i] = index[j];
        index[j] = temp;
    }

    private int extract() {
        assert count > 0;

        int res = data[index[1]];

        index[1] = index[count];
        count--;
        shiftDown(1);

        return res;
    }

    private void shiftDown(int i) {
        while (2 * i <= count) {
            int j = 2 * i;
            if (j + 1 <= count && data[index[j]] < data[index[j + 1 ]]) {
                j++;
            }

            if (data[i] >= data[j]) {
                break;
            }
            swapIndex(i, j);
            i = j;
        }
    }

}
