package com.study.a_base;

import org.junit.Test;
import utils.ArrayUtils;

/**
 * 插入排序
 * 思想：假设第1个元素时排序好的
 */
public class InsertionSort01 {

    @Test
    public void test01() {
        int[] data = {23, 2, 45, 30, 5};

        // 需要插入的值的下标
        for (int i = 1; i < data.length; i++) {
            int temp = i; // 需要插入元素的位置
            int currentData = data[temp]; // 需要插入的元素
            while (temp >= 1 && (currentData < data[temp - 1])) {
                data[temp] = data[temp - 1];
                temp--;
            }
            if (i != temp) {
                data[temp] = currentData;
            }
        }

        ArrayUtils.printArray(data);
    }

}
