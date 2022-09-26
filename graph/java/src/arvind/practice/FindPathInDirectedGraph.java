package arvind.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindPathInDirectedGraph {

	private int size;
	private List<List<Integer>> graph = new ArrayList<>();

	public FindPathInDirectedGraph(int size) {
		this.size = size;
		this.graph = new ArrayList<>();
		for (int i=0; i< size; i++) {
			this.graph.add(i, new ArrayList<>());
		}
	}

	// Directed graph
	public void addEdge(int src, int dest) {
		this.graph.get(src).add(dest);
	}

	public List<List<Integer>> findPaths(int src, int dest) {
		List<List<Integer>> results = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		int[] visited = new int[this.size];
		dfs(this.graph, src, dest, list, results, visited);
		return results;
	}

	private void dfs(List<List<Integer>> graph, int src, int dest, List<Integer> list, List<List<Integer>> results, int[] visited) {
		if (src == dest) {
			results.add(new ArrayList<>(list));
		}

		if (visited[src] == 0) {
			list.add(src);
		}
		visited[src] = 1;

		for (Integer neighbour : graph.get(src)) {
			if (visited[neighbour] == 0) {
				visited[neighbour] = 1;
				list.add(neighbour);
				dfs(graph, neighbour, dest, list, results, visited);
				visited[neighbour] = 0;
				list.remove(neighbour);
			}
		}
	}

	public static void main(String[] args) {
		FindPathInDirectedGraph solution = new FindPathInDirectedGraph(4);
		solution.addEdge(0, 1);
		solution.addEdge(0, 2);
		solution.addEdge(0, 3);
		solution.addEdge(2, 1);
		solution.addEdge(2, 0);
		solution.addEdge(1, 3);

		List<List<Integer>> results =  solution.findPaths(0, 3);
		System.out.println(results);

	}
}
