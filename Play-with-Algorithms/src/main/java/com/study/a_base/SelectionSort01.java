package com.study.a_base;

import org.junit.Test;
import utils.ArrayUtils;

/**
 * 选择排序
 * 思想：
 * 1.首先找出最小的一个数，和第一个数交互
 * 2.找出第二小的数，和第二个数交互
 * ...
 */
public class SelectionSort01 {

    @Test
    public void test01() {
        int[] data = {23, 2, 45, 30, 5};

        // 第一次循环，依次获取最小元素的位置i
        for (int i = 0; i < data.length - 1; i++) {
            // 第二次循环: 找出最小的一个数
            int k = i; // 每次查找的最小数的位置
            for (int j = k + 1; j < data.length; j++) {
                if (data[j] < data[k]) {
                    k = j;
                }
            }
            // 把找到的最小元素的值和第i个位置交换
            if (i != k) {
                int temp = data[k];
                data[k] = data[i];
                data[i] = temp;
            }
        }

        ArrayUtils.printArray(data);
    }
}
