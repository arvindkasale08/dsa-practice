package com.arvind.revision.graphs;

import java.util.*;

public class FindIfPathExistsInGraph {

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0; i<n; i++) {
            graph.add(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;
        // do a bfs from source
        bfs(source, graph, distance);
        return distance[destination] != Integer.MAX_VALUE;
    }

    private void bfs(int node, List<List<Integer>> graph, int[] distance) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {node, 0});

        while (!queue.isEmpty()) {
            int[] n = queue.poll();
            int newD = n[1] + 1;
            for (int next : graph.get(n[0])) {
                if (newD < distance[next]) {
                    queue.offer(new int[] {next, newD});
                    distance[next] = newD;
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0,1}, {1,2}, {2,0}};
        int source = 0;
        int dest = 2;

        FindIfPathExistsInGraph solution = new FindIfPathExistsInGraph();
        System.out.println(solution.validPath(n, edges, source, dest));
    }
}
