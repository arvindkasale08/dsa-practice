package com.arvind.revision.graphs;

import java.util.ArrayList;
import java.util.List;

public class NumberOfProvinces {

    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> graph = new ArrayList<>();
        int n = isConnected.length;
        for (int i=0; i<n; i++) {
            graph.add(i, new ArrayList<>());
        }

        for (int i=0; i< n; i++) {
            for (int j=0; j<n; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    graph.get(i).add(j);
                }
            }
        }
        int noOfProvinces = 0;

        int[] visited = new int[n];
        for (int i=0; i<n; i++) {
            if (visited[i] == 0) {
                noOfProvinces++;
                dfs(i, graph, visited);
            }
        }
        return noOfProvinces;
    }

    private void dfs(int n, List<List<Integer>> graph, int[] visited) {
        if (visited[n] == 1) return;

        visited[n] = 1;
        for (int neighbor : graph.get(n)) {
            dfs(neighbor, graph, visited);
        }
    }

    public static void main(String[] args) {
        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        NumberOfProvinces solution = new NumberOfProvinces();
        System.out.println(solution.findCircleNum(isConnected));
    }
}
