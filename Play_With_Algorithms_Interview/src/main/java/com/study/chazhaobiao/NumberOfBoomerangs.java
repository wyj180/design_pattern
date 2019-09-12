package com.study.chazhaobiao;

import java.util.HashMap;
import java.util.Map;

public class NumberOfBoomerangs {

    public static void main(String[] args) {
        int[][] points = new int[3][2];
        int[] a = {0, 0};
        int[] b = {1, 0};
        int[] c = {2, 0};

        points[0] = a;
        points[1] = a;
        points[2] = a;

        int i = numberOfBoomerangs(points);

    }

    public static int numberOfBoomerangs(int[][] points) {
        int result = 0;

        Map<Integer, Integer> record = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    int dis = distance(points[i], points[j]);
                    if (record.containsKey(dis)) {
                        record.put(dis, record.get(dis) + 1);
                    } else {
                        record.put(dis, 1);
                    }
                }
            }
        }

        // 记录有多少方式，涉及到组合排列
        for(Integer dis : record.keySet()){
            result += record.get(dis) * (record.get(dis) - 1);
        }

        System.out.println("result = " + result);
        return result;
    }

    private static int distance(int[] a, int[] b) {
        return (b[0] - a[0]) * (b[0] - a[0]) + (b[1] - a[1]) * (b[1] - a[1]);
    }

}
