package arvind.striver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KahnTopoSortBFS {

	public List<Integer> findTopologicalSort(int V, int[][] edges) {
		List<List<Integer>> graph = new ArrayList<>();
		int[] indegree = new int[V];
		for (int i=0; i<=V; i++) {
			graph.add(i, new ArrayList<>());
		}

		for (int[] edge : edges) {
			graph.get(edge[0]).add(edge[1]);
			indegree[edge[1]]++;
		}
		List<Integer> result = new ArrayList<>();

		bfs(graph, result, indegree);
		return result;
	}

	private void bfs(List<List<Integer>> graph, List<Integer> result, int[] indegree) {
		Queue<Integer> queue = new LinkedList<>();
		for (int i=0; i< indegree.length; i++) {
			if (indegree[i] == 0)
				queue.offer(i);
		}

		while(!queue.isEmpty()) {
			int i = queue.poll();
			result.add(i);
			for (int next : graph.get(i)) {
				indegree[next]-=1;
				if (indegree[next] == 0) {
					queue.offer(next);
				}
			}
		}
	}

	public static void main(String[] args) {
		KahnTopoSortBFS solution = new KahnTopoSortBFS();
		int V = 6;
		int[][] edges = new int[][] {
			{5, 0},
			{4, 0},
			{5, 2},
			{4, 1},
			{2, 3},
			{3, 1}
		};
		List<Integer> result = solution.findTopologicalSort(V, edges);
		System.out.println(result);
	}
}
