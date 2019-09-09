package com.study.min_tree.kruskal;

import com.study.min_tree.LazyPrim.Edge;
import com.study.min_tree.LazyPrim.MinHeap;
import com.study.min_tree.mytest.WeightedGraph;

import java.util.Vector;

// Kruskal算法求最小生产树
public class MyKruskalMST<Weight extends Number & Comparable> {

    private Vector<Edge<Weight>> mst; // 最小生产数包含的所有边
    private Number mstWeight; // 最小生成树的权值

    public MyKruskalMST(WeightedGraph graph) {
        mst = new Vector<>();

        // 使用堆排序将所有的边排序好
        MinHeap<Edge<Weight>> pq = new MinHeap<>(graph.E());
        for (int i = 0; i < graph.V(); i++) {
            for (Object item : graph.adj(i)) {
                Edge<Weight> e = (Edge<Weight>) item;
                pq.insert(e);
            }
        }

        // 创建一个并查集，来查看已经访问的节点的联通情况
        UnionFind uf = new UnionFind(graph.V());
        while (!pq.isEmpty() && mst.size() < graph.V() - 1) {
            Edge<Weight> e = pq.extractMin(); // 从堆中从小到大依次取出所有的边
            // 如果该边的两个端点是联通的，说明加入这条边将产生环，扔掉这条边
            if (uf.isConnected(e.v(), e.w())) {
                continue;
            }
            // 否则，将这条边加入最小生成树中，并标记这两个端点联通
            mst.add(e);
            uf.unionElements(e.v(), e.w());
        }
    }

}
