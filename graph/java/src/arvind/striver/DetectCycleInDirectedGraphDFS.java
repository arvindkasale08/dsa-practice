package arvind.striver;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleInDirectedGraphDFS {

	public boolean hasCycle(int V, int[][] edges) {
		List<List<Integer>> graph = new ArrayList<>();
		for (int i=0; i<=V; i++) {
			graph.add(i, new ArrayList<>());
		}
		for (int[] edge : edges) {
			graph.get(edge[0]).add(edge[1]);
		}

		int[] visited = new int[V+1];
		int[] pathVisited = new int[V+1];

		for (int i=1; i<=V; i++) {
			if (visited[i] == 0) {
				if (dfs(graph, i, visited, pathVisited)) return true;
			}
		}

		return false;
	}

	private boolean dfs(List<List<Integer>> graph, int i, int[] visited, int[] pathvisited) {
		visited[i] = 1;
		pathvisited[i] = 1;

		for (int neighbor : graph.get(i)) {
			if(pathvisited[neighbor] == 1) return true;
			if (visited[neighbor] == 0) {
				visited[neighbor] = 1;
				if (dfs(graph, neighbor, visited, pathvisited)) return true;
			}
		}

		pathvisited[i] = 0;
		return false;
	}

	public static void main(String[] args) {
		DetectCycleInDirectedGraphDFS solution = new DetectCycleInDirectedGraphDFS();
		int V = 5;
		int[][] edges = new int[][] {
			{1, 2},
			{1, 3},
			{2, 4},
			{3, 4},
			{4, 1},
			{5, 2}
		};
		boolean result = solution.hasCycle(V, edges);
		System.out.println(result);
	}
}
