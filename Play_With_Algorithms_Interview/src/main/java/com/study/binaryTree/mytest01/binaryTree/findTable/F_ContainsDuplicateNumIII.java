package com.study.binaryTree.mytest01.binaryTree.findTable;

import org.junit.Test;

import java.util.TreeSet;

/**
 * 给出一个整形数组A 问是否存在索引i和j，使得A[i] == A[j] 且i和j之间的差不超过k
 * <p>
 * 思路：使用Set当做滑动窗口，set存储的值，就是滑动窗口内的值，size滑动窗口的大小
 */
public class F_ContainsDuplicateNumIII {

    @Test
    public void test01() {
        int[] A = {5, 1, -4};
        boolean result = containsNearbyAlmostDuplicate(A, 2, 2);
        System.out.println(result);
    }

    // TreeSet的ceiling()
// 返回此集合中的最小元素大于或等于给定元素，或者如果没有此类元素，则为null
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // 这个问题的测试数据在使用int进行加减运算时会溢出
        // 所以使用long long
        TreeSet<Integer> record = new TreeSet<>();
        for (int j = 0; j < nums.length; j++) {
            Integer dis = record.ceiling(nums[j] - t); // v就是nums[]
// 我的理解，红色部分是多余的，待验证  (再次理解，不需要写，但是最好写上)
            //if (dis != null && dis <= nums[j] + t) {  // 波波老师的答案 (我怀疑有错误)
             if (dis != null && nums[j] -  dis <= t) { // 我的答案
                return true;
            } else {
                record.add(nums[j]);

                if (record.size() == k + 1) { // 维护一个长度为k的滑动窗口
// 注意：如果k=2，表示的是滑动窗口中的元素个数为3,当元素个数到达3时，需要做滑动操作
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
