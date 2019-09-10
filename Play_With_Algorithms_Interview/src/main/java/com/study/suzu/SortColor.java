package com.study.suzu;

import com.study.utils.MySortTestHelper;
import org.junit.Test;

// 对于一个只有0,1,2元素的数组，为这个数组排序
public class SortColor {

    private int[] arr = {0, 1, 2, 1, 2, 1};

    // 方式一：分别找出0,1,2，的个数，放回去即可
    // 需要四个for循环
    @Test
    public void test01() {
        int len = arr.length;

        int[] count = new int[3];

        for (int i = 0; i < len; i++) {
            count[arr[i]] = count[arr[i]] + 1;
        }

        int index = 0;
        for (int i = 0; i < count[0]; i++) {
            arr[index++] = 0;
        }

        for (int i = 0; i < count[1]; i++) {
            arr[index++] = 1;
        }

        for (int i = 0; i < count[2]; i++) {
            arr[index++] = 2;
        }

        MySortTestHelper.printArr(arr);
    }

    // 使用三路快拍解决
    @Test
    public void test02() {
        int zero = -1;
        int two = arr.length;

        for (int i = 0; i < two; ) {
            if (arr[i] == 1) {
                i++;
            } else if (arr[i] == 0) {
                MySortTestHelper.swap(arr, ++zero, i++);
            } else if (arr[i] == 2) {
                MySortTestHelper.swap(arr, --two, i);
            }
        }

        MySortTestHelper.printArr(arr);
    }


}
