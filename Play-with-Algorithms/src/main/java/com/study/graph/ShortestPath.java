package com.study.graph;


import java.util.*;

// 寻路
public class ShortestPath {

    private DenseGraph G; // 图的引用
    private int s; // 起始点
    private boolean[] vivited; // 记录dfs过程中节点是否被访问
    private int[] from; // 记录路径from[i]表示查找的路径的上i的上一个节点
    private int[] ord; // 路径中的次序

    public ShortestPath(DenseGraph graph, int s) {
        G = graph;
        assert s >= 0 && s < G.V();

        vivited = new boolean[G.V()];
        from = new int[G.V()];
        this.s = s;
        for (int i = 0; i < G.V(); i++) {
            vivited[i] = false;
            from[i] = -1;
        }

        // 层序遍历
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        ord[s] = 0;
        vivited[s] = true;

        while (!queue.isEmpty()) {
            Integer v = queue.remove();
            List<Integer> adj = G.adj(v);
            for (Integer ele : adj) {
                if (!vivited[ele]) {
                    queue.offer(ele);
                    vivited[ele] = true;
                    ord[ele] = ord[v] + 1;
                    from[ele] = v;
                }
            }
        }
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

    // 查看从s点到w点的最短路径长度，若s到w不可达，返回-1
    public int length(int w) {
        assert w >= 0 && w < G.V();
        return ord[w];
    }

}
