package com.study.suzu;


import com.study.utils.MySortTestHelper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

// 题目：给出一个数组nums，将数组中的所有的0移到数组的末尾，维持其他非0元素的相对位置
// 示例 : nums = [0,1,0,3,12]; -> [1,3,12,0,0]
public class MoveZero01 {

    private int nums[] = {0, 1, 0, 3, 12};
//    private int nums[] = {1, 1, 3, 3, 12};


    // 三个for循环完成
    // 方法一：找出非0的元素，填充在数组前面，数组后面填写0即可
    // 总结：需要开辟额外的空间,可以使用List，三个for循环完成
    @Test
    public void test01() {
        List<Integer> temp = new ArrayList<>();
        // 找出非0元素
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                temp.add(nums[i]);
            }
        }

        for (int i = 0; i < temp.size(); i++) {
            nums[i] = temp.get(i);
        }

        for (int i = temp.size(); i < nums.length; i++) {
            nums[i] = 0;
        }

        MySortTestHelper.printArr(nums);
    }

    // 两个for循环完成，不需要开辟额外的空间，不交换元素位置
    @Test
    public void test02() {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            // 只要元素不为空，就做赋值操作
            if (nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }
        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }

        MySortTestHelper.printArr(nums);
    }

    // 一个for循环完成
    // 情况一：元素如果为0，此时i++，k不变
    // 情况二：元素不为0
    //          子情况一：i = k， 此时不做任何操作，i和k同时+1即可
    //          子情况二：i != k，此时交换数据，
    @Test
    public void test03() {
        int k = 0; // k索引指向0的位置
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != k) {
                    // 不为零情况，交换位置，通知i和k往后移动一位
                    MySortTestHelper.swap(nums, i, k++);
                } else {
                    // 全部都不为0的情况
                    k++;
                }
            }
        }
        MySortTestHelper.printArr(nums);
    }

}
