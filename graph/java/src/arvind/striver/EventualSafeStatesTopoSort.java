package arvind.striver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EventualSafeStatesTopoSort {

	public List<Integer> findSafeStates(int V, int[][] edges) {
		List<List<Integer>> graph = new ArrayList<>();
		int[] indegree = new int[V];
		for (int i=0; i<V; i++) {
			graph.add(i, new ArrayList<>());
		}
		for (int[] edge : edges) {
			graph.get(edge[1]).add(edge[0]);
			indegree[edge[0]]+=1;
		}
		List<Integer> result = new ArrayList<>();
		bfs(graph, indegree, result);
		Collections.sort(result);
		return result;
	}

	private void bfs(List<List<Integer>> graph, int[] indegree, List<Integer> result) {
		Queue<Integer> queue = new LinkedList<>();
		for (int i=0; i< indegree.length; i++) {
			if (indegree[i] == 0) {
				queue.offer(i);
			}
		}

		while (!queue.isEmpty()) {
			int I = queue.poll();
			result.add(I);
			for (int next : graph.get(I)) {
				indegree[next] -= 1;
				if (indegree[next] == 0) {
					queue.offer(next);
				}
			}
		}
	}

	public static void main(String[] args) {
		EventualSafeStatesTopoSort solution = new EventualSafeStatesTopoSort();
		int V = 8;
		int[][] edges = new int[][] {
			{0, 1},
			{0, 2},
			{1, 3},
			{3, 0},
			{7, 1},
			{2, 5},
			{4, 5}
		};
		List<Integer> result = solution.findSafeStates(V, edges);
		System.out.println(result);
	}
}
