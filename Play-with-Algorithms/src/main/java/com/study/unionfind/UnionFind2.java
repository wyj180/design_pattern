package com.study.unionfind;

// 第二版的并查集
public class UnionFind2 {

    private int[] parent;
    private int[] sz; // sz[i] 表示以i为根的集合中元素个数
    private int count;

    public UnionFind2(int n) {
        count = n;
        parent = new int[n];
        sz = new int[n];
        // 初始化，让每一个id[i]指向自己，没有合并的情况
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            sz[i] = 1;
        }
    }

    // 查看元素p和元素q是否属于同一个集合
    public boolean isConnect(int p, int q) {
        return parent[p] == parent[q];
    }

    public void union(int p, int q) {
        int pParent = find(p); // 查找p的根节点
        int qParent = find(q); // 查找q的根节点

        if (pParent == qParent) {
            return;
        }

        // 根据两个元素所在集合的元素个数判断合并方向
        if (sz[pParent] < sz[qParent]) {
            parent[pParent] = qParent;
            sz[qParent] += sz[pParent];
        } else {
            parent[qParent] = parent[pParent];
            sz[pParent] += sz[qParent];
        }
    }

    // 查找元素p(下标p)所对应的集合编号
    public int find(int p) {
        if (p < 0 || p > count) {
            return -1;
        }

        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

}
