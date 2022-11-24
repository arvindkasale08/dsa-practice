package arvind.neetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReorderRoutes {

    public int minReorder(int V, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        List<List<Integer>> neighbors = new ArrayList<>();

        for (int i=0; i< V; i++) {
            graph.add(i, new ArrayList<>());
            neighbors.add(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            neighbors.get(edge[0]).add(edge[1]);
            neighbors.get(edge[1]).add(edge[0]);
        }
        int[] visited = new int[V];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = 1;
        int count = 0;
        while(!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : neighbors.get(node)) {
                if (visited[neighbor] == 0) {
                    if (!graph.get(neighbor).contains(node)) {
                        count++;
                    }
                    visited[neighbor] = 1;
                    queue.offer(neighbor);
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        ReorderRoutes solution = new ReorderRoutes();
        int[][] edges = new int[][] {{0,1},{1,3},{2,3},{4,0},{4,5}};
        int count = solution.minReorder(6, edges);
        System.out.println(count);
    }
}
