package com.hashtable;

import org.junit.Test;

// 面试题：给定一个字符串，找出它的第一个不重复的字符，并返回他的索引
public class InterviewQuestion {

    @Test
    public void test01() {
        String s = "loveleetcode";

        int[] record = new int[26];
        // 记录所有字符出现的次数
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            record[index]++;
        }

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (record[index] == 1) {
                System.out.println("result = " + i);
                break;
            }
        }
    }

    @Test
    public void test02() {
        int a = 'b' - 'a';
        char b1 = 'b';
        int c1 = b1 + 1;
        System.out.println("a = " + a);
        System.out.println("b = " + b1);
        System.out.println("b = " + c1);
        System.out.println((char) c1);
    }

    @Test
    public void test03() {
        int[] record = new int[26]; // 默认值都是0
        record[0]++;
        for (int i = 0; i < record.length; i++) {
            System.out.println(record[i]);
        }
    }

    @Test
    public void test04() {
        Integer[] record = new Integer[26]; // 默认值都是null
        for (int i = 0; i < record.length; i++) {
            System.out.println(record[i]);
        }
    }

}
