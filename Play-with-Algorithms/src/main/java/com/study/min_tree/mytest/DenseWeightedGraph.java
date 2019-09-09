package com.study.min_tree.mytest;

import java.util.Vector;

// 稠密图 -- 邻接矩阵
public class DenseWeightedGraph<Weight extends Number & Comparable> implements WeightedGraph {

    private int n; // 节点数
    private int m; // 边数
    private boolean directed; // 是否为有向图
    private Edge<Weight>[][] g; // 图的具体数据

    // 构造函数
    public DenseWeightedGraph(int n, boolean directed) {
        assert n >= 0;
        this.n = n;
        this.m = 0;

        g = new Edge[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = null;
            }
        }
    }

    // 节点个数
    @Override
    public int V() {
        return n;
    }

    @Override
    public int E() {
        // 边的个数
        return m;
    }

    // 向图中添加一条边
    @Override
    public void addEdge(Edge e) {
        if (hasEdge(e.v(), e.w())) {
            return;
        }

        g[e.v()][e.w()] = new Edge<>(e);
        if (!directed) {
            g[e.w()][e.v()] = new Edge<>(e);
        }
        m++;
    }

    @Override
    public boolean hasEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;
        return g[v][w] != null;
    }

    @Override
    public void show() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] != null) {
                    System.out.println(g[i][j] + "\t");
                } else {
                    System.out.print("NULL\t");
                }
            }
            System.out.println();
        }
    }

    // 返回图中一个顶点的所有领边
    @Override
    public Iterable<Edge<Weight>> adj(int v) {
        assert v >= 0 && v < n;
        Vector<Edge<Weight>> adjV = new Vector<>();
        for (int i = 0; i < n; i++) {
            if (g[v][i] != null) {
                adjV.add(g[v][i]);
            }
        }
        return adjV;
    }
}
