package com.study.chazhaobiao;

import com.study.utils.MySortTestHelper;
import org.junit.Test;

import java.util.*;

// 查找两个数组的公共元素
public class IntersectionOfTwoArrays {

    // set的使用
    @Test
    public void test01() {
        int[] arr1 = {1, 2, 2, 1};
        int[] arr2 = {2, 2};

        Set<Integer> record = new HashSet<>();
        for (int ele : arr1) {
            record.add(ele);
        }

        Set<Integer> resultSet = new HashSet<>();
        for (int ele : arr2) {
            if (record.contains(ele)) {
                resultSet.add(ele);
            }
        }

        int[] res = new int[resultSet.size()];
        int index = 0;
        for (int ele : resultSet) {
            res[index++] = ele;
        }
        MySortTestHelper.printArr(res);
    }

    // map的使用
    @Test
    public void test02() {
        int[] arr1 = {1, 2, 2, 1};
        int[] arr2 = {2, 2};

        Map<Integer, Integer> record = new TreeMap<>();
        for (int ele : arr1) {
            if (!record.containsKey(ele)) {
                record.put(ele, 1);
            } else {
                record.put(ele, record.get(ele) + 1);
            }
        }

        List<Integer> resultSet = new ArrayList<>();
        for (int ele : arr2) {
            if (record.containsKey(ele)) {
                resultSet.add(ele);
            }
        }

        int[] res = new int[resultSet.size()];
        int index = 0;
        for (int ele : resultSet) {
            res[index++] = ele;
        }
        MySortTestHelper.printArr(res);
    }

    @Test
    public void test03() {
        String s1 = "abc";
        String s2 = "abc4";

        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        String re1 = new String(chars1);
        String re2 = new String(chars2);

        System.out.println(re1.equals(re2));
    }

}
