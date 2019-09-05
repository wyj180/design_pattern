package com.study.unionfind;

// 第二版的并查集
public class UnionFind3 {

    private int[] parent;
    private int[] rank; // rank[i] 表示以i为根的集合所表示的树的层数
    private int count;

    public UnionFind3(int n) {
        count = n;
        parent = new int[n];
        rank = new int[n];
        // 初始化，让每一个id[i]指向自己，没有合并的情况
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    // 查看元素p和元素q是否属于同一个集合
    public boolean isConnect(int p, int q) {
        return parent[p] == parent[q];
    }

    public void union(int p, int q) {
        int pRoot = find(p); // 查找p的根节点
        int qRoot = find(q); // 查找q的根节点

        if (pRoot == qRoot) {
            return;
        }

        // 根据两个元素所在集合的元素个数判断合并方向
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[qRoot] < rank[pRoot]) {
            parent[qRoot] = qRoot;
        } else {
            // 层数相等的情况
            parent[pRoot] = qRoot;
            rank[qRoot] += 1;
        }
    }

    // 查找元素p(下标p)所对应的集合编号
    public int find(int p) {
        assert (p >= 0 && p < count);

        while (p != parent[p]) {
            parent[p] = parent[parent[p]]; // 路径压缩方式一
            p = parent[p];
        }
        return p;
    }

    // 查找元素p(下标p)所对应的集合编号
    public int find2(int p) {
        assert (p >= 0 && p < count);

        if (p != parent[p]) {
            parent[p] = find2(parent[p]); // 路径压缩方式二
        }
        return parent[p];
    }

}
