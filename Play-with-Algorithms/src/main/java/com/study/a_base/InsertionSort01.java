package com.study.a_base;

import org.junit.Test;
import utils.ArrayUtils;
import utils.SortTestHelper;

import javax.sound.midi.SoundbankResource;

/**
 * 插入排序
 * 思想：假设第1个元素时排序好的
 */
public class InsertionSort01 {

    // 版本一，每次发现小于需要插入的数，就做交互(三步操作来交换)，效率不高
    @Test
    public static void test01(int[] data) {
        for (int i = 1; i < data.length; i++) {
            int temp = i; // 需要插入元素的位置
            int currentData = data[temp]; // 需要插入的元素
            while (temp >= 1 && (currentData < data[temp - 1])) {
                SortTestHelper.swap(data, temp, temp - 1);
                temp--;
            }
        }
    }

    // 改进后的版本，发现小于插入元素的元素时，只标记当前位置，并且只交互一次，找到最终位置后再交互
    @Test
    public static void test02(int[] data) {
        // 需要插入的值的下标
        for (int i = 1; i < data.length; i++) {
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

//    public static void main(String[] args) {
//        int n = 1000;
//        int[] arr1 = SortTestHelper.generateRandomArray(n, 1, n);
//        SortTestHelper.printArr(arr1);
//    }

    public static void main(String[] args) {
        int n = 10000;
        int[] arr1 = SortTestHelper.generateNearlyOrderedArray(n, 100);

        long startTimes = System.currentTimeMillis();
        test01(arr1);
        long endTimes = System.currentTimeMillis();
        System.out.println("插入排序所花时间：" + (endTimes - startTimes));


        int[] arr2 = SortTestHelper.copyIntArray(arr1);
        startTimes = System.currentTimeMillis();
        SelectionSort01.sort(arr2);
        endTimes = System.currentTimeMillis();
        System.out.println("选择排序所花时间：" + (endTimes - startTimes));
    }

}
