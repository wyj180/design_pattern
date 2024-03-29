package com.study.min_tree.LazyPrim;

interface WeightedGraph<Weight extends Number & Comparable> {
    public int V();

    public int E();

    public void addEdge(Edge<Weight> e);

    boolean hasEdge(int v, int w);

    void show();

    public Iterable<Edge<Weight>> adj(int v);
}
