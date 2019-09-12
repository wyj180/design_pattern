package com.study.chazhaobiao;

import com.study.utils.MySortTestHelper;

import java.util.HashMap;
import java.util.Map;

// 给出四个整形数组A,B,C,D，寻找有多少i,j,k,l的组合，
// 使得A[i] + B[j] + C[k] + D[l]  == 0
public class TwoSumII {

    public static void main(String[] args) {
        int nums[] = {2,7,11,15};
        int target = 9;

        int[] ints = twoSum();
        MySortTestHelper.printArr(ints);
    }

    public static int[] twoSum() {
        int[] A = {};
        int[] B = {};
        int[] C = {};
        int[] D = {};

        // 第一步：求A[i] + B[j] 值的情况
        Map<Integer, Integer> tempMap = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int value = A[i] + B[j];
                if (tempMap.containsKey(value)) { // 查找成功的情况
                    tempMap.put(value, tempMap.get(value) + 1);
                } else {
                    tempMap.put(value, 1);
                }
            }
        }

        int result = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int value = -(A[i] + B[j]);
                if (tempMap.containsKey(value)) { // 查找成功的情况
                    result += tempMap.get(value);
                }
            }
        }

        System.out.println(" result = " + result);

        return null;
    }

}
