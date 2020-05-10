package com.study.binaryTree.mytest01.binaryTree.stack;

import com.study.binaryTree.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Command {
    String s;
    public TreeNode<Integer> treeNode;

    public Command(String s, TreeNode<Integer> treeNode) {
        this.s = s;
        this.treeNode = treeNode;
    }
}

public class B_StackToDiGui {

    TreeNode<Integer> node1 = new TreeNode<Integer>(2);
    TreeNode<Integer> node2 = new TreeNode<Integer>(1);
    TreeNode<Integer> node3 = new TreeNode<Integer>(3);

    {
        node1.left = node2;
        node1.right = node3;
    }

    @Test
    public void test01(){
        List<Integer> result = preOrder2(node1);
        System.out.println(result);
    }

    /**
     * 使用递归实现前序遍历
     */
    public void preOrder(TreeNode treeNode) {
        if (treeNode != null) {
            System.out.print(treeNode.t + " ");
            preOrder(treeNode.left);
            preOrder(treeNode.right);
        }
    }

    /**
     * 使用非递归实现前序遍历
     */
    public List<Integer> preOrder2(TreeNode treeNode) {
        List<Integer> result = new ArrayList<>();

        if (treeNode == null) {
            return null;
        }

        Stack<Command> stack = new Stack<>();
        stack.add(new Command("go", treeNode));

        while (!stack.isEmpty()) {

            Command com = stack.pop();

            if (com.s.equals("print")) {
                result.add(com.treeNode.t);
            } else {
                // 后序遍历
                stack.push(new Command("print", com.treeNode));
                if (com.treeNode.right != null) {
                    stack.push(new Command("go", com.treeNode.right));
                }
                // 中序
                if (com.treeNode.left != null) {
                    stack.push(new Command("go", com.treeNode.left));
                }
                // 前序
            }
        }

        return result;
    }

}
