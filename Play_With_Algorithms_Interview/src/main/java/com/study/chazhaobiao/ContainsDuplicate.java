package com.study.chazhaobiao;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

// 给出一个整形数组nums和一个整数k,
// 是否存在索引i和j,使得nums[i] == nums[j]，且i和j之间的差不超过k
public class ContainsDuplicate {

    // 思路：使用滑动窗口，使用set来记录滑动窗口
    @Test
    public void test01() {
        int[] arr = {};
        int k = 2;

        Set<Integer> temp = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            if (temp.contains(arr[i])) { // 情况一：查找成功
                System.out.println("查找成功");
                break;
            } else { //查找失败
                temp.add(arr[i]);
                if (temp.size() == k + 1) {
                    temp.remove(arr[i - k]);
                }
            }
        }

    }
}
