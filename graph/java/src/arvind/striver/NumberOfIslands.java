package arvind.striver;


import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

	public int findIslands(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int islands = 0;
		int[][] visited = new int[m][n];
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				if (visited[i][j] == 0 && grid[i][j] == 1) {
					bfs(i, j, visited, grid);
					islands += 1;
				}
			}
		}
		return islands;
	}

	private void bfs(int i, int j, int[][] visited, int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {i, j});
		visited[i][j] = 1;
		int[] DIR_I = {-1, -1, 0, 1, 1, 1, 0, -1};
		int[] DIR_J = {0, 1, 1, 1, 0, -1, -1 , -1};

		while (!queue.isEmpty()) {
			int[] node = queue.poll();
			int I = node[0];
			int J = node[1];
			visited[I][J] = 1;

			for (int k=0; k<8; k++) {
				int newI = I + DIR_I[k];
				int newJ = J + DIR_J[k];
				if (newI >=0 && newI < m && newJ >= 0 && newJ < n && grid[newI][newJ] == 1 && visited[newI][newJ] == 0) {
					visited[newI][newJ] = 1;
					queue.offer(new int[] {newI, newJ});
				}
			}
		}
	}

	public static void main(String[] args) {
		NumberOfIslands solution = new NumberOfIslands();
		int[][] grid = new int[][] {
			{0, 1, 1, 0},
			{0, 1, 1, 0},
			{0, 0, 1, 0},
			{0, 0, 0, 0},
			{1, 1, 0, 1}
		};
		int islands = solution.findIslands(grid);
		System.out.println(islands);
	}
}
