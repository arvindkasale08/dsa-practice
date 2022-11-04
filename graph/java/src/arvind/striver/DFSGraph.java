package arvind.striver;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.codingninjas.com/codestudio/problems/dfs-traversal_630462
 */
public class DFSGraph {

	public List<List<Integer>> dfs(int vertex, int edgeCt, int[][] edges) {
		List<List<Integer>> graph = new ArrayList<>();
		for (int i=0; i<vertex; i++) {
			graph.add(i, new ArrayList<>());
		}
		for (int[] edge : edges) {
			if (edge.length == 2) {
				graph.get(edge[0]).add(edge[1]);
				graph.get(edge[1]).add(edge[0]);
			}
		}
		List<List<Integer>> results = new ArrayList<>();
		int[] visited = new int[vertex];
		for (int i=0; i<vertex; i++) {
			if (visited[i] == 0) {
				List<Integer> result = new ArrayList<>();
				dfs(graph, i, visited, result);
				results.add(result);
			}
		}
		return results;
	}

	private void dfs(List<List<Integer>> graph, int node, int[] visited, List<Integer> result) {
		visited[node] = 1;
		result.add(node);
		for (int neighbor : graph.get(node)) {
			if (visited[neighbor] == 0) {
				dfs(graph, neighbor, visited, result);
			}
		}
	}

	public static void main(String[] args) {
		DFSGraph solution = new DFSGraph();
		/*
		5 4
		0 2
		0 1
		1 2
		3 4
		 */
		int vertex = 5;
		int edgeCt = 4;
		int[][] edges = new int[][] {
			{0, 2},
			{0, 1},
			{1, 2},
			{3, 4}
		};
		List<List<Integer>> result = solution.dfs(vertex, edgeCt, edges);
		System.out.println(result);
	}
}
