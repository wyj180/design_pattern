package com.study.binaryTree.mytest01.binaryTree.array;

import org.junit.Test;

import java.util.Arrays;

public class D_MinimumSizeSubarraySum {

	public static int[] minSubArrayLen(int s, int[] nums) {
		int left = 0, right = -1; // nums[left...right]为我们的滑动窗口 表示初始的窗口时候不包含任何元素
        // 我的思路：可以设置l = 0; right = 0; 这样sum = nums[0]; 一样可以实现
		int sum = 0; // 初始的时候，由于窗口不包含任何元素，所以和为0
		int res = nums.length + 1;

		int[] result = null;

		// l要取到最后一位
		while (left < nums.length) { // 窗口的左边界在数组范围内,则循环继续

			if (right + 1 < nums.length && sum < s)
				sum += nums[++right];
			else // r已经到头 或者 sum >= s
				sum -= nums[left++];

			if (sum >= s) {
				// 由于是前闭后闭区间，所以取值是r – left + 1
				if (res > (right - left + 1)) {
					result = Arrays.copyOfRange(nums, left, right + 1);
				}
				res = Math.min(res, right - left + 1);
			}
		}
		// 处理没有解的情况
		if (res == nums.length + 1)
			return null;

		return result;
	}

	public static void main(String[] args) {

		int[] nums = { 2, 3, 1, 2, 4, 3 };
		int s = 8;
		System.out.println(minSubArrayLen(s, nums));
	}

	// 暴力解法一：使用双重循环
	// 解法二：使用对撞指针
	@Test
	public void test01() {
		int[] nums = { 2, 7, 11, 15 };
		int findData = 18;

		int i = 0;
		int j = nums.length - 1;
		while (i < j) {
			int sum = nums[i] + nums[j];
			if (sum == findData) {
				break;
			} else if (sum < findData) {
				i++;
			} else { // sum > findData
				j--;
			}
		}
		System.out.println("i = " + i + "，j = " + j);
	}
}