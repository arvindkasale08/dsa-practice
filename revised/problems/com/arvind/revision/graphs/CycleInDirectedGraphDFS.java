package com.arvind.revision.graphs;

import java.util.ArrayList;
import java.util.List;

public class CycleInDirectedGraphDFS {

    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, List<List<Integer>> graph) {
        int[] visited = new int[V+1];
        int[] pathVisited = new int[V+1];

        for (int i=1; i<=V; i++) {
            if (visited[i] == 0) {
                if (dfs(i, graph, visited, pathVisited)) return true;
            }
        }

        return false;
    }

    private boolean dfs(int i, List<List<Integer>> graph, int[] visited, int[] pathVisited) {

        if (pathVisited[i] == 1) return true;
        if (visited[i] == 1) return false;

        pathVisited[i] = 1;
        visited[i] = 1;
        for (int neighbor : graph.get(i)) {
            if (dfs(neighbor, graph, visited, pathVisited)) return true;
        }
        pathVisited[i] = 0;
        return false;
    }

    public static void main(String[] args) {
        CycleInDirectedGraphDFS solution = new CycleInDirectedGraphDFS();

        int[][][] testEdges = {
                {{1, 2}, {2, 3}, {3, 4}},
                {{1, 2}, {2, 3}, {3, 1}},
                {{1, 2}, {3, 4}, {4, 5}, {5, 3}},
                {{1, 1}},
                {{1, 2}, {1, 3}, {2, 4}, {3, 4}},
                {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {2, 5}}
        };
        int[] vertices = {4, 5, 5, 3, 4, 5};
        boolean[] expected = {false, true, true, true, false, false};
        String[] names = {
                "simple DAG",
                "three-node cycle",
                "cycle in disconnected component",
                "self-loop",
                "converging DAG branches",
                "longer DAG with shortcut"
        };

        for (int test = 0; test < testEdges.length; test++) {
            int V = vertices[test];
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= V; i++) {
                graph.add(new ArrayList<>());
            }
            for (int[] edge : testEdges[test]) {
                graph.get(edge[0]).add(edge[1]);
            }

            boolean actual = solution.isCyclic(V, graph);
            String result = actual == expected[test] ? "✅ PASS" : "❌ FAIL";
            System.out.printf("%s | %-31s | expected=%-5s actual=%-5s%n",
                    result, names[test], expected[test], actual);
        }

    }
}
