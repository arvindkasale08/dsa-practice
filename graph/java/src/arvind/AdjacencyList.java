package arvind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AdjacencyList {

	private int size;
	private Map<Integer, List<Integer>> graph;

	public AdjacencyList(int size) {
		this.size = size;
		this.graph = new HashMap<>();
	}

	public void addEdge(int src, int dest) {
		if (!this.graph.containsKey(src)) {
			this.graph.put(src, new ArrayList<>());
		}
		this.graph.get(src).add(dest);
		// in case of undirected graph
		if (!this.graph.containsKey(dest)) {
			this.graph.put(dest, new ArrayList<>());
		}
		this.graph.get(dest).add(src);
	}

	public void printGraph() {
		for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
			System.out.print("Neighbours for vertex " +entry.getKey() + " are ");
			System.out.println(entry.getValue());
		}
	}

	public static void main(String[] args) {
		AdjacencyList list = new AdjacencyList(5);
		list.addEdge(0, 1);
		list.addEdge(0, 2);
		list.addEdge(0, 3);
		list.addEdge(2, 3);
		list.addEdge(2, 1);
		list.addEdge(2, 4);
		list.addEdge(1, 4);
		list.addEdge(3, 4);
		list.printGraph();
	}
}
