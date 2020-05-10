package com.study.binaryTree.mytest01.binaryTree.findTable;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 给出四个整形数组A,B,C,D 寻找有多少i,j,k,l组合，使得A[i] + B[j] + C[k] + D[j] == 0
 */
public class E_FourCountNum {

    @Test
    public void test01() {
        int[] A = {2, 7};
        int[] B = {2, 7};
        int[] C = {-2, -7};
        int[] D = {-2, -7};
        int result = fourCountNum(A, B, C, D);
        System.out.println(result);
    }

    public int fourCountNum(int[] A, int[] B, int[] C, int[] D) {
        int result = 0;

        Map<Integer, Integer> sumMap = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                int sum = a + b;
                if (sumMap.containsKey(sum)) {
                    sumMap.put(sum, sumMap.get(sum) + 1);
                } else {
                    sumMap.put(sum, 1);
                }
            }
        }

        for (int c : C) {
            for (int d : D) {
                int sum = -(c + d);
                if (sumMap.containsKey(sum)) {
                    result += sumMap.get(sum);
                }
            }
        }

        return result;
    }
}
