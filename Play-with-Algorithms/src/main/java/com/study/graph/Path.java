package com.study.graph;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 寻路
public class Path {

    private DenseGraph G; // 图的引用
    private int s; // 起始点
    private boolean[] vivited; // 记录dfs过程中节点是否被访问
    private int[] from; // 记录路径from[i]表示查找的路径的上i的上一个节点

    // 图的深度优先遍历
    public void dfs(int v) {
        vivited[v] = true;
        for (int i : G.adj(v)) {
            if (!vivited[i]) {
                from[i] = v;
                dfs(i);
            }
        }
    }

    public Path(DenseGraph graph, int s){
        G = graph;
        assert  s >= 0 && s < G.V();

        vivited = new boolean[G.V()];
        from = new int[G.V()];
        this.s = s;
        for (int i = 0; i < G.V(); i++) {
            vivited[i] = false;
            from[i] = -1;
        }

        dfs(s);
    }

    public boolean hasPath(int w) {
        assert w >= 0 && w < G.V();
        return vivited[w];
    }

    public List<Integer> path(int w) {
        hasPath(w);

        int p = w;
        Stack<Integer> stack = new Stack<>();

        while (p != -1) {
            stack.push(p);
            p = from[p];
        }

        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }

    public void showPath(int w) {
        assert hasPath(w);

        List<Integer> path = path(w);
        for (int i = 0; i < path.size(); i++) {
            System.out.println(path.get(i));
            if (i != path.size() - 1) {
                System.out.println(" -> ");
            }
        }
    }


}
