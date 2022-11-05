package arvind.striver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CycleInUndirectedGraphBFS {

	public boolean hasCycle(int[][] edges, int V) {
		List<List<Integer>> graph = new ArrayList<>();
		for (int i=0; i<=V; i++) {
			graph.add(i, new ArrayList<>());
		}
		for (int[] edge : edges) {
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}

		int[] visited = new int[V+1];

		for (int i=1; i<=V; i++) {
			if (visited[i] == 0) {
				if (bfs(graph, i, visited)) return true;
			}
		}
		return false;
	}

	private boolean bfs(List<List<Integer>> graph, int i, int[] visited) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {i, -1});
		visited[i] = 1;

		while (!queue.isEmpty()) {
			int[] val = queue.poll();
			int node = val[0];
			int parent = val[1];
			visited[node] = 1;

			for (int neighbor : graph.get(node)) {
				if (visited[neighbor] == 1 && parent != neighbor) {
					return true;
				}
				if (visited[neighbor] == 0) {
					visited[neighbor] = 1;
					queue.offer(new int[] {neighbor, node});
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		CycleInUndirectedGraphBFS solution = new CycleInUndirectedGraphBFS();
		int V = 7;
		int[][] edges = new int[][] {
			{1,2},
			{1, 3},
			{2, 5},
			{5, 7},
			{6, 7},
			{3, 6},
			{3, 4}
		};
		boolean hasCycle = solution.hasCycle(edges, V);
		System.out.println(hasCycle);
	}
}
