package arvind.striver;

import java.util.ArrayList;
import java.util.List;

public class MColoringProblem {

    public boolean isPossible(int[][] edges, int m, int V) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0; i<V; i++) {
            graph.add(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int[] color = new int[V];

        return isPossible(0, graph, m, V, color);
    }

    private boolean isPossible(int node, List<List<Integer>> graph, int m, int V, int[] color) {
        if (node == V)
            return true;
        for (int c=1; c<=m; c++) {
            if (isSafe(c, node, graph, color)) {
                color[node] = c;
                if (isPossible(node + 1, graph, m, V, color)) return true;
                color[node] = 0;
            }
        }
        return false;
    }

    private boolean isSafe(int c, int node, List<List<Integer>> graph, int[] color) {
        for (int neighbor : graph.get(node)) {
            if (color[neighbor] == c)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        MColoringProblem solution = new MColoringProblem();
        int[][] edges = new int[][] {
                {0, 1},
                {1, 2},
                {2, 3},
                {3, 0},
                {0, 2}
        };
        int m = 2;
        int n = 4;
        boolean result = solution.isPossible(edges, m, n);
        System.out.println(result);
    }
}
