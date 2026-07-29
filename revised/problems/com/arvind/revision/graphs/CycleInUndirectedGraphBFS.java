package com.arvind.revision.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CycleInUndirectedGraphBFS {

    public boolean hasCycle(int[][] edges, int V) {
        int m = edges.length;
        if (m == 0) return false;
        int n = edges[0].length;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0; i<=V; i++) {
            graph.add(i, new ArrayList<>());
        }
        // form the graph
        for (int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int[] visited = new int[V+1];
        for (int i=1; i<=V; i++) {
            if (visited[i] == 0) {
                if(bfs(i, m, n, visited, graph)) return true;
            }
        }
        return false;
    }

    private boolean bfs(int i, int m, int n, int[] visited, List<List<Integer>> graph) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i, -1});
        visited[i] = 1;

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int x = node[0];
            int parent = node[1];

            for (int neighbor : graph.get(x)) {
                if (visited[neighbor] == 1 && neighbor != parent) {
                    return true;
                }
                if (visited[neighbor] == 0) {
                    visited[neighbor] = 1;
                    queue.offer(new int[] {neighbor, x});
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CycleInUndirectedGraphBFS solution = new CycleInUndirectedGraphBFS();
        Object[][] tests = {
                {
                        "tree without a cycle",
                        7,
                        new int[][]{{1, 2}, {1, 3}, {2, 5}, {5, 7}, {6, 7}, {3, 4}},
                        false
                },
                {
                        "triangle cycle",
                        3,
                        new int[][]{{1, 2}, {2, 3}, {3, 1}},
                        true
                },
                {
                        "disconnected graph with a cycle",
                        6,
                        new int[][]{{1, 2}, {3, 4}, {4, 5}, {5, 3}},
                        true
                },
                {
                        "disconnected graph without a cycle",
                        6,
                        new int[][]{{1, 2}, {2, 3}, {4, 5}},
                        false
                },
                {
                        "self loop",
                        3,
                        new int[][]{{2, 2}},
                        true
                },
                {
                        "single vertex without an edge",
                        1,
                        new int[][]{},
                        false
                }
        };

        for (Object[] test : tests) {
            String name = (String) test[0];
            int vertices = (int) test[1];
            int[][] edges = (int[][]) test[2];
            boolean expected = (boolean) test[3];

            try {
                boolean actual = solution.hasCycle(edges, vertices);
                String status = actual == expected ? "PASS" : "FAIL";
                System.out.printf("%s - %s | expected=%s, actual=%s%n",
                        status, name, expected, actual);
            } catch (Exception exception) {
                System.out.printf("FAIL - %s | expected=%s, threw=%s%n",
                        name, expected, exception.getClass().getSimpleName());
            }
        }
    }
}
