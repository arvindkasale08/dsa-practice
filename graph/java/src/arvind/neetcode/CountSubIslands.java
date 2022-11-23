package arvind.neetcode;

import java.util.LinkedList;
import java.util.Queue;

public class CountSubIslands {

	public int countSubIslands(int[][] grid1, int[][] grid2) {
		int m = grid1.length;
		int n = grid1[0].length;
		int[][] visited = new int[m][n];

		int count = 0;
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				if (visited[i][j] == 0 && grid2[i][j] == 1) {
					visited[i][j] = 1;
					if (bfs(i, j, m, n, visited, grid2, grid1)) {
						count+=1;
					}
				}
			}
		}
		return count;
	}

	private boolean bfs(int i, int j, int m, int n, int[][] visited, int[][] grid2, int[][] ref) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {i, j});
		visited[i][j] = 1;
		boolean isSubIsland = true;
		int[] DIR_I = {-1, 0, 1, 0};
		int[] DIR_J = {0, 1, 0, -1};
		while(!queue.isEmpty()) {
			int[] node = queue.poll();
			int I = node[0];
			int J = node[1];
			if (ref[I][J] == 0)
				isSubIsland = false;

			for (int k=0; k<4; k++) {
				int newI = I + DIR_I[k];
				int newJ = J + DIR_J[k];
				if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && visited[newI][newJ] == 0 && grid2[newI][newJ] == 1) {
					visited[newI][newJ] = 1;
					queue.offer(new int[] {newI, newJ});
				}
			}

		}

		return isSubIsland;
	}

	public static void main(String[] args) {
		CountSubIslands solution = new CountSubIslands();
		int[][] grid1 = new int[][] {
			{1, 1, 1, 0, 0},
			{0, 1, 1, 1, 1},
			{0, 0, 0, 0, 0},
			{1, 0, 0, 0, 0},
			{1, 1, 0, 1, 1}
		};

		int[][] grid2 = new int[][] {
			{1, 1, 1, 0, 0},
			{0, 0, 1, 1, 1},
			{0, 1, 0, 0, 0},
			{1, 0, 1, 1, 0},
			{0, 1, 0, 1, 0}
		};
		int subislands = solution.countSubIslands(grid1, grid2);
		System.out.println(subislands);
	}
}
