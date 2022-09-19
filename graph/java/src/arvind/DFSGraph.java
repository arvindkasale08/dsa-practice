package arvind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DFSGraph {

	private int size;
	private Map<Integer, List<Integer>> graph;

	public DFSGraph(int size) {
		this.size = size;
		this.graph = new HashMap<>();
	}

	public void addEdge(int src, int dest) {
		if (!this.graph.containsKey(src)) {
			this.graph.put(src, new ArrayList<>());
		}
		this.graph.get(src).add(dest);
	}

	public static List<Integer> dfs(DFSGraph graph) {
		List<Integer> result = new ArrayList<>();
		int[] visited = new int[graph.size];
		for (Integer key : graph.graph.keySet()) {
			if (visited[key] == 0) {
				dfs(graph.graph, key, result, visited);
			}
		}
		return result;
	}

	private static void dfs(Map<Integer, List<Integer>> graph, Integer key, List<Integer> result, int[] visited) {
		result.add(key);
		visited[key] = 1;
		List<Integer> nodes = graph.containsKey(key) ? graph.get(key) : new ArrayList<>();
		for (Integer node : nodes) {
			if (visited[node] == 0) {
				dfs(graph, node, result, visited);
			}
		}
	}

	public static void main(String[] args) {
		DFSGraph graph = new DFSGraph(6);
		graph.addEdge(0, 2);
		graph.addEdge(0, 3);
		graph.addEdge(2, 1);
		graph.addEdge(1, 5);
		graph.addEdge(3, 4);

		List<Integer> result = dfs(graph);
		System.out.println(result);
	}
}
