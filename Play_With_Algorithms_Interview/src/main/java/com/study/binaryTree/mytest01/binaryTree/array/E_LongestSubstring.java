package com.study.binaryTree.mytest01.binaryTree.array;

/**
 * 最长子串
 * 解题思路：使用滑动窗口
 */
public class E_LongestSubstring {

    public static String lengthOfLongestSubstring(String s) {

        int[] freq = new int[256];

        int left = 0, right = -1; // 滑动窗口为s[left...right]
        int res = 0;
        String result = null;

        // 整个循环从 left == 0; right == -1 这个空窗口开始
        // 到l == s.size(); right == s.size()-1 这个空窗口截止
        // 在每次循环里逐渐改变窗口, 维护freq, 并记录当前窗口中是否找到了一个新的最优值
        while ((right + 1) < s.length()) {
            // freq[s.charAt(right + 1)] == 0表示r右边的第一个元素还没被访问过
            if (right + 1 < s.length() && freq[s.charAt(right + 1)] == 0)
                freq[s.charAt(++right)] = 1;
            else // freq[s[right+1]] == 1
                freq[s.charAt(left++)] = 0;

            // 记录最长子串
            if (res < (right - left + 1)) {
                result = s.substring(left, right + 1);
            }
            res = Math.max(res, right - left + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // 输出 abc
        System.out.println(lengthOfLongestSubstring("bbbbb")); // b
        System.out.println(lengthOfLongestSubstring("bbbbbabc")); // abc
        System.out.println(lengthOfLongestSubstring("pwwkew")); // wke
        System.out.println(lengthOfLongestSubstring("")); // null
    }
}
