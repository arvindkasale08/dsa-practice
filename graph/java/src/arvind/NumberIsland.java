package arvind;

import java.util.LinkedList;
import java.util.Queue;

public class NumberIsland {

	public int findIslands(char[][] matrix) {
		// do a dfs or bfs on each node. Count the number of disconnected graphs
		int counter = 0;
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] visited = new int[m][n];
		for (int i=0; i< m; i++) {
			for (int j=0; j< n; j++) {
				if (visited[i][j] == 0 && matrix[i][j]== '1') {
					// do dfs / bfs
					findIslands(matrix, visited, i, j);
					counter+=1;
				}
			}
		}
		return counter;
	}

	// do bfs
	private void findIslands(char[][] matrix, int[][] visited, int i, int j) {
		int m = matrix.length;
		int n = matrix[0].length;
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {i, j});
		visited[i][j] = 1;

		while (!queue.isEmpty()) {
			int[] cell = queue.poll();
			int I = cell[0];
			int J = cell[1];
			int[] dir_I = {1, 0, -1, 0};
			int[] dir_J = {0, -1, 0, 1};
			visited[I][J] = 1;

			for (int k=0; k<4; k++) {
				int new_I = I + dir_I[k];
				int new_J = J + dir_J[k];
				if (new_I > -1 && new_I < m && new_J > -1 && new_J < n && matrix[new_I][new_J] == '1' && visited[new_I][new_J] == 0) {
					visited[new_I][new_J] = 1;
					queue.offer(new int[] {new_I, new_J});
				}
			}
		}
	}

	public static void main(String[] args) {
		char[][] matrix = {
			{'1', '1', '0', '0', '1'},
			{'1', '1', '0', '0', '0'},
			{'0', '0', '1', '0', '1'},
			{'0', '0', '0', '1', '1'}
		};
		NumberIsland solution = new NumberIsland();
		int numberOfIslands = solution.findIslands(matrix);
		System.out.println(numberOfIslands);
	}
}
