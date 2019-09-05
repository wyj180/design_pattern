package com.study.unionfind;

// 第一版的并查集
public class UnionFind1 {

    private int[] id; // 存储集合编号
    private int count;

    public UnionFind1(int n) {
        count = n;
        id = new int[n];
        // 初始化，让每一个id[i]指向自己，没有合并的情况
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    // 查看元素p和元素q是否属于同一个集合
    public boolean isConnect(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        int pId = id[p];
        int qId = id[q];

        if (pId == qId) {
            return;
        }

        for (int i = 0; i < count; i++) {
            if (id[i] == pId) {
                id[i] = qId;
            }
        }
    }

    // 查找元素p(下标p)所对应的集合编号
    public int find(int p) {
        if (p < 0 || p > count) {
            return -1;
        }
        return id[p];
    }

}
