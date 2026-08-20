package com.arvind.revision.graphs;

import com.arvind.revision.common.CommonUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ShortestPathDAGDFS {

    class Node {
        int val;
        int dist;

        public Node(int val, int dist) {
            this.val = val;
            this.dist = dist;
        }
    }

    public int[] shortestPath(int V, int src, int[][] edges) {
        // ingore dont add yet
        int[] distance = new int[V];
        List<List<Node>> graph = new ArrayList<>();
        for (int i=0; i<V; i++) {
            graph.add(i, new ArrayList<>());
        }

        for (int i=0; i<edges.length; i++) {
            int[] edge = edges[i];
            graph.get(edge[0]).add(new Node(edge[1], edge[2]));
        }

        // Get the toposort order
        int[] visited = new int[V];
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<V; i++) {
            if (visited[i] == 0) {
                dfs(i, stack, visited, graph);
            }
        }
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;
        // Relax the nodes
        while (!stack.isEmpty()) {
            int node = stack.pop();

            for (Node neighbor : graph.get(node)) {
                int val = neighbor.val;
                int dist = neighbor.dist;
                distance[val] = Math.min(distance[val], dist + distance[node]);
            }
        }

        return distance;
    }

    private void dfs(int node, Stack<Integer> stack, int[] visited, List<List<Node>> graph) {
        if (visited[node] == 1) return;
        visited[node] = 1;
        for (Node neighbor : graph.get(node)) {
            dfs(neighbor.val, stack, visited, graph);
        }
        stack.push(node);
    }


    public static void main(String[] args) {
        ShortestPathDAGDFS solution = new ShortestPathDAGDFS();

        int[][][] testEdges = {
                {{0, 4, 2}, {0, 5, 3}, {5, 4, 1}, {4, 6, 3}, {4, 2, 1}, {6, 1, 2}, {2, 3, 3}, {1, 3, 1}},
                {{0, 1, 5}, {0, 2, 2}, {2, 1, 1}, {1, 3, 3}, {2, 3, 10}},
                {{0, 1, 4}, {0, 2, 3}, {1, 2, -2}, {2, 3, 2}},
                {{0, 1, 2}, {2, 3, 4}},
                {},
                {{0, 1, 2}, {1, 2, 3}}
        };
        int[] vertices = {7, 4, 4, 5, 1, 4};
        int[] sources = {0, 0, 0, 2, 0, 3};
        int[][] expected = {
                {0, 7, 3, 6, 2, 3, 5},
                {0, 3, 2, 6},
                {0, 4, 2, 4},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 4, Integer.MAX_VALUE},
                {0},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0}
        };

        for (int i = 0; i < testEdges.length; i++) {
            int[] actual = solution.shortestPath(vertices[i], sources[i], testEdges[i]);
            System.out.printf(
                    "Test %d: %s | expected=%s actual=%s%n",
                    i + 1,
                    Arrays.equals(expected[i], actual) ? "PASS" : "FAIL",
                    Arrays.toString(expected[i]),
                    Arrays.toString(actual)
            );
        }
    }

}
