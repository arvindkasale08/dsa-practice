package arvind.neetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PacificAtlanticIsland {

	public List<List<Integer>> pacificAtlantic(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		List<List<Integer>> result = new ArrayList<>();
		int[][] pacific = new int[m][n];
		int[][] atlantic = new int[m][n];
		for (int j=0; j<n; j++) {
			bfs(0, j, matrix, pacific);
		}
		for (int i=0; i<m; i++) {
			bfs(i, 0, matrix, pacific);
		}
		for (int j=0; j<n; j++) {
			bfs(m-1, j, matrix, atlantic);
		}
		for (int i=0; i<m; i++) {
			bfs(i, n-1, matrix, atlantic);
		}

		for (int i=0; i< m; i++) {
			for (int j=0; j<n; j++) {
				if (pacific[i][j] == 1 && atlantic[i][j] == 1) {
					List<Integer> list = Arrays.asList(i, j);
					result.add(list);
				}
			}
		}

		return result;
	}

	private void bfs(int i, int j, int[][] matrix, int[][] visited) {
		int m = matrix.length;
		int n = matrix[0].length;
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {i, j});
		visited[i][j] = 1;
		int[] DIR_I = {-1, 0, 1, 0};
		int[] DIR_J = {0, 1, 0, -1};
		while (!queue.isEmpty()) {
			int[] node = queue.poll();
			int I = node[0];
			int J = node[1];

			for (int k=0; k<4; k++) {
				int newI = I + DIR_I[k];
				int newJ = J + DIR_J[k];

				if (newI >=0 && newI < m && newJ >=0 && newJ < n && visited[newI][newJ] == 0 && matrix[newI][newJ] >= matrix[I][J]) {
					visited[newI][newJ] = 1;
					queue.offer(new int[] {newI, newJ});
				}
			}
		}
	}

	public static void main(String[] args) {
		PacificAtlanticIsland solution = new PacificAtlanticIsland();
		int[][] matrix = {
			{1, 2, 2, 3, 5},
			{3, 2, 3, 4, 4},
			{2, 4, 5, 3, 1},
			{6, 7, 1, 4, 5},
			{5, 1, 1, 2, 4}
		};
		List<List<Integer>> result = solution.pacificAtlantic(matrix);
		System.out.println(result);
	}
}
