package com.arvind.revision.graphs;

import java.util.*;

public class ToposortBFSKahnAlgo {

    private List<Integer> topoSort(int V, List<List<Integer>> graph) {
        List<Integer> res = new ArrayList<>();
        int[] indegree = new int[V];
        for (int i=0; i<V; i++) {
            for (int val : graph.get(i)) {
                indegree[val]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i=0; i<V; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            res.add(node);
            for (int neighbor : graph.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        ToposortBFSKahnAlgo solution = new ToposortBFSKahnAlgo();

        // Branching DAG: 5 -> 0, 5 -> 2, 4 -> 0, 4 -> 1, 2 -> 3, 3 -> 1.
        List<List<Integer>> branchingDag = List.of(
                List.of(),
                List.of(),
                List.of(3),
                List.of(1),
                List.of(0, 1),
                List.of(0, 2)
        );
        List<Integer> branchingExpected = List.of(4, 5, 0, 2, 3, 1);
        List<Integer> branchingActual = solution.topoSort(6, branchingDag);
        System.out.printf(
                "Branching DAG: %s | expected=%s, actual=%s%n",
                branchingExpected.equals(branchingActual) ? "PASSED" : "FAILED",
                branchingExpected,
                branchingActual
        );

        // Disconnected DAG: 0 -> 1, 2 -> 3, and vertex 4 is isolated.
        List<List<Integer>> disconnectedDag = List.of(
                List.of(1),
                List.of(),
                List.of(3),
                List.of(),
                List.of()
        );
        List<Integer> disconnectedExpected = List.of(0, 2, 4, 1, 3);
        List<Integer> disconnectedActual = solution.topoSort(5, disconnectedDag);
        System.out.printf(
                "Disconnected DAG: %s | expected=%s, actual=%s%n",
                disconnectedExpected.equals(disconnectedActual) ? "PASSED" : "FAILED",
                disconnectedExpected,
                disconnectedActual
        );

        // Linear chain: 0 -> 1 -> 2 -> 3.
        List<List<Integer>> linearDag = List.of(
                List.of(1),
                List.of(2),
                List.of(3),
                List.of()
        );
        List<Integer> linearExpected = List.of(0, 1, 2, 3);
        List<Integer> linearActual = solution.topoSort(4, linearDag);
        System.out.printf(
                "Linear DAG: %s | expected=%s, actual=%s%n",
                linearExpected.equals(linearActual) ? "PASSED" : "FAILED",
                linearExpected,
                linearActual
        );

        // Multiple sources: 0 -> 2, 1 -> 2, 1 -> 3.
        List<List<Integer>> multipleSourcesDag = List.of(
                List.of(2),
                List.of(2, 3),
                List.of(),
                List.of()
        );
        List<Integer> multipleSourcesExpected = List.of(0, 1, 2, 3);
        List<Integer> multipleSourcesActual = solution.topoSort(4, multipleSourcesDag);
        System.out.printf(
                "Multiple sources DAG: %s | expected=%s, actual=%s%n",
                multipleSourcesExpected.equals(multipleSourcesActual) ? "PASSED" : "FAILED",
                multipleSourcesExpected,
                multipleSourcesActual
        );

        // Single vertex with no edges.
        List<List<Integer>> singleVertex = List.of(List.of());
        List<Integer> singleVertexExpected = List.of(0);
        List<Integer> singleVertexActual = solution.topoSort(1, singleVertex);
        System.out.printf(
                "Single vertex: %s | expected=%s, actual=%s%n",
                singleVertexExpected.equals(singleVertexActual) ? "PASSED" : "FAILED",
                singleVertexExpected,
                singleVertexActual
        );
    }
}
