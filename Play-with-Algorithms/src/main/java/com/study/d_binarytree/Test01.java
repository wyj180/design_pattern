package com.study.d_binarytree;

/**
 * 二分查找法
 */
public class Test01 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int v = 7;

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == v) {
                System.out.println("查找成功");
                return;
            } else if (arr[mid] < v) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("查找失败");
    }
}
