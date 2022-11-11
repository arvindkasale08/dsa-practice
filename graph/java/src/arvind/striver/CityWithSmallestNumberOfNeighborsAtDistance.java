package arvind.striver;

import java.util.Arrays;

/**
 * Uses Flyod warshall
 * distance of each node from everynode
 */
public class CityWithSmallestNumberOfNeighborsAtDistance {

	public int findCity(int[][] edges, int V, int t) {
		int[][] matrix = new int[V][V];
		for (int[] m : matrix) {
			Arrays.fill(m, (int)10e8);
		}
		for (int i=0; i< V; i++) {
			matrix[i][i] = 0;
		}
		for (int[] edge : edges) {
			matrix[edge[0]][edge[1]] = edge[2];
			matrix[edge[1]][edge[0]] = edge[2];
		}

		for (int via = 0; via < V; via++) {
			for (int i=0; i<V; i++) {
				for (int j=0; j< V; j++) {
					matrix[i][j] = Math.min(matrix[i][j], matrix[i][via] + matrix[via][j]);
				}
			}
		}

		int minCity = V+1;
		int ans = -1;
		for (int i=0; i< V; i++) {
			int city = 0;
			for (int j=0; j< V; j++) {
				if (matrix[i][j] <= t) {
					city++;
				}
			}
			if (city <= minCity) {
				minCity = city;
				ans = i;
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		CityWithSmallestNumberOfNeighborsAtDistance solution = new CityWithSmallestNumberOfNeighborsAtDistance();
		int[][] edges = new int[][] {
			{0, 1, 3},
			{1, 2, 1},
			{1, 3, 4},
			{2, 3, 1}
		};
		int V = 4;
		int t = 4;
		int city = solution.findCity(edges, V, t);
		System.out.println(city);
	}
}
