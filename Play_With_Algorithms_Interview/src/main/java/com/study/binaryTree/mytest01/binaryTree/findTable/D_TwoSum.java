package com.study.binaryTree.mytest01.binaryTree.findTable;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给出一个整形数组nums和target，返回这个数组中两个数子的索引值i和j
 * 使得nums[i] + nums[j] 等于target值，两个索引不能相等
 */
public class D_TwoSum {

    @Test
    public void test01() {
        int[] num1 = {2, 7, 11, 15};
        int target = 9;
        List<Integer> result = sum(num1, target);
        System.out.println(result);
    }

    public List<Integer> sum(int[] num1, int target) {
        List<Integer> result = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < num1.length; i++) {
            int reduce = target - num1[i];
            if (map.containsKey(reduce)) {
                result.add(map.get(reduce));
                result.add(i);
                break;
            } else {
                map.put(num1[i], i);
            }
        }

        return result;
    }
}
