package com.study.duilie;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 使用栈模拟递归
public class StackMoliRecursion {

    private class Command {
        String s; // go或print
        TreeNode node;

        public Command(String s, TreeNode node) {
            this.s = s;
            this.node = node;
        }
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    @Test
    public void test01() {

        TreeNode head = null;

        Stack<Command> stack = new Stack<>();
        stack.push(new Command("go", head));

        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            Command com = stack.pop();

            if (com.s.equals("print")) {
                result.add(com.node.val);
            } else {
                if (com.node.right != null) {
                    stack.push(new Command("go", com.node.right));
                }
                if (com.node.left != null) {
                    stack.push(new Command("go", com.node.left));
                }
                // 访问当前节点
                stack.push(new Command("print", com.node));
            }
        }

    }

}
