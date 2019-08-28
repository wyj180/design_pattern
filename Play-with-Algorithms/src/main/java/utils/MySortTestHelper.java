package utils;

import java.util.Arrays;
import java.util.Random;

// 工具类
public class MySortTestHelper {

    // 生成n个随机元素，范围[rangeL, rangeR]
    public static int[] generateRandomArray(int n, int rangeL, int rangeR) {
        int[] arr = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(n) % (rangeR - rangeL + 1) + rangeL;
        }
        return arr;
    }

    // 交换数组两个元素
    public static void swap(int[] arr, int i, int j) {
        if (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    // 打印数组
    public static void printArr(int[] arr) {
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
    }

    // 判断是否已经排好序
    public boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    // 复制一模一样的数组
    public static int[] copyIntArray(int[] arr) {
        int[] result = Arrays.copyOfRange(arr, 0, arr.length);
        return result;
    }

    // 生成近乎有序的数组
    public static int[] generateNearlyOrderedArray(int n, int swapTimes) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < swapTimes; i++) {
            int posx = getRandom(n) % n;
            int posy = getRandom(n) % n;
            swap(arr, posx, posy);
        }
        return arr;
    }

    public static int getRandom(int n) {
        Random random = new Random();
        return random.nextInt(n);
    }

    public static void main(String[] args) {
        int[] ints = generateNearlyOrderedArray(10, 1);
        printArr(ints);
    }
}
