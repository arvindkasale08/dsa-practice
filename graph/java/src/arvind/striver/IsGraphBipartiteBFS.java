package arvind.striver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class IsGraphBipartiteBFS {

	public boolean isBipartite(int V, int[][] edges) {
		List<List<Integer>> graph = new ArrayList<>();
		for (int i=0; i<=V; i++) {
			graph.add(i, new ArrayList<>());
		}

		for (int[] edge : edges) {
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}
		int[] color = new int[V+1];
		for (int i=1; i<=V; i++) {
			if (color[i] == 0) {
				if (!bfs(graph, i, color)) return false;
			}
		}
		return true;
	}

	private boolean bfs(List<List<Integer>> graph, int i, int[] color) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {i, 1});
		color[i] = 1; // coloring it blue

		while (!queue.isEmpty()) {
			int[] node = queue.poll();
			int I = node[0];
			int oldcolor = node[1];

			for (int next : graph.get(I)) {
				int newcolor = node[1] == 1 ? -1 : 1;
				if (color[next] == 0) {
					color[next] = newcolor;
					queue.offer(new int[] {next, newcolor});
				} else if (color[next] != newcolor) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		IsGraphBipartiteBFS solution = new IsGraphBipartiteBFS();
		int V = 9;
		int[][] edges = new int[][] {
			{1, 2},
			{2, 6},
			{2, 3},
			{3, 4},
			{4, 5},
			{4, 7},
			{7, 8},
			{6, 9},
			{9, 5}
		};
		boolean result = solution.isBipartite(V, edges);
		System.out.println(result);
	}
}
