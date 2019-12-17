package com.study.suzu;

import org.junit.Test;

// 查找最小连续子数组，使得其和>=s
public class MinSubArrayLen {

    int[] nums = {2, 3, 1, 2, 4, 3};
    int s = 8;

    @Test
    public void test01() {
        int l = 0;
        int r = 0;

        int result = nums.length + 1;
        int sum = 0;

        while (l < nums.length) {
            if (r + 1 < nums.length && sum < s) { // 右边移动一位
                sum += nums[++r];
            } else {
                sum -= nums[l++];
            }
            if (sum >= s) {
                result = Math.min(result, (r - l + 1));
            }
        }

        if (result == nums.length + 1) {
            System.out.println("结果：0");
        } else {
            System.out.println("结果：" + result);
            System.out.println("i = " + l + ",r = " + r);
        }
    }
}
