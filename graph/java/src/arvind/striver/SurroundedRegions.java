package arvind.striver;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {

	public void replace(char[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] visited = new int[m][n];
		Queue<int[]> queue = new LinkedList<>();
		for (int i =0; i<m; i++) {
			for (int j=0; j<n; j++) {
				if (isborder(i, j, m, n) && grid[i][j] == 'O') {
					queue.offer(new int[] {i, j});
				}
			}
		}
		bfs(grid, queue, visited);
		fill(grid, visited);
	}

	private void fill(char[][] grid, int[][] visited) {
		for (int i=0; i< grid.length; i++) {
			for (int j=0; j< grid[0].length; j++) {
				if (visited[i][j] == 0 && grid[i][j] == 'O') {
					grid[i][j] = 'X';
				}
			}
		}
	}

	private void bfs(char[][] grid, Queue<int[]> queue, int[][] visited) {
		int m = grid.length;
		int n = grid[0].length;
		int[] DIR_I = {-1, 0, 1, 0};
		int[] DIR_J = {0, 1, 0, -1};
		while(!queue.isEmpty()) {
			int[] node = queue.poll();
			int I = node[0];
			int J = node[1];
			visited[I][J] = 1;

			for (int k=0; k<4; k++) {
				int newI = I + DIR_I[k];
				int newJ = J + DIR_J[k];

				if (newI >=0 && newI < m && newJ >=0 && newJ < n && grid[newI][newJ] == 'O' && visited[newI][newJ] == 0) {
					visited[newI][newJ] = 1;
					queue.offer(new int[] {newI, newJ});
				}
			}
		}
	}

	private boolean isborder(int i, int j, int m, int n) {
		return (i == 0 || j == 0 || i == m - 1 || j == n - 1);
	}

	public static void main(String[] args) {
		SurroundedRegions solution = new SurroundedRegions();
		char[][] grid = new char[][] {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};

		solution.replace(grid);
		System.out.println(grid);
	}
}
