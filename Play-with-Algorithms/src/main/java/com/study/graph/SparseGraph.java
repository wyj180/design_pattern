package com.study.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

// 稀疏图 -- 用邻接表表示
public class SparseGraph {

    private int n; // 节点数
    private int m; // 边数
    private boolean directed; // 是否为有向图
    private List<List<Integer>> g; // 图的具体数据

    public SparseGraph(int n, boolean directed) {
        this.n = n;
        this.m = 0;
        this.directed = directed; // 初始化为n * n的布尔矩阵，每一项默认值为false，表示没有任何边
        this.g = new ArrayList<>();
    }

    // 向图中添加一个边
    public void addEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;

        // 如果已经有变，则不再添加
        if (hasEdge(v, w)) {
            return;
        }
        // 添加边
        g.get(v).add(w);
        // 无向图的话，则添加另一条边
        if (!directed) {
            g.get(w).add(v);
        }
        // 边的数量+1
        m++;
    }

    // 验证图中是否有从v到w的边
    public boolean hasEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;
        List<Integer> edges = g.get(v);
        for (Integer edge : edges) {
            if (edge == w) {
                return true;
            }
        }
        return false;
    }

    // 获取元素个数
    public int V() {
        return n;
    }

    public Iterable<Integer> adj(int v) {
        assert v >= 0 && v < n;
        List<Integer> integers = g.get(v);
        return integers;
    }

    public void show() {
        for (int i = 0; i < n; i++) {
            System.out.println("vertex " + i + "\t");
            for (int j = 0; j < g.get(i).size(); j++) {
                System.out.print(g.get(i).get(j) + "\t");
            }
            System.out.println();
        }
    }

}
