package com.study.shortestpath;

import com.study.min_tree.LazyPrim.IndexMinHeap;
import com.study.min_tree.mytest.Edge;
import com.study.min_tree.mytest.WeightedGraph;

import java.util.Stack;
import java.util.Vector;

public class MyDijkstra<Weight extends Number & Comparable> {

    private WeightedGraph G; // 图的引用
    private int s; // 起始点
    private Number[] distTo; // distTo[i]存储从起始点s到i的最短路径长度
    private boolean[] marked; // 标记元素i在是否已经被访问
    private Edge<Weight>[] from; // from[i] 记录最短路径中，到达i点的边是哪一条

    // 构造函数，使用Dijkstra算法求最短路径
    public MyDijkstra(WeightedGraph graph, int s) {
        this.s = s;
        this.G = graph;
        distTo = new Number[G.V()];
        marked = new boolean[G.V()];
        from = new Edge[G.V()];

        // 使用索引堆记录当前找到的到达每个顶点的最短距离
        IndexMinHeap<Weight> ipq = new IndexMinHeap<>(G.V());

        // 初始化起始点
        distTo[s] = 0.0;
        from[s] = new Edge(s, s, (Number) 0.0);
        marked[s] = true;
        ipq.insert(s, (Weight) distTo[s]);
        // 使用Dijkstral计算最短路径
        while (!ipq.isEmpty()) {
            int v = ipq.extractMinIndex();
            marked[v] = true;
            for (Object item : G.adj(v)) {
                Edge<Weight> e = (Edge<Weight>) item;
                int w = e.other(v);
                if (!marked[w]) {
                    if (from[w] == null || distTo[v].doubleValue() + e.wt().doubleValue() < distTo[e.w()].doubleValue()) {
                        distTo[w] = distTo[v].doubleValue() + e.wt().doubleValue();
                        if (ipq.contain(w)) {
                            ipq.change(w, (Weight) distTo[w]);
                        } else {
                            ipq.insert(w, (Weight) distTo[w]);
                        }
                    }
                }
            }
        }
    }

    public Number shortestPathTo(int w) {
        return distTo[w];
    }

    boolean hasPathTo(int w) {
        return marked[w];
    }

    public Vector<Edge<Weight>> shortestPath(int w) {
        Stack<Edge<Weight>> s = new Stack<>();
        Edge<Weight> e = from[w];
        while (e.v() != this.s) {
            s.push(e);
            e = from[e.v()];
        }
        s.push(e);

        Vector<Edge<Weight>> res = new Vector<>();
        while (!s.empty()) {
            res.add(s.pop());
        }
        return res;
    }

}
