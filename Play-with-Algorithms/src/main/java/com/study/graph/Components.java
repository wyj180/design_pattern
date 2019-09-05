package com.study.graph;

import java.util.List;

// 无权图的联通分量
public class Components {

    private DenseGraph graph;
    private boolean[] visited; // 记录元素是否已经被访问
    private int count; // 记录联通分量个数
    private int[] id; // 每个元素的联通分量id标记

    public Components(DenseGraph graph) {
        // 初始化
        graph = graph;
        int v = graph.V(); // 元素个数
        id = new int[v];
        visited = new boolean[v];
        count = 0;
        for (int i = 0; i < v; i++) {
            id[i] = -1;
            visited[i] = false;
        }

        // 求联通分量
        for (int i = 0; i < v; i++) {
            // 每个联通分量只便利一次
            if(!visited[i]){
                adj(i);
                count++;
            }
        }
    }

    // 一次深度遍历，会遍历一个联通分量的所有元素
    public void adj(int v) {
        visited[v] = true;
        id[v] = count;
        List<Integer> adj = graph.adj(v);
        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i]) {
                adj(v);
            }
        }
    }

    // 返回图中联通分量个数
    public int count(){
        return count;
    }

    // 查询点v和点w是否联通
    public boolean isConnected(int v, int w) {
        return id[v] == id[w];
    }

}












