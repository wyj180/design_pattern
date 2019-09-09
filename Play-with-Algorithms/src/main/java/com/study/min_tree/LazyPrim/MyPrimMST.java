package com.study.min_tree.LazyPrim;


import java.util.Vector;

    // 使用Prim算法求图的最小生成树
    public class MyPrimMST<Weight extends Number & Comparable> {

        private WeightedGraph<Weight> G;    // 图的引用
        private IndexMinHeap<Weight> ipq;   // 最小索引堆, 算法辅助数据结构
        private Edge<Weight>[] edged;           // 辅助数据结构
        private boolean[] marked;           // 辅助数据结构
        private Vector<Edge<Weight>> mst;   // 最小生成树所包含的所有边
        private Number mstWeight;           // 最小生成树的权值

        // 构造函数, 使用Prim算法求图的最小生成树
        public MyPrimMST(WeightedGraph<Weight> graph) {

            // 算法初始化
            G = graph;
            ipq = new IndexMinHeap<Weight>(G.E());
            edged = new Edge[G.V()];
            marked = new boolean[G.V()];
            mst = new Vector<Edge<Weight>>();

            // Lazy Prim
            visit(0);
            while (!ipq.isEmpty()) {
                // 使用最小堆找出已经访问的边中权值最小的边
                int v = ipq.extractMinIndex();
                if (edged[v] != null) {
                    mst.add(edged[v]);
                    visit(v);
                }
            }

            // 计算最小生成树的权值
            mstWeight = mst.elementAt(0).wt();
            for (int i = 1; i < mst.size(); i++) {
                mstWeight = mstWeight.doubleValue() + mst.elementAt(i).wt().doubleValue();
            }
        }

    // 访问节点v
    private void visit(int v){

        assert !marked[v];
        marked[v] = true;

        // 将和节点v相连接的所有未访问的边放入最小堆中
        for (Edge<Weight> e : G.adj(v)) {
            int w = e.other(v);
            if (!marked[w]) { // 判断另一个边是否已经被访问，如果没有，则直接加入堆中
                if (edged[w] == null) { // 如果从没有考虑过这个节点，则直接加入堆和辅助函数中
                    edged[w] = e;
                    ipq.insert(w, e.wt());
                } else if (e.wt().compareTo(edged[w].wt()) < 0) { // 如果曾经考虑过这个节点，且现在的边权值比之前的小，则直接替换
                    edged[w] = e;
                    ipq.change(w, e.wt());
                }
            }
        }
    }

    // 返回最小生成树的所有边
    Vector<Edge<Weight>> mstEdges(){
        return mst;
    };

    // 返回最小生成树的权值
    Number result(){
        return mstWeight;
    };
}
