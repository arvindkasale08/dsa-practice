package com.arvind.revision.graphs;

import com.arvind.revision.common.CommonUtils;

import java.util.*;

public class ShortestPathUndirectedGraph {

    public int[] shortestPath(int[][] edges, int V, int src) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] distance = new int[V];
        Arrays.fill(distance, -1);
        for (int i=0; i<V; i++) {
            graph.add(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {src, 0});

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int val = node[0];
            int dist = node[1];
            distance[val] = dist;

            for (int neighbor : graph.get(val)) {
                if (distance[neighbor] == -1) {
                    distance[neighbor] = dist + 1;
                    queue.offer(new int[] {neighbor, dist+1});
                }
            }
        }

        return distance;
    }

    public static void main(String[] args) {
        ShortestPathUndirectedGraph solution = new ShortestPathUndirectedGraph();

        int[][][] edgeCases = {
                {{0,1},{0,3},{3,4},{4,5},{5,6},{1,2},{2,6},{6,7},{7,8},{6,8}},
                {{0,1},{1,2},{3,4}},
                {{0,1},{1,2},{2,3}},
                {{0,1},{0,2},{1,3},{2,3},{3,4},{1,4}},
                {}
        };
        int[] vertexCounts = {9, 6, 4, 5, 1};
        int[] sources = {0, 0, 3, 0, 0};
        int[][] expectedResults = {
                {0,1,2,1,2,3,3,4,4},
                {0,1,2,-1,-1,-1},
                {3,2,1,0},
                {0,1,1,2,2},
                {0}
        };
        String[] testNames = {
                "connected graph with multiple routes",
                "disconnected graph and isolated vertex",
                "non-zero source",
                "cycle with competing paths",
                "single vertex"
        };

        for (int i = 0; i < testNames.length; i++) {
            int[] actual = solution.shortestPath(edgeCases[i], vertexCounts[i], sources[i]);
            boolean passed = Arrays.equals(actual, expectedResults[i]);
            System.out.printf("%s: %s | expected=%s, actual=%s%n",
                    passed ? "PASS" : "FAIL",
                    testNames[i],
                    Arrays.toString(expectedResults[i]),
                    Arrays.toString(actual));
        }
    }
}
