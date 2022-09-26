package arvind;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

	public int findTime(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		int [][] visited = new int[m][n];
		int noOfFreshOranges = 0;
		Queue<int[]> queue = new LinkedList<>();
		for (int i=0; i< m; i++) {
			for (int j=0; j<n; j++) {
				if (matrix[i][j] == 2) {
					visited[i][j] = 1;
					queue.offer(new int[] {i, j, 0});
				}
				if (matrix[i][j] == 1) {
					noOfFreshOranges += 1;
				}
			}
		}
		return bfs(matrix, queue, noOfFreshOranges, m , n, visited);
	}

	private int bfs(int[][] matrix, Queue<int[]> queue, int noOfFreshOranges, int m, int n, int[][] visited) {
		int noOfFreshOrangesSeen = 0;
		int time = 0;
		int[] DIR_I = {-1, 0, 1, 0};
		int[] DIR_J = {0, 1, 0, -1};

		while (!queue.isEmpty()) {
			int[] cell = queue.poll();
			int I = cell[0];
			int J = cell[1];
			int t = cell[2];
			time = Math.max(time, t);

			for (int k=0; k<4; k++) {
				int new_I = I + DIR_I[k];
				int new_J = J + DIR_J[k];
				if (new_I > -1 && new_I < m && new_J > -1 && new_J < n && (matrix[new_I][new_J] == 2 || matrix[new_I][new_J] == 1) && visited[new_I][new_J] == 0 ) {
					if (matrix[new_I][new_J] == 1) {
						noOfFreshOrangesSeen += 1;
					}
					matrix[new_I][new_J] = 2;
					visited[new_I][new_J] = 1;

					queue.offer(new int[] {new_I, new_J, t+1});
				}
			}
		}

		return noOfFreshOrangesSeen == noOfFreshOranges ? time : -1;
	}

	public static void main(String[] args) {
		RottenOranges solution = new RottenOranges();
		int[][] matrix = new int[][] {
			{1, 2}
		};
		int time = solution.findTime(matrix);
		System.out.println("Time needed is "+ time);
	}
}
