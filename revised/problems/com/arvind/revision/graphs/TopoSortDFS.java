package com.arvind.revision.graphs;

import com.arvind.revision.common.CommonUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopoSortDFS {

    List<Integer> topoSort(int V, List<List<Integer>> graph) {
        List<Integer> res = new ArrayList<>();
        int[] visited = new int[V];
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<V; i++) {
            if (visited[i] == 0) {
                dfs(i, graph, visited, stack);
            }
        }
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }

    private void dfs(int i, List<List<Integer>> graph, int[] visited, Stack<Integer> stack) {

        if (visited[i] == 1) return;
        visited[i] = 1;
        for (int neighbor : graph.get(i)) {
            dfs(neighbor, graph, visited, stack);
        }
        stack.push(i);
    }

    public static void main(String[] args) {
        TopoSortDFS solution = new TopoSortDFS();

        int[][][] testEdges = {
                {{5, 0}, {5, 2}, {4, 0}, {4, 1}, {2, 3}, {3, 1}},
                {{0, 1}, {1, 2}, {2, 3}},
                {{0, 1}, {2, 3}},
                {},
                {{0, 1}, {0, 2}, {1, 3}, {2, 3}},
                {}
        };
        int[] vertices = {6, 4, 5, 4, 4, 1};
        String[] names = {
                "sample DAG",
                "linear dependency chain",
                "disconnected DAG",
                "multiple isolated vertices",
                "diamond dependencies",
                "single vertex"
        };

        for (int test = 0; test < testEdges.length; test++) {
            int V = vertices[test];
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                graph.add(new ArrayList<>());
            }
            for (int[] edge : testEdges[test]) {
                graph.get(edge[0]).add(edge[1]);
            }

            List<Integer> order = solution.topoSort(V, graph);
            int[] position = new int[V];
            boolean[] present = new boolean[V];
            boolean valid = order.size() == V;

            for (int index = 0; index < order.size(); index++) {
                int node = order.get(index);
                if (node < 0 || node >= V || present[node]) {
                    valid = false;
                } else {
                    present[node] = true;
                    position[node] = index;
                }
            }
            for (boolean found : present) {
                valid &= found;
            }
            for (int[] edge : testEdges[test]) {
                valid &= position[edge[0]] < position[edge[1]];
            }

            String result = valid ? "✅ PASS" : "❌ FAIL";
            System.out.printf("%s | %-27s | order=%s%n", result, names[test], order);
        }
    }
}
