package com.study.min_tree.LazyPrim;

import java.util.Vector;

public class Main {

    public static void main(String[] args) {

        String filename = "D:\\testDir\\3_suanfa\\testG1.txt";
        int V = 8;

        SparseWeightedGraph<Double> g = new SparseWeightedGraph<Double>(V, false);
        ReadWeightedGraph readGraph = new ReadWeightedGraph(g, filename);

        // Test Lazy Prim MST
        System.out.println("Test Lazy Prim MST:");
        MyLazyPrimMST<Double> lazyPrimMST = new MyLazyPrimMST<Double>(g);
        Vector<Edge<Double>> mst = lazyPrimMST.mstEdges();
        for (int i = 0; i < mst.size(); i++) {
            System.out.println(mst.elementAt(i));
            System.out.println("The MST weight is: " + lazyPrimMST.result());
        }

        System.out.println();
    }
}
