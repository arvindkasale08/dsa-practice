package com.arvind.revision.graphs;

import com.arvind.revision.common.CommonUtils;

import java.util.*;

public class EventualSafeStates {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;

        List<Integer> res = new ArrayList<>();
        List<List<Integer>> invGraph = new ArrayList<>();
        int[] indegrees = new int[V];
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<V; i++) {
            invGraph.add(i, new ArrayList<>());
        }
        for (int i=0; i<V; i++) {
            for (int node : graph[i]) {
                invGraph.get(node).add(i);
                indegrees[i]++;
            }
        }
        for (int i=0; i<V; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()) {
            int node = queue.poll();
            res.add(node);

            for (int neighbors : invGraph.get(node)) {
                indegrees[neighbors]--;
                if (indegrees[neighbors] == 0) {
                    queue.offer(neighbors);
                }
            }
        }
        Collections.sort(res, (o1, o2) -> o1 - o2);
        return res;
    }

    public static void main(String[] args) {
        int[][] graph = new int[][] {
                {1, 2},
                {2, 3},
                {5},
                {0},
                {5},
                {},
                {}
        };
        EventualSafeStates solution = new EventualSafeStates();
        CommonUtils.printList(solution.eventualSafeNodes(graph));
    }
}
