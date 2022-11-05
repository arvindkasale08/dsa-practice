package arvind.striver;

import java.util.LinkedList;
import java.util.Queue;

public class DistanceNearestCellHaving1 {

	public int[][] findDistance(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] visited = new int[m][n];
		int[][] distance = new int[m][n];
		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			for (int j=0; j<n; j++) {
				if (grid[i][j] == 1) {
					visited[i][j] = 1;
					queue.add(new int[] {i, j, 0});
				}
			}
		}
		bfs(queue, grid, visited, distance);
		return distance;
	}

	private void bfs(Queue<int[]> queue, int[][] grid, int[][] visited, int[][] distance) {
		int m = grid.length;;
		int n = grid[0].length;
		int[] DIR_I = {-1, 0, 1, 0};
		int[] DIR_J = {0, 1, 0, -1};

		while (!queue.isEmpty()) {
			int[] node = queue.poll();
			int i = node[0];
			int j = node[1];
			int dist = node[2];
			visited[i][j] = 1;
			distance[i][j] = dist;

			for (int k = 0; k<4; k++) {
				int newI = i + DIR_I[k];
				int newJ = j + DIR_J[k];

				if (newI >=0 && newI < m && newJ >=0 && newJ < n && visited[newI][newJ] == 0 && grid[newI][newJ] == 0) {
					visited[newI][newJ] = 1;
					queue.offer(new int[] {newI, newJ, dist+1});
				}

			}
		}
	}

	public static void main(String[] args) {
		DistanceNearestCellHaving1 solution = new DistanceNearestCellHaving1();
		int[][] grid = new int[][]{
			{0, 0, 0},
			{0, 1, 0},
			{1, 0, 1}
		};
		int[][] distance = solution.findDistance(grid);
		System.out.println(distance);
	}
}
