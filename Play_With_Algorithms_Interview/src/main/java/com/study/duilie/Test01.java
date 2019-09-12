package com.study.duilie;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Stack;

public class Test01 {

    // 判断括号是否成对
    @Test
    public void test01() {
        String s = "{()}";
        char[] chars = s.toCharArray();

        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch == '{' || ch == '[' || ch == '(') { // 入站操作
                stack.push(ch);
            } else { // 出站操作
                if (stack.isEmpty()) {
                    System.out.println("失败");
                    return;
                }
                Character head = stack.pop();
                if (ch == '}') {
                    if (head != '{') {
                        System.out.println("失败");
                        return;
                    }
                } else if (ch == ')') {
                    if (head != '(') {
                        System.out.println("失败");
                        return;
                    }
                } else if (ch == ']') {
                    if (head != '[') {
                        System.out.println("失败");
                        return;
                    }
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println("有序对");
        }
    }
}
