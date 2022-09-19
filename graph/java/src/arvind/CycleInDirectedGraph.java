package arvind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CycleInDirectedGraph {

	private int size;
	private Map<Integer, List<Integer>> graph;

	public CycleInDirectedGraph(int size) {
		this.size = size;
		this.graph = new HashMap<>();
	}

	public void addEdge(int src, int dest) {
		if (!this.graph.containsKey(src)) {
			this.graph.put(src, new ArrayList<>());
		}
		this.graph.get(src).add(dest);
	}

	public boolean isCyclic() {
		int[] visited = new int[this.size];
		int[] pathvisited = new int[this.size];

		for (Integer key: this.graph.keySet()) {
			if (visited[key] == 0) {
				if (isCyclic(this.graph, this.size, key, visited, pathvisited)) return true;
			}
		}
		return false;
	}

	private boolean isCyclic(Map<Integer, List<Integer>> graph, int n, int node, int[] visited, int[] pathvisited) {
		visited[node] = 1;
		pathvisited[node] = 1;
		List<Integer> list = graph.containsKey(node) ? graph.get(node) : new ArrayList<>();
		for (Integer next: list) {
			if (visited[next] ==0) {
				if (isCyclic(graph, n, next, visited, pathvisited)) return true;
			} else if (pathvisited[next] == 1) {
				return true;
			}
		}
		pathvisited[node] = 0;
		return false;
	}

	public static void main(String[] args) {
		CycleInDirectedGraph graph = new CycleInDirectedGraph(8);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 7);
		//graph.addEdge(7, 1);
		graph.addEdge(3, 5);
		graph.addEdge(3, 4);
		graph.addEdge(6, 5);
		graph.addEdge(4, 6);
		boolean isCyclic = graph.isCyclic();
		System.out.println(isCyclic);
	}
}
