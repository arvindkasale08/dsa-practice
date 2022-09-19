package arvind.practice;

import java.util.ArrayList;
import java.util.List;

public class RatMaze {

	public List<String> findPaths(int[][] maze, int n) {
		List<String> results = new ArrayList<>();
		int[][] visited = new int[n][n];
		// maze, n, i, j, results;
		findPaths(maze, n, 0, 0, visited, "", results);
		return results;
	}

	private boolean isSafe(int[][] maze, int n, int i, int j) {
		if (i < 0 || j < 0 || i > n-1 || j > n-1) {
			return false;
		}
		if (maze[i][j] == 0) {
			return false;
		}
		return true;
	}

	public void findPaths(int[][] maze, int n, int i, int j, int[][] visited, String path, List<String> results) {
		if (!isSafe(maze, n, i, j) || visited[i][j] == 1) {
			return;
		}
		if (i == n-1 && j == n-1) {
			results.add(path);
			return;
		}
		visited[i][j] = 1;
		// move in all possible direction
		// down
		findPaths(maze, n, i + 1, j, visited, path + "D", results);
		// left
		findPaths(maze, n, i, j-1, visited, path + "L", results);
		// right
		findPaths(maze, n, i, j+1, visited, path + "R", results);
		// up
		findPaths(maze, n, i - 1, j, visited, path + "U", results);
		visited[i][j] = 0;
	}

	public static void main(String[] args) {
		RatMaze solution = new RatMaze();
		int n = 4;
		int maze[][] = {
			{1, 0, 0, 0},
			{1, 1, 0, 1},
			{1, 1, 0, 0},
			{0, 1, 1, 1}
		};
		List<String> results = solution.findPaths(maze, n);
		System.out.println(results);
	}
}
