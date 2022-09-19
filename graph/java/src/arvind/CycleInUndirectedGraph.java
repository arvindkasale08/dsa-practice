package arvind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CycleInUndirectedGraph {

	private int size;
	private Map<Integer, List<Integer>> graph;

	public CycleInUndirectedGraph(int size) {
		this.size = size;
		this.graph = new HashMap<>();
	}

	public void addEdge(int src, int dest) {
		if (!this.graph.containsKey(src)) {
			this.graph.put(src, new ArrayList<>());
		}
		this.graph.get(src).add(dest);
		// add for undirected
		if (!this.graph.containsKey(dest)) {
			this.graph.put(dest, new ArrayList<>());
		}
		this.graph.get(dest).add(src);
	}

	public static boolean hasCycle(Map<Integer, List<Integer>> graph, int size) {
		int[] visited = new int[graph.size()];
		for (Integer key : graph.keySet()) {
			if (visited[key] == 0) {
				visited[key] = 1;
				if (hasCycle(graph, size, key, -1, visited)) return true;
			}
		}
		return false;
	}

	public static boolean hasCycle(Map<Integer, List<Integer>> graph, int size, int node, int parent, int[] visited) {

		List<Integer> list = graph.containsKey(node) ? graph.get(node) : new ArrayList<>();
		for (Integer next : list) {
			if (visited[next]==0) {
				visited[next] = 1;
				if (hasCycle(graph, size, next, node, visited)) return true;
			} else if (next != parent && parent != -1) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		CycleInUndirectedGraph graph = new CycleInUndirectedGraph(5);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 3);
		graph.addEdge(1, 2);
		graph.addEdge(3, 4);
		boolean isCyclic = hasCycle(graph.graph, graph.size);
		System.out.println(isCyclic);
	}
}
