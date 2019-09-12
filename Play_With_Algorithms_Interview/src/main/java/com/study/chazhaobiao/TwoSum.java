package com.study.chazhaobiao;

import com.study.utils.MySortTestHelper;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int nums[] = {2,7,11,15};
        int target = 9;

        int[] ints = twoSum(nums, target);
        MySortTestHelper.printArr(ints);
    }

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> tempMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 获取组成target的值component
            int component = target - nums[i];

            if (tempMap.containsKey(component)) { // 查找成功的情况
                int[] res = { i, tempMap.get(component) };
                return res;
            } else {
                tempMap.put(nums[i], i);
            }
        }
        return null;
    }

}
