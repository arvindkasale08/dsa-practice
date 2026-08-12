package com.arvind.revision.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopoSortDAGCycleBFS {

    // Function to detect cycle in a directed graph using Kahn's Algorithm
    public boolean hasCycle(int V, List<List<Integer>> adj) {
        int[] indegrees = new int[V];
        int nodeSeen = 0;
        for (List<Integer> l : adj) {
            for (Integer v : l) {
                indegrees[v]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();

        for (int i=0; i<V; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()) {
            int node = queue.poll();
            nodeSeen +=1;

            for (int neighbor : adj.get(node)) {
                indegrees[neighbor] -=1;
                if (indegrees[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return nodeSeen != V;
    }

    public static void main(String[] args) {
        TopoSortDAGCycleBFS solution = new TopoSortDAGCycleBFS();

        runTest(solution, "Directed cycle", 4, new int[][]{
                {0, 1}, {1, 2}, {2, 3}, {3, 1}
        }, true);

        runTest(solution, "Linear DAG", 4, new int[][]{
                {0, 1}, {1, 2}, {2, 3}
        }, false);

        runTest(solution, "Branching DAG", 6, new int[][]{
                {5, 0}, {5, 2}, {4, 0}, {4, 1}, {2, 3}, {3, 1}
        }, false);

        runTest(solution, "Disconnected graph with cycle", 6, new int[][]{
                {0, 1}, {2, 3}, {3, 4}, {4, 2}
        }, true);

        runTest(solution, "Self-loop", 3, new int[][]{
                {0, 1}, {2, 2}
        }, true);

        runTest(solution, "No edges", 4, new int[][]{}, false);
    }

    private static void runTest(TopoSortDAGCycleBFS solution, String name, int vertices,
                                int[][] edges, boolean expected) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < vertices; i++) graph.add(new ArrayList<>());
        for (int[] edge : edges) graph.get(edge[0]).add(edge[1]);

        boolean actual = solution.hasCycle(vertices, graph);
        System.out.printf(
                "%s: %s | expected=%s, actual=%s%n",
                name,
                expected == actual ? "PASSED" : "FAILED",
                expected,
                actual
        );
    }
}
