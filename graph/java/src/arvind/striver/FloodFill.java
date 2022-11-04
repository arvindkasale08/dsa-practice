package arvind.striver;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {

	public void floodfill(int[][] grid, int x, int y, int newColor) {
		int m = grid.length;
		int n = grid[0].length;
		int initColor = grid[x][y];
		int[][] visited = new int[m][n];
		floodfill(grid, x, y, initColor, newColor, visited);
	}

	private void floodfill(int[][] grid, int x, int y, int initColor, int newColor, int[][] visited) {
		int m = grid.length;
		int n = grid[0].length;
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x, y});
		grid[x][y] = newColor;
		visited[x][y] = 1;
		int[] DIR_I = {-1, 0, 1, 0};
		int[] DIR_J = {0, 1, 0, -1};
		while(!queue.isEmpty()) {
			int[] node = queue.poll();
			int I = node[0];
			int J = node[1];
			visited[I][J] = 1;
			grid[I][J] = newColor;

			for (int k=0; k<4; k++) {
				int newI = I + DIR_I[k];
				int newJ = J + DIR_J[k];

				if (newI >= 0 && newI < m && newJ >=0 && newJ < n && visited[newI][newJ] == 0 && grid[newI][newJ] == initColor) {
					visited[newI][newJ] = 1;
					grid[newI][newJ] = newColor;
					queue.offer(new int[] {newI, newJ});
				}
			}

		}
		System.out.println(grid);
	}

	public static void main(String[] args) {
		FloodFill solution = new FloodFill();
		int[][] grid = new int[][] {
			{1, 1, 1},
			{1, 1, 0},
			{1, 0, 1}
		};
		int x = 1;
		int y = 1;
		int newColor = 2;
		solution.floodfill(grid, x, y, newColor);
	}
}
