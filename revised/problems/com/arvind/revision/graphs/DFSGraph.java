package com.arvind.revision.graphs;

import com.arvind.revision.common.CommonUtils;

import java.util.ArrayList;
import java.util.List;

public class DFSGraph {

    public List<Integer> dfs(int vertex, int[][] edges) {
        // prepare the graph
        List<List<Integer>> graph = new ArrayList<>();

        for (int i=0; i<vertex; i++) {
            graph.add(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        List<Integer> result = new ArrayList<>();
        int[] visited = new int[vertex];

        for (int i=0; i<vertex; i++) {
            if (visited[i] == 0)
                dfsInner(i, graph, visited, result);
        }
        return result;
    }

    public void dfsInner(int node, List<List<Integer>> graph, int[] visited, List<Integer> result) {
        visited[node] = 1;
        result.add(node);

        for (int neighbor : graph.get(node)) {
            if (visited[neighbor] == 0) {
                dfsInner(neighbor, graph, visited, result);
            }
        }
    }

    public static void main(String[] args) {
        DFSGraph solution = new DFSGraph();

        int[][] connectedEdges = {
                {0, 1},
                {0, 3},
                {2, 3}
        };
        List<Integer> connectedActual = solution.dfs(4, connectedEdges);
        List<Integer> connectedExpected = List.of(0, 1, 3, 2);
        System.out.println((connectedActual.equals(connectedExpected) ? "✅ PASS" : "❌ FAIL")
                + " connected graph | expected=" + connectedExpected + " actual=" + connectedActual);

        int[][] disconnectedEdges = {
                {0, 1},
                {2, 3}
        };
        List<Integer> disconnectedActual = solution.dfs(5, disconnectedEdges);
        List<Integer> disconnectedExpected = List.of(0, 1, 2, 3, 4);
        System.out.println((disconnectedActual.equals(disconnectedExpected) ? "✅ PASS" : "❌ FAIL")
                + " disconnected graph | expected=" + disconnectedExpected + " actual=" + disconnectedActual);

        List<Integer> isolatedActual = solution.dfs(3, new int[][]{});
        List<Integer> isolatedExpected = List.of(0, 1, 2);
        System.out.println((isolatedActual.equals(isolatedExpected) ? "✅ PASS" : "❌ FAIL")
                + " isolated vertices | expected=" + isolatedExpected + " actual=" + isolatedActual);

        int[][] cycleEdges = {
                {0, 1},
                {1, 2},
                {2, 0}
        };
        List<Integer> cycleActual = solution.dfs(3, cycleEdges);
        List<Integer> cycleExpected = List.of(0, 1, 2);
        System.out.println((cycleActual.equals(cycleExpected) ? "✅ PASS" : "❌ FAIL")
                + " cyclic graph | expected=" + cycleExpected + " actual=" + cycleActual);

        List<Integer> emptyActual = solution.dfs(0, new int[][]{});
        List<Integer> emptyExpected = List.of();
        System.out.println((emptyActual.equals(emptyExpected) ? "✅ PASS" : "❌ FAIL")
                + " empty graph | expected=" + emptyExpected + " actual=" + emptyActual);
    }
}
