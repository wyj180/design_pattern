package com.study.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

// 稠密图 -- 用邻接矩阵表示
public class DenseGraph {

    private int n; // 节点数
    private int m; // 边数
    private boolean directed; // 是否为有向图
    private boolean[][] g; // 图的具体数据

    public DenseGraph(int n, boolean directed) {
        this.n = n;
        this.m = 0;
        this.directed = directed; // 初始化为n * n的布尔矩阵，每一项默认值为false，表示没有任何边
        this.g = new boolean[n][n];
    }

    // 向图中添加一个边
    public void addEdge(int v, int w) {
        // 如果已经有变，则不再添加
        if (hasEdge(v, w)) {
            return;
        }
        // 添加边
        g[v][w] = true;
        // 无向图的话，则添加另一条边
        if (!directed) {
            g[w][v] = true;
        }
        // 边的数量+1
        m++;
    }

    // 验证图中是否有从v到w的边
    public boolean hasEdge(int v, int w) {
        return g[v][w];
    }

    // 返回图中一个顶点的所有邻边
    public List<Integer> adj(int v) {
        assert v >= 0 && v < n;
        List<Integer> adjv = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (g[v][i]) {
                adjv.add(i);
            }
        }
        return adjv;
    }

    // 获取元素个数
    public int V() {
        return n;
    }

    public void show() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(g[i][j] + "\t");
            }
            System.out.println();
        }
    }

}
