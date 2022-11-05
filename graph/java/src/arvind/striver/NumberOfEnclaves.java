package arvind.striver;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {

	public int find(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] visited = new int[m][n];
		Queue<int[]> queue = new LinkedList<>();
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				if (isborder(i, j, m, n) && grid[i][j] == 1) {
					queue.offer(new int[] {i, j});
				}
			}
		}
		bfs(grid, queue, visited, m, n);
		// count enclaves
		int count = 0;
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				if (grid[i][j] == 1 && visited[i][j] == 0)
					count+=1;
			}
		}

		return count;
	}

	private void bfs(int[][] grid, Queue<int[]> queue, int[][] visited, int m, int n) {
		int[] DIR_I = {-1, 0, 1, 0};
		int[] DIR_J = {0, 1, 0, -1};


		while (!queue.isEmpty()) {
			int[] node = queue.poll();
			int I = node[0];
			int J = node[1];
			visited[I][J] = 1;

			for (int k =0; k < 4; k++) {
				int newI = I + DIR_I[k];
				int newJ = J + DIR_J[k];

				if (newI >=0 && newI < m && newJ >=0 && newJ < n && visited[newI][newJ] == 0 && grid[newI][newJ] == 1) {
					visited[newI][newJ] = 1;
					queue.offer(new int[] {newI, newJ});
				}
			}
		}
	}

	private boolean isborder(int i, int j, int m, int n) {
		return (i==0 || j ==0 || i == m-1 || j == n-1);
	}

	public static void main(String[] args) {
		NumberOfEnclaves solution = new NumberOfEnclaves();
		int[][] grid = new int[][] {
			{0, 0, 0, 0},
			{1, 0, 1, 0},
			{0, 1, 1, 0},
			{0, 0, 0, 0}
		};
		int numberOfEnclaves = solution.find(grid);
		System.out.println(numberOfEnclaves);
	}
}
