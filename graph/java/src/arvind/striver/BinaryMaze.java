package arvind.striver;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryMaze {

	public int findShortestDistance(int[][] maze, int i1, int j1, int i2, int j2) {
		int m = maze.length;
		int n = maze[0].length;
		int[][] distance = new int[m][n];
		for (int[] arr : distance) {
			Arrays.fill(arr, Integer.MAX_VALUE);
		}
		distance[i1][j1] = 0;
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {i1, j1, 0});
		int[] DIR_I = {-1, 0, 1, 0};
		int[] DIR_J = {0, 1, 0, -1};


		while (!queue.isEmpty()) {
			int[] node = queue.poll();
			int I = node[0];
			int J = node[1];
			int D = node[2];

			if (I == i2  && J == j2) {
				// answer
				return D;
			}

			for (int k=0; k<4; k++) {
				int newI = I + DIR_I[k];
				int newJ = J + DIR_J[k];

				if (newI >=0 && newI < m && newJ >=0 && newJ < n && maze[newI][newJ] == 1) {
					if (D+1 < distance[newI][newJ]) {
						distance[newI][newJ] = D+1;
						queue.offer(new int[] {newI, newJ, D+1});
					}
				}
			}

		}
		return -1;
	}

	public static void main(String[] args) {
		BinaryMaze solution = new BinaryMaze();
		int[][] maze = new int[][]
			{
				{1, 1, 1, 1},
				{1, 1, 0, 1},
				{1, 1, 1, 1},
				{1, 1, 0, 0},
				{1, 0, 0, 0}
			};
		int dist = solution.findShortestDistance(maze, 0, 1, 2, 2);
		System.out.println(dist);
	}
}
