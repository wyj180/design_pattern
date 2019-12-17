package com.study.chazhaobiao;

import org.junit.Test;

import java.util.TreeSet;

// 给出一个整形数组Nums，是否存在索引i和j，使得nums[i]和nums[j]之间的差不超过给定的整数t，且i和j之间的差别不超过给定的整数k
// 分析：i和j之间的差别不超过给定的整数k; --> 可以理解为滑动窗口的大小为(k+1)时，就需要做滑动
//       使得nums[i]和nums[j]之间的差不超过给定的整数t，需要从滑动窗口中找出最大的数和v元素做比较
public class ContainsNearbyAlmostDuplicate {


    @Test
    public void test01() {
        int k = 2;
        int t = 5;

        int[] arr = {};

        // 滑动窗口使用TreeSet
        TreeSet<Integer> record = new TreeSet<>();

        for (int i = 0; i < arr.length; i++) {
            Integer dis = record.ceiling(arr[i] - t);
            if (dis != null && dis <= arr[i] + t) { // 成功找到的情况
                System.out.println("查找成功");
                return;
            } else {
                // 没有找到的情况
                record.add(arr[i]);
                if (record.size() == k + 1) { // 窗口滑动操作
                    record.remove(arr[i - k]);
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(3);
        set.add(5);
        set.add(7);
        set.add(9);

        System.out.println(set.ceiling(5));
        // 3的ceil = 5
        // 5d ceil = 5
    }

}
