package arvind.p1;

import java.util.ArrayList;
import java.util.List;

public class MColoringProblem {

    public boolean isPossible(int[][] edges, int m, int V) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0; i< V; i++) {
            graph.add(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int[] color = new int[V];
        return isPossible(0, V, m, color, graph);
    }

    private boolean isPossible(int node, int V, int m, int[] color, List<List<Integer>> graph) {
        if (node == V)
            return true;

        for (int c=1; c<=m; c++) {
            if (isSafe(node, c, color, graph)) {
                color[node] = c;
                if (isPossible(node+1, V, m, color, graph)) return true;
                color[node] = 0;
            }
        }

        return false;
    }

    private boolean isSafe(int node, int c, int[] color, List<List<Integer>> graph) {
        for (int neigh : graph.get(node)) {
            if (color[neigh] == c) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] edges = new int[][] {
                {0, 1},
                {1, 2},
                {2, 3},
                {3, 0},
                {0, 2}
        };
        int m = 3;
        int V = 4;
        MColoringProblem solution = new MColoringProblem();
        boolean result = solution.isPossible(edges, m, V);
        System.out.println(result);
    }
}
