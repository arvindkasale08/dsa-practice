package com.arvind.revision.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IsGraphBipartite {

    public boolean isBipartite(int[][] graph) {
        int V = graph.length; // number of nodes
        int[] visited = new int[V];

        for (int i=0; i<V; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                if (!dfs(i, graph, visited, 1)) return false;
            }
        }
        return true;
    }

    private boolean dfs(int i, int[][] graph, int[] visited, int color) {

        if (visited[i] != 0 && color != visited[i]) return false;
        visited[i] = color;
        int nextColor = color == 1 ? -1 : 1;

        for (int neighbor : graph[i]) {
            if (visited[neighbor] == 0) {
                if (!dfs(neighbor, graph, visited, nextColor)) return false;
            } else if (visited[neighbor] != nextColor) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] graph = {{1,3},{0,2},{1,3},{0,2}};
        IsGraphBipartite solution = new IsGraphBipartite();
        System.out.println(solution.isBipartite(graph));
    }
}
