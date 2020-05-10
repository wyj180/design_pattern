package com.study.binaryTree.mytest01.binaryTree.findTable;

import org.junit.Test;

import java.util.TreeSet;

/**
 * 给出一个整形数组A 问是否存在索引i和j，使得A[i] == A[j] 且i和j之间的差不超过k
 * <p>
 * 思路：使用Set当做滑动窗口，set存储的值，就是滑动窗口内的值，size滑动窗口的大小
 */
public class F_ContainsDuplicateNumIII_my {

    @Test
    public void test01() {
        int[] A = {5, 1, -4};
        boolean result = containsNearbyAlmostDuplicate(A, 2, 2);
        System.out.println(result);
    }

    // 返回此集合中的最小元素大于或等于给定元素，或者如果没有此类元素，则为null
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // 这个问题的测试数据在使用int进行加减运算时会溢出
        // 所以使用long long
        TreeSet<Integer> record = new TreeSet<>();
        for (int j = 0; j < nums.length; j++) {
            // num[i] - num[j] <= t 推理出：num[i] <= t + num[j]
            // floor() 表示从set中获取 <= nums[j] + t的数
            Integer numI = record.floor(nums[j] + t);
            if (numI != null && numI - nums[j] <= t) {
                return true;
            } else {
                record.add(nums[j]);
                if (record.size() == k + 1) {
                    record.remove(nums[j - k]);
                }
            }
        }
        return false;
    }
//
//    public static void main(String[] args) {
//        TreeSet<Long> record = new TreeSet<>();
//        record.add(-9L);
//        record.add(10L);
//
//        System.out.println(record.ceiling(-10L)); // 输出：-9
//
//        System.out.println(record.ceiling(10L)); // 输出 10
//        System.out.println(record.ceiling(100L)); // 输出 null
//    }
}
