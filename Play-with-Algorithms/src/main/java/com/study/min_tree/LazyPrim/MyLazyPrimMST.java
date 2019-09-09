package com.study.min_tree.LazyPrim;

import java.util.Vector;

public class MyLazyPrimMST<Weight extends Number & Comparable> {

    private WeightedGraph<Weight> G; //图的引用
    private MinHeap<Edge<Weight>> pq; // 最小堆，算法辅助数据结构
    private boolean[] marked; // 标记数组

    private Vector<Edge<Weight>> mst; // 最小生成树所包含的所有边
    private Number mstWeight; //最小生成树的权值

    // 构造函数，使用Prim算法求图的最小生成树
    public MyLazyPrimMST(WeightedGraph<Weight> graph) {
        // 初始化
        G = graph;
        pq = new MinHeap<Edge<Weight>>(G.E());
        marked = new boolean[G.V()];
        mst = new Vector<Edge<Weight>>();

        // lazy Prim
        visit(0);
        while (!pq.isEmpty()) {
            Edge<Weight> weightEdge = pq.extractMin();
            if (marked[weightEdge.v()] == true && marked[weightEdge.w()] == true) {
                continue;
            }
            mst.add(weightEdge);

            if (!marked[weightEdge.v()]) {
                visit(weightEdge.v());
            } else {
                visit(weightEdge.w());
            }
        }

        // 最小生成树的权值
        mstWeight = mst.get(0).wt().doubleValue();
        for (int i = 1; i < mst.size(); i++) {
            mstWeight = mst.get(i).wt().doubleValue() + mstWeight.doubleValue();
        }
    }

    // 访问v这个元素，将和v连接的所有未访问的边放入堆中
    private void visit(int v) {
        // 如果该节点已经访问，结束
        if (marked[v]) {
            return;
        }
        // 设置节点v已经访问
        marked[v] = true;

        // 将节点v连接的边还没被访问(另一个节点还没被访问)，加入最小堆中
        for (Edge<Weight> ele : G.adj(v)) {
            if (!marked[ele.other(v)]) {
                pq.insert(ele);
            }
        }
    }

    // 返回最小生成树的所有边
    Vector<Edge<Weight>> mstEdges() {
        return mst;
    }

    Number result() {
        return mstWeight;
    }

}
