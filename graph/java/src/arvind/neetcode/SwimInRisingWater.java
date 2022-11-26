package arvind.neetcode;

import java.util.PriorityQueue;

public class SwimInRisingWater {

	public int swimInWater(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] visited = new int[m][n];

		// Do a modified Djikstra where the priority is max in path so far;
		PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
		queue.offer(new int[] {0, 0, grid[0][0]}); // start from 0,0,0;
		visited[0][0] = 1;

		int[] DIR_I = new int[] {-1, 0, 1, 0};
		int[] DIR_J = new int[] {0, 1, 0, -1};
		while (!queue.isEmpty()) {
			int[] node = queue.poll();
			int i = node[0];
			int j = node[1];
			int maxSoFar = node[2];
			if (i == m-1 && j == n-1) {
				return Math.max(maxSoFar, grid[i][j]);
			}

			visited[i][j] = 1;
			for (int k=0; k<4; k++) {
				int newI = i + DIR_I[k];
				int newJ = j + DIR_J[k];
				if (newI >=0 && newI < m && newJ >=0 && newJ < n && visited[newI][newJ] == 0) {
					visited[newI][newJ] = 1;
					int maxSoFarNew = Math.max(maxSoFar, grid[newI][newJ]);
					queue.offer(new int[] {newI, newJ, maxSoFarNew});
				}
			}

		}
		return -1;
	}

	public static void main(String[] args) {
		SwimInRisingWater solution = new SwimInRisingWater();
		int[][] grid = new int[][]{{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}};
		int result = solution.swimInWater(grid);
		System.out.println(result);
	}
}
