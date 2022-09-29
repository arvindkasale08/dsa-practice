package arvind;

import java.util.*;

public class IsBipartiteBFS {

    public boolean check(int[][] graph) {
        int size = graph.length;
        int[] visited = new int[size];
        for (int i=0; i<size; i++) {
            if (visited[i] == 0) {
                if (!bfs(graph, i, visited)) return false;
            }
        }

        return true;
    }

    public boolean bfs(int[][] graph, int node, int[] visited) {
        Queue<int[]> queue = new LinkedList<>();
        // 1 -> blue -1 -> red 0 -> not seen
        queue.offer(new int[] {node, 1});
        visited[0] = 1; // mark first blue;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int vertex = cell[0];
            int color = cell[1];
            visited[vertex] = color;
            int nextColor = color == 1 ? -1 : 1;

            for (int neighbour : graph[vertex]) {
                if (visited[neighbour] == color) {
                    return false;
                }
                if (visited[neighbour] == 0) {
                    visited[neighbour] = nextColor;
                    queue.offer(new int[] {neighbour, nextColor});
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //int[][] graph =  new int[][]{ {1,3}, {0,2}, {1,3},{0,2} };

        //int[][] graph = new int[][] {{},{2,4,6},{1,4,8,9},{7,8},{1,2,8,9},{6,9},{1,5,7,8,9},{3,6,9},{2,3,4,6,9},{2,4,5,6,7,8}};
        int[][] graph = new int[][] {{1,3}, {0,2}, {1,3}, {0, 2}};
        IsBipartiteBFS bfs = new IsBipartiteBFS();
        boolean isBipartite = bfs.check(graph);
        System.out.println(isBipartite);
    }
}
