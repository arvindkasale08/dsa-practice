package arvind.striver;

import java.util.ArrayList;
import java.util.List;

public class IsGraphBipartiteDFS {

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
				// graph, node, initcolor, color array
				if (!dfs(graph, i, 1, color)) return false;
			}
		}
		return true;
	}

	private boolean dfs(List<List<Integer>> graph, int i, int currentColor, int[] color) {

		color[i] = currentColor;
		for (int next : graph.get(i)) {
			int nextColor = currentColor == 1 ? -1 : 1;
			if (color[next] == 0) {
				color[next] = nextColor;
				if (!dfs(graph, next, nextColor, color)) return false;
			} else if (color[next] != nextColor) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		IsGraphBipartiteDFS solution = new IsGraphBipartiteDFS();
		int V = 9;
		int[][] edges = new int[][] {
			{1, 2},
			{2, 6},
			{2, 3},
			{3, 4},
			{4, 5},
			{5, 6},
			{4, 7},
			{7, 8},
			//{6, 9},
			//{9, 5}
		};
		boolean result = solution.isBipartite(V, edges);
		System.out.println(result);
	}
}
