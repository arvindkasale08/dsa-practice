package arvind.striver;

import java.util.ArrayList;
import java.util.List;

public class CycleInUndirectedGraphDFS {

	public boolean hasCycle(int[][] edges, int V) {
		List<List<Integer>> graph = new ArrayList<>();
		for (int i=0; i<=V; i++) {
			graph.add(i, new ArrayList<>());
		}
		for (int[] edge : edges) {
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}

		int[] visited = new int[V+1];

		for (int i=1; i<=V; i++) {
			if (visited[i] == 0) {
				if (dfs(graph, i, -1, visited)) return true;
			}
		}

		return false;
	}

	private boolean dfs(List<List<Integer>> graph, int i, int parent, int[] visited) {
		visited[i] = 1;

		for (int neighbor : graph.get(i)) {
			if (visited[neighbor] == 1 && parent != neighbor) {
				return true;
			}
			if (visited[neighbor] == 0) {
				visited[neighbor] = 1;
				if (dfs(graph, neighbor, i, visited)) return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		CycleInUndirectedGraphDFS solution = new CycleInUndirectedGraphDFS();
		int V = 7;
		int[][] edges = new int[][] {
			{1,2},
			{1, 3},
			{2, 5},
			{5, 7},
			{6, 7},
			{3, 6},
			{3, 4}
		};
		boolean hasCycle = solution.hasCycle(edges, V);
		System.out.println(hasCycle);
	}
}
