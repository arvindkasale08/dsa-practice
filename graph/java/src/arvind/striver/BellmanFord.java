package arvind.striver;

import java.util.Arrays;

public class BellmanFord {

	public int[] findDistances(int V, int[][] edges, int src) {
		int[] distance = new int[V];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[src] = 0;

		for (int i=1; i<=V-1; i++) {
			for (int[] edge : edges) {
				int u = edge[0];
				int v = edge[1];
				int d = edge[2];
				if (distance[u] != Integer.MAX_VALUE) {
					if (distance[u] + d < distance[v]) {
						distance[v] = distance[u] + d;
					}
				}
			}
		}

		// to check if it has a cycle relax once more
		for (int[] edge : edges) {
			int u = edge[0];
			int v = edge[1];
			int d = edge[2];
			if (distance[u] != Integer.MAX_VALUE) {
				if (distance[u] + d < distance[v]) {
					int[] cycle = new int[V];
					Arrays.fill(cycle, -1);
					return cycle;
				}
			}
		}

		return distance;
	}

	public static void main(String[] args) {
		BellmanFord solution = new BellmanFord();
		int[][] edges = new int[][] {
			{3, 2, 6},
			{5, 3, 1},
			{0, 1, 5},
			{1, 5, -3},
			{1, 2, -2},
			{3, 4, -2},
			{2, 4, 3}
		};
		int V = 6;
		int src = 0;
		int[] weights = solution.findDistances(V, edges, src);
		System.out.println(Arrays.toString(weights));
	}
}
