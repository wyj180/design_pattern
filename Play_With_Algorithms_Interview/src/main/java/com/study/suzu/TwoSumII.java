package com.study.suzu;

import org.junit.Test;

// 给定一个有序数组和一个整数target，在其中查找两个元素，使其和为target，返回这两个数的索引
public class TwoSumII {

    private int[] arr = {2, 7, 11, 15};

    // 暴力解法，双重for循环
    @Test
    public void test01() {
        int len = arr.length;
        int target = 9;

        int a = -1;
        int b = -1;

        breakPoint:
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (arr[i] + arr[j] == target) {
                    a = i;
                    b = j;
                    break breakPoint;
                }
            }
        }
        System.out.println("i = " + a + ", j = " + b);
    }

    @Test
    public void test002() {
        int i = 0;
        int j = arr.length - 1;
        int target = 9;

        while (i < j) {
            if (arr[i] + arr[j] == target) { // 情况一：查找成功
                break;
            } else if (arr[i] + arr[j] > target) {
                j--;
            } else {
                i++;
            }
        }

        System.out.println("运行结束");
        System.out.println("i = " + i + ", j = " + j);
    }

}
