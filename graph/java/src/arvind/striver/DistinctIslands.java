package arvind.striver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class DistinctIslands {

	public int findDistinctIslandCount(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] visited = new int[m][n];
		Set<List<Integer>> result = new HashSet<>();

		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				if (visited[i][j] == 0 && grid[i][j] == 1) {
					result.add(bfs(i, j, m, n, grid, visited));
				}
			}
		}
		return result.size();
	}

	private List<Integer> bfs(int i, int j, int m, int n, int[][] grid, int[][] visited) {
		List<Integer> list = new ArrayList<>();
		Queue<int[]> queue = new LinkedList<>();
		// i, j
		queue.offer(new int[] {i, j});
		visited[i][j] = 1;
		list.add(i-i);
		list.add(j-j);
		int[] DIR_I = {-1, 0, 1, 0};
		int[] DIR_J = {0, 1, 0, -1};
		while(!queue.isEmpty()) {
			int[] node = queue.poll();
			int I = node[0];
			int J = node[1];

			for (int k=0; k<4; k++) {
				int newI = I + DIR_I[k];
				int newJ = J + DIR_J[k];
				if (newI >=0 && newI < m && newJ >=0 && newJ < n && visited[newI][newJ] == 0 && grid[newI][newJ] == 1) {
					visited[newI][newJ] = 1;
					queue.offer(new int[] {newI, newJ});
					list.add(newI - i);
					list.add(newJ - j);
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {
		DistinctIslands solution = new DistinctIslands();
		int[][] grid = new int[][] {
			{1, 1, 0, 1, 1},
			{1, 0, 0, 0, 0},
			{0, 0, 0, 0, 1},
			{1, 1, 0, 1, 1}
		};
		int count = solution.findDistinctIslandCount(grid);
		System.out.println(count);
	}
}
