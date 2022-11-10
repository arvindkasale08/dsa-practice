package arvind.striver;

import java.util.Arrays;

public class FloydWarshall {

	public int findDistance(int V, int src, int dest, int[][] edges) {
		int[][] matrix = new int[V][V];
		for (int[] m : matrix) {
			Arrays.fill(m, 1000000000);
		}
		for (int i=0; i< V; i++) {
			matrix[i][i] = 0;
		}
		for (int[] edge : edges) {
			matrix[edge[0] -1][edge[1] - 1] = edge[2];
		}

		for (int via=0; via<V; via++) {
			for (int i=0; i< matrix.length; i++) {
				for (int j=0; j<matrix[0].length; j++) {
					if (matrix[i][via] != 1000000000 && matrix[via][j] != 1000000000) {
						matrix[i][j] = Math.min(matrix[i][j], matrix[i][via] + matrix[via][j]);
					}
				}
			}
		}

		return matrix[src-1][dest-1];
	}

	public static void main(String[] args) {
		FloydWarshall solution = new FloydWarshall();
		int[][] edges = new int[][] {
			{1, 2, 2},
			{1, 3, 2},
			{2, 3, -1}
		};
		int V = 3;
		int src = 1;
		int dest = 3;
		int distance = solution.findDistance(V, src, dest, edges);
		System.out.println(distance);
	}
}
