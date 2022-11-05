package arvind.striver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CycleInDirectGraphBFSTopoSort {

	public boolean hasCycle(int V, int[][] edges) {
		List<List<Integer>> graph = new ArrayList<>();
		int[] indegree = new int[V+1];
		for (int i=0; i<=V; i++) {
			graph.add(i, new ArrayList<>());
		}

		for (int[] edge : edges) {
			graph.get(edge[0]).add(edge[1]);
			indegree[edge[1]]++;
		}

		int count = bfs(graph, indegree);
		return !(count == V);
	}

	private int bfs(List<List<Integer>> graph, int[] indegree) {
		int count = 0;
		Queue<Integer> queue = new LinkedList<>();
		for (int i=1; i<indegree.length; i++) {
			if (indegree[i] == 0)
				queue.offer(i);
		}
		while (!queue.isEmpty()) {
			int i = queue.poll();
			count++;
			for (int next : graph.get(i)) {
				indegree[next] -= 1;
				if (indegree[next] == 0) {
					queue.offer(next);
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		CycleInDirectGraphBFSTopoSort solution = new CycleInDirectGraphBFSTopoSort();
		int V = 5;
		int[][] edges = new int[][] {
			{1, 2},
			{2, 3},
			{4, 2},
			{3, 4},
			{3, 5}
		};
		boolean result = solution.hasCycle(V, edges);
		System.out.println(result);
	}
}
