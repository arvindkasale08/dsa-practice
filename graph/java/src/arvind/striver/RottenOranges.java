package arvind.striver;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

	public int findTimeToRot(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] visited = new int[m][n];

		Queue<int[]> queue = new LinkedList<>();
		int noOfOnesPresent = 0;
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				if (grid[i][j] == 1) {
					noOfOnesPresent+=1;
				}
				if (grid[i][j] == 2) {
					queue.offer(new int[] {i, j, 0});
					visited[i][j] = 1;
 				}
			}
		}
		return bfs(queue, grid, visited, noOfOnesPresent);
	}

	private int bfs(Queue<int[]> queue, int[][] grid, int[][] visited, int noOfOnesPresent) {
		int m = grid.length;
		int n = grid[0].length;
		int time = 0;
		int noOfOnesSeen = 0;
		int[] DIR_I = {-1, 0, 1, 0};
		int[] DIR_J = {0, 1, 0, -1};
		while (!queue.isEmpty()) {
			int[] node = queue.poll();
			int I = node[0];
			int J = node[1];
			int t = node[2];
			visited[I][J] = 1;
			time = Math.max(time, t);

			for (int k =0; k<4; k++) {
				int newI = I + DIR_I[k];
				int newJ = J + DIR_J[k];

				if (newI >= 0 && newI < m && newJ >=0 && newJ < n && visited[newI][newJ] == 0 && grid[newI][newJ] == 1) {
					visited[newI][newJ] = 1;
					queue.offer(new int[] {newI, newJ, t+1});
					noOfOnesSeen +=1;
				}
			}

		}

		return noOfOnesPresent == noOfOnesSeen ? time : -1;
	}

	public static void main(String[] args) {
		RottenOranges solution = new RottenOranges();
		int[][] grid = new int[][] {
			{2, 1, 1},
			{1, 1, 0},
			{0, 1, 1}
		};

		int time = solution.findTimeToRot(grid);
		System.out.println(time);
	}
}
