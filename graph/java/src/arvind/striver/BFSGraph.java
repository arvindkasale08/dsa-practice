package arvind.striver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSGraph {

	public List<Integer> bfs(int vertex, int[][] edges) {
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
		int[] visited = new int[vertex];
		List<Integer> result = new ArrayList<>();
		for (int i=0 ; i < vertex; i++) {
			if (visited[i] == 0)
				bfs(graph, i, visited, result);
		}
		return result;
	}

	private void bfs(List<List<Integer>> graph, int node, int[] visited, List<Integer> result) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(node);
		visited[node] = 1;
		while (!queue.isEmpty()) {
			int n = queue.poll();
			result.add(n);
			for (int next : graph.get(n)) {
				if (visited[next] == 0) {
					visited[next] = 1;
					queue.offer(next);
				}
			}
		}
	}

	public static void main(String[] args) {
		int vertex = 4;
		int[][] edges = new int[][] {
			{0, 1},
			{0, 3},
			{1, 2},
			{3, 2}
		};
		BFSGraph solution = new BFSGraph();
		List<Integer> result = solution.bfs(vertex, edges);
		System.out.println(result);
	}
}
