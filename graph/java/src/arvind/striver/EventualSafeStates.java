package arvind.striver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EventualSafeStates {

	public List<Integer> safeNodes(int V, int[][] edges) {
		List<List<Integer>> graph = new ArrayList<>();
		for (int i=0; i<=V; i++) {
			graph.add(i, new ArrayList<>());
		}

		for (int[] edge : edges) {
			graph.get(edge[0]).add(edge[1]);
		}
		List<Integer> results = new ArrayList<>();
		int[] visited = new int[V];
		int[] pathvisited = new int[V];

		for (int i=0; i<V; i++) {
			if (visited[i] == 0) {
				dfs(i, graph, visited, pathvisited, results);
			}
		}
		Collections.sort(results);
		return results;
	}

	private boolean dfs(int i, List<List<Integer>> graph, int[] visited, int[] pathvisited, List<Integer> results) {
		visited[i] = 1;
		pathvisited[i] = 1;
		for (int neighbor : graph.get(i)) {
			if (visited[neighbor] == 0) {
				visited[neighbor] = 1;
				pathvisited[neighbor] = 1;
				if (dfs(neighbor, graph, visited, pathvisited, results)) return true;
			} else if (pathvisited[neighbor] == 1) {
				return true;
			}
		}
		results.add(i);
		pathvisited[i] = 0;
		return false;
	}

	public static void main(String[] args) {
		EventualSafeStates solution = new EventualSafeStates();
		int V = 7;
		int[][] edges = new int[][] {
			{0, 1},
			{0, 2},
			{1, 2},
			{1, 3},
			{3, 0},
			{2, 5},
			{4, 5}
		};
		List<Integer> nodes = solution.safeNodes(V, edges);
		System.out.println(nodes);
	}
}
