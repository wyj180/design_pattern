package com.study.suzu;

import org.junit.Test;

// 在字符串中查找最长子串
public class LongestSubstring {

    String s = "bbb";

    @Test
    public void test02(){
        int[] seq = new int[256];
        char c = s.charAt(0);
        System.out.println(c);
    }

    @Test
    public void test01(){
        int len = s.length();

        int left = 0, right = 0;

        int l = 0, r = -1;
        int res = 0;
        int[] seq = new int[256];

        while (l < len) {
            if (r + 1 < len && seq[s.charAt(r + 1)] == 0) {
                seq[s.charAt(r + 1)] = 1;
                r ++;
            } else {
                seq[s.charAt(l++)] = 0;
            }

            // 比较大小
            if(res < (r - l + 1)){
                res = r - l + 1;
                left = l;
                right = r;
            }
        }
        System.out.println(s.substring(left, right + 1));
    }
}
