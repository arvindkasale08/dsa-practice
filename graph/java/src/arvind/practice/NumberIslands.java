package arvind.practice;

import java.util.LinkedList;
import java.util.Queue;

public class NumberIslands {

	public int findIslands(int[][] matrix) {
		int counter = 0;
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] visited = new int[m][n];
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				if (visited[i][j] == 0 && matrix[i][j] == 1) {
					bfs(matrix, i, j, m, n, visited);
					counter++;
				}
			}
		}
		return counter;
	}

	private void bfs(int[][] matrix, int i, int j, int m, int n, int[][] visited) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {i, j});
		visited[i][j] = 1;
		int[] I_DIR = {1, 0, -1, 0};
		int[] J_DIR = {0, -1, 0, 1};

		while(!queue.isEmpty()) {
			int[] cell = queue.poll();
			int I = cell[0];
			int J = cell[1];

			for (int k=0; k<4; k++) {
				int new_I = I + I_DIR[k];
				int new_J = J + J_DIR[k];

				if (new_I > -1 && new_I < m && new_J > -1 && new_J < n && matrix[new_I][new_J] == 1 && visited[new_I][new_J] == 0) {
					visited[new_I][new_J] = 1;
					queue.offer(new int[]{new_I, new_J});
				}
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][] {
			{1, 1, 0, 0, 1},
			{1, 1, 0, 0, 0},
			{0, 0, 1, 0, 1},
			{1, 0, 0, 1, 1}
		};

		NumberIslands solution = new NumberIslands();
		int noOfIslands = solution.findIslands(matrix);
		System.out.println(noOfIslands);
	}
}
