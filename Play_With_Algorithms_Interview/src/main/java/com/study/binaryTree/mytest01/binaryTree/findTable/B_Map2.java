package com.study.binaryTree.mytest01.binaryTree.findTable;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 寻找两个数组的公共集合
 */
public class B_Map2 {

    @Test
    public void test01() {
        int[] num1 = {1, 2, 2, 1};
        int[] num2 = {2, 2};
        int[] union = findUnion(num1, num2);
        System.out.println(union);
    }

    public int[] findUnion(int[] num1, int[] num2) {

        Set<Integer> s1 = new HashSet<>();
        for (int ele : num1) {
            s1.add(ele);
        }

        List<Integer> s2 = new ArrayList<>();
        for (int e : num2) {
            if (s1.contains(e)) {
                s2.add(e);
            }
        }

        int[] reult = new int[s2.size()];
        int index = 0;
        for (Integer ele : s2) {
            reult[index++] = ele;
        }

        return reult;
    }
}
