package com.study.binaryTree.mytest01.binaryTree.findTable;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 给出一个整形数组A 问是否存在索引i和j，使得A[i] == A[j] 且i和j之间的差不超过k
 * <p>
 * 思路：使用Set当做滑动窗口，set存储的值，就是滑动窗口内的值，size滑动窗口的大小
 */
public class F_ContainsDuplicateNum {

    @Test
    public void test01() {
        int[] A = {2, 7,2,2};
        boolean result = containsDuplicateNum(A, 1);
        System.out.println(result);
    }

    public boolean containsDuplicateNum(int[] A, int k) {

        // 滑动窗口
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            int e = A[i];
            if (set.contains(e)) {
                return true;
            } else {
                set.add(e);
                // 维护滑动窗口大小
                if(set.size() == k + 1){
                    set.remove(A[i - k]);
                }
            }
        }

        return false;
    }
}
