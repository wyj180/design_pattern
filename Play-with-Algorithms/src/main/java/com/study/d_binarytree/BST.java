package com.study.d_binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BST<Key extends Comparable<Key>, Value> {

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            left = right = null;
        }
    }

    Node node; // 根节点
    int count; // 节点个数

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public Node insert(Node root, Key key, Value value) {
        // 递归结束条件
        if (root == null) {
            return new Node(key, value);
        }

        // 继续递归
        if (root.key.compareTo(key) == 0) {
            root.value = value;
        } else if (root.key.compareTo(key) > 0) {
            root.left = insert(root.left, key, value);
        } else {
            root.right = insert(root.right, key, value);
        }
        return root;
    }

    public boolean contain(Node root, Key key) {
        if (root == null) {
            return false;
        }

        if (root.key.compareTo(key) == 0) {
            return true;
        } else if (root.key.compareTo(key) > 0) {
            return contain(root.left, key);
        } else {
            return contain(root.right, key);
        }
    }

    public Node find(Node root, Key key) {
        if (root == null) {
            return null;
        }

        if (root.key.compareTo(key) == 0) {
            return root;
        } else if (root.key.compareTo(key) > 0) {
            return find(root.left, key);
        } else {
            return find(root.right, key);
        }
    }

    // 前序遍历
    public void preOrder(Node root) {
        if (root != null) {
            //访问当前节点
            System.out.println(root.key);
            // 访问左子树
            preOrder(root.left);
            // 访问右子树
            preOrder(root.right);
        }
    }


    // 中序遍历
    public void midOrder(Node root) {
        if (root != null) {
            // 访问左子树
            midOrder(root.left);
            //访问当前节点
            System.out.println(root.key);
            // 访问右子树
            midOrder(root.right);
        }
    }

    // 后序遍历
    public void lastOrder(Node root) {
        if (root != null) {
            // 访问左子树
            lastOrder(root.left);
            // 访问右子树
            lastOrder(root.right);
            //访问当前节点
            System.out.println(root.key);
        }
    }

    // 层序遍历，需要引入队列，这里使用LinkedList
    public void levelOrder(Node root) {

        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            // 取出队列元素
            Node node = queue.poll();
            System.out.println(node.key);

            // 同时将左右子树放入队列中
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    public Node min(Node root){
        if(root.left == null){
            return root;
        }
        return min(root.left);
    }

    public Node max(Node root){
        if(root.right == null){
            return root;
        }
        return max(root.left);
    }

    // 删除最小节点
    public Node removeMin(Node root) {
        if (root.left == null) {
            Node rightNode = root.right;
            root.right = null;
            count--;
            return rightNode;
        }
        root.left = removeMin(root);
        return root;
    }

    // 删除最大节点
    public Node removeMax(Node root) {
        if (root.right == null) {
            Node leftNode = root.left;
            root.left = null;
            count--;
            return leftNode;
        }
        root.right = removeMin(root);
        return root;
    }

    public Node remove(Node root, Key key) {
        // 跳出递归
        if (root == null) {
            return root;
        }

        // 寻找删除的元素
        if (root.key.compareTo(key) > 0) {
            root.left = remove(root.left, key);
            return root;
        } else if (root.key.compareTo(key) < 0) {
            root.right = remove(root.right, key);
            return root;
        } else {
            // 找打了该元素，进行删除操作

            // 左节点为空的删除
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                count--;
                return rightNode;
            }

            // 右节点为空的删除
            if (node.right == null) {
                Node leftNode = node.left;
                count--;
                node.left = null;
                return leftNode;
            }

            // 左右节点都不为空的删除
            Node rightMinNode = min(this.node);
            Node newNode = new Node(rightMinNode.key, rightMinNode.value);
            count++;
            newNode.left = node.left;
            newNode.right = removeMin(node.right);

            return newNode;
        }
    }

}
