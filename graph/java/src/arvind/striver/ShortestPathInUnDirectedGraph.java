package arvind.striver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathInUnDirectedGraph {

	public int[] findDistance(int V, int[][] edges, int src) {
		List<List<Integer>> graph = new ArrayList<>();
		for (int i=0; i<V; i++) {
			graph.add(i, new ArrayList<>());
		}
		for (int[] edge : edges) {
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}
		int[] distance = new int[V];
		Arrays.fill(distance, -1);
		distance[src] = 0;
		bfs(src, graph, distance);
		return distance;
	}

	private void bfs(int src, List<List<Integer>> graph, int[] distance) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {src, 0});

		while (!queue.isEmpty()) {
			int[] node = queue.poll();
			int i = node[0];
			int d = node[1];
			for (int next : graph.get(i)) {
				int newD = d + 1;
				if (distance[next] == -1 || distance[next] > newD) {
					distance[next] = newD;
					queue.offer(new int[]{next, newD});
				}
			}
		}
	}

	public static void main(String[] args) {
		ShortestPathInUnDirectedGraph solution = new ShortestPathInUnDirectedGraph();
		int V = 9;
		int[][] edges = new int[][] {
			{0, 1},
			{0, 3},
			{3, 4},
			{1, 2},
			{4, 5},
			{5, 6},
			{2, 6},
			{6, 7},
			{7, 8},
			{6, 8}
		};
		int src = 0;
		int[] distance = solution.findDistance(V, edges, src);
		System.out.println(distance);
	}
}
