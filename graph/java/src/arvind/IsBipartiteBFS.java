package arvind;

import java.util.*;

public class IsBipartiteBFS {

    public boolean check(int[][] graph) {
        int size = graph.length;
        Queue<int[]> queue = new LinkedList<>();
        int[] visited = new int[size];
        // 1 -> blue -1 -> red 0 -> not seen
        queue.offer(new int[] {0, 1});
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
        int[][] graph =  new int[][]{ {1,3}, {0,2}, {1,3},{0,2} };
        IsBipartiteBFS bfs = new IsBipartiteBFS();
        boolean isBipartite = bfs.check(graph);
        System.out.println(isBipartite);
    }
}
