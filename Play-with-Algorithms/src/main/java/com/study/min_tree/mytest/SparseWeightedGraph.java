package com.study.min_tree.mytest;

import java.util.Vector;

// 稀疏图 -- 邻接表
public class SparseWeightedGraph<Weight extends Number & Comparable> implements WeightedGraph {

    private int n; // 节点数
    private int m; // 边数
    private boolean directed; // 是否为有向图
    private Vector<Edge<Weight>>[] g; // 图的具体数据

    // 构造函数
    public SparseWeightedGraph(int n, boolean directed) {
        assert n >= 0;
        this.n = n;
        this.m = 0;
        this.directed = directed;
        g = new Vector[n];
        for (int i = 0; i < n; i++) {
            g[i] = new Vector<Edge<Weight>>();
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

        g[e.v()].add(new Edge<>(e));
        if (!directed) {
            g[e.w()].add(new Edge<>(e));
        }
        m++;
    }

    @Override
    public boolean hasEdge(int v, int w) {
        Vector<Edge<Weight>> edges = g[v];
        for (int i = 0; i < edges.size(); i++) {
            if (edges.get(i).other(v) == w) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void show() {
        for (int i = 0; i < n; i++) {
            System.out.print("vertex " + i + " : \t");
            for (int j = 0; j < g[i].size(); j++) {
                Edge<Weight> e = g[i].elementAt(j);
                System.out.print("( to:" + e.other(i) + ",wt:" + e.wt() + ")\t");
            }
            System.out.println();
        }
    }

    // 返回图中一个顶点的所有领边
    @Override
    public Iterable<Edge<Weight>> adj(int v) {
        assert v >= 0 && v < n;
        return g[v];
    }
}
