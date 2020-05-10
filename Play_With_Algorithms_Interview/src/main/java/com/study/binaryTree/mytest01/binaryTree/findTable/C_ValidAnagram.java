package com.study.binaryTree.mytest01.binaryTree.findTable;

import org.junit.Test;

import java.util.Arrays;

/**
 * 判断字符串t是否是字符串s变换字符顺序后得到的结果
 */
public class C_ValidAnagram {

    @Test
    public void test01() {
        String num1 = "abc";
        String num2 = "bac";
        boolean result = valid(num1, num2);
        System.out.println(result);
    }

    public boolean valid(String s1, String s2) {

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        Arrays.sort(c1);
        Arrays.sort(c2);

        String s11 = new String(c1);
        String s22 = new String(c2);

        return s11.equals(s22);
    }
}
