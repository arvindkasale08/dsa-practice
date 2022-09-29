package arvind;

import java.util.*;

public class IsBipartiteBFSHackerank {

    private Map<Integer, List<Integer>> graph;
    private int maxNode = Integer.MIN_VALUE;

    public IsBipartiteBFSHackerank(int size) {
        this.graph = new HashMap<>();
    }

    public int size() {
        return this.graph.size();
    }

    public void addEdge(int src, int dest) {
        // undirected graph add src in dest, dest in src;
        if (!this.graph.containsKey(src)) {
            this.graph.put(src, new ArrayList<>());
        }
        this.graph.get(src).add(dest);
        if (!this.graph.containsKey(dest)) {
            this.graph.put(dest, new ArrayList<>());
        }
        this.graph.get(dest).add(src);
        this.maxNode = Math.max(this.maxNode, Math.max(src, dest));
    }

    private int bfs(Map<Integer, List<Integer>> graph, int node, int[] visited) {
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

            if (this.graph.containsKey(vertex)) {
                for (int neighbour : this.graph.get(vertex)) {
                    if (visited[neighbour] == color) {
                        return 0;
                    }
                    if (visited[neighbour] == 0) {
                        visited[neighbour] = nextColor;
                        queue.offer(new int[]{neighbour, nextColor});
                    }
                }
            }
        }
        return 1;
    }

    public int check(int[][] graph) {
        for (int[] arr : graph) {
            addEdge(arr[0], arr[1]);
        }
        int size = this.maxNode + 1;

        int[] visited = new int[size];

        for ( Integer vertex : this.graph.keySet()) {
            if (visited[vertex] == 0) {
                if (bfs(this.graph, vertex, visited)==0) return 0;
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        int[][] graph =  new int[][]{ {1,2}, {1,7},{2, 3}, {3,5}, {4,6}, {4,8}, {7,8} };
        IsBipartiteBFSHackerank bfs = new IsBipartiteBFSHackerank(9);
        int isBipartite = bfs.check(graph);
        System.out.println(isBipartite);
    }
}
