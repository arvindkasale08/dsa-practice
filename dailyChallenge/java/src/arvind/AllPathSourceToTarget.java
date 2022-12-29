package arvind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AllPathSourceToTarget {

	class Node {
		List<Integer> parent;
		int val;

		public Node(int val, List<Integer> parent) {
			this.val = val;
			this.parent = parent;
		}
	}


	public List<List<Integer>> allPaths(int[][] edges) {
		int V = edges.length;
		int[] indegree = new int[V];
		List<List<Integer>> result = new ArrayList<>();
		List<List<Integer>> graph = new ArrayList<>();
		for (int i=0; i<V; i++) {
			graph.add(i, new ArrayList<>());
		}
		for (int i=0; i<V; i++) {
			for (int node : edges[i]) {
				graph.get(i).add(node);
				indegree[node] += 1;
			}
		}

		Queue<Node> queue = new LinkedList<>();
		for (int i=0; i< V; i++) {
			if (indegree[i] == 0) {
				queue.offer(new Node(i, Arrays.asList(i)));
			}
		}

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			int i = node.val;
			List<Integer> parent = node.parent;

			if (graph.get(i).isEmpty()) {
				result.add(parent);
			}

			for (int neighbor : graph.get(i)) {
				indegree[neighbor] -= 1;
				if (indegree[neighbor] == 0) {
					List<Integer> p = new ArrayList<>(parent);
					p.add(neighbor);
					queue.offer(new Node(neighbor, p));
				}
			}
		}
		return null;
	}

	public static void main(String[] args) {
		int[][] graph = new int[][] {{1,2},{3},{3},{}};
		AllPathSourceToTarget solution = new AllPathSourceToTarget();
		List<List<Integer>> result = solution.allPaths(graph);
		System.out.println(result);
	}
}
