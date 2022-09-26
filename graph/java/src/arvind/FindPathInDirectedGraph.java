package arvind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindPathInDirectedGraph {

	private int size;
	private Map<Integer, List<Integer>> graph;

	public FindPathInDirectedGraph(int size) {
		this.size = size;
		this.graph = new HashMap<>();
		for (int i=0; i<size; i++) {
			this.graph.put(i, new ArrayList<>());
		}
	}

	public void addEdge(int src, int dest) {
		this.graph.get(src).add(dest);
	}

	public List<List<Integer>> findPath(int src, int dest) {
		List<List<Integer>> results = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		int[] visited = new int[this.size];
		findPath(this.graph, src, dest, list, results, visited);
		return results;
	}

	private void findPath(Map<Integer, List<Integer>> graph, int src, int dest, List<Integer> list, List<List<Integer>> results, int[] visited) {
		if (src == dest) {
			results.add(new ArrayList<>(list));
		}
		if (visited[src] == 0)
			list.add(src);
		visited[src] = 1;

		for (Integer neighbours : graph.get(src)) {
			if (visited[neighbours] == 0) {
				visited[neighbours] = 1;
				list.add(neighbours);
				findPath(graph, neighbours, dest, list, results, visited);
				visited[neighbours] = 0;
				list.remove(neighbours);
			}
		}
	}

	public static void main(String[] args) {
		FindPathInDirectedGraph solution = new FindPathInDirectedGraph(4);
		solution.addEdge(0, 1);
		solution.addEdge(0, 2);
		solution.addEdge(0, 3);
		solution.addEdge(2, 0);
		solution.addEdge(2, 1);
		solution.addEdge(1, 3);

		List<List<Integer>> result = solution.findPath(2, 3);
		System.out.println(result);
	}
}
