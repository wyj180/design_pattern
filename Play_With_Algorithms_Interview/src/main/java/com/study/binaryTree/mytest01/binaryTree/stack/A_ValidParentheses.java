package com.study.binaryTree.mytest01.binaryTree.stack;

import org.junit.Test;

import java.util.Stack;

// 判断字符串包含的括号是否合法
public class A_ValidParentheses {

    @Test
    public void test01() {
        String s = "()[]";
        System.out.println(isValid(s));
    }

    // 判断括号是否合法，使用Stack实现
    public boolean isValid(String source) {
        if (source == null || source.isEmpty()) {
            return false;
        }
        char[] chars = source.toCharArray();

        Stack<Character> stack = new Stack();

        for (char ch : chars) {
            if (ch == '{' || ch == '[' || ch == '(') {
                // 入栈
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                // 出栈
                if (ch == '}') {
                    if (stack.pop() != '{') {
                        return false;
                    }
                }
                if (ch == ')') {
                    if (stack.pop() != '(') {
                        return false;
                    }
                }
                if (ch == ']') {
                    if (stack.pop() != '[') {
                        return false;
                    }
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        }

        return false;
    }
}
