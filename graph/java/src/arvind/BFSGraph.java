package arvind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BFSGraph {

	private int size;
	private Map<Integer, List<Integer>> graph;

	public BFSGraph(int size) {
		this.size = size;
		this.graph = new HashMap<>();
	}

	public void addEdge(int src, int dest) {
		if (!this.graph.containsKey(src)) {
			this.graph.put(src, new ArrayList<>());
		}
		this.graph.get(src).add(dest);
	}

	public static List<Integer> bfs(BFSGraph graph) {
		List<Integer> bfsNode = new ArrayList<>();
		int[] visited = new int[graph.size];
		for (Integer key : graph.graph.keySet()) {
			if (visited[key] == 0) {
				Queue<Integer> queue = new LinkedList<>();
				queue.add(key);
				visited[key] = 1;
				while (!queue.isEmpty()) {
					int node = queue.poll();
					bfsNode.add(node);
					List<Integer> nodes = graph.graph.containsKey(node) ? graph.graph.get(node) : new ArrayList<>();
					for (Integer next : nodes) {
						if (visited[next] == 0) {
							visited[next] = 1;
							queue.add(next);
						}
					}
				}
			}
		}
		return bfsNode;
	}

	public static void main(String[] args) {
		BFSGraph graph = new BFSGraph(6);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(1, 4);
		graph.addEdge(0, 5);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);

		List<Integer> bfsNodes = bfs(graph);
		System.out.println(bfsNodes);
	}
}
