package arvind.striver;

public class NumberOfProvincesLC {

	public int findProvinces(int[][] grid) {
		int[][] visited = new int[grid.length][grid[0].length];
		int components = 0;
		for (int i=0; i< grid.length; i++) {
			for (int j=0; j< grid[0].length; j++) {
				if (visited[i][j] == 0 && grid[i][j] == 1) {
					visited[i][j] = 1;
					components +=1;
					dfs(grid, i, j, visited);
				}
			}
		}
		return components;
	}

	private void dfs(int[][] grid, int i, int j, int[][] visited) {
		visited[i][j] = 1;
		int[] DIR_I = {-1, 0, 1, 0};
		int[] DIR_J = {0, 1, 0, -1};

		for (int k=0; k<4; k++) {
			int NEW_I = i + DIR_I[k];
			int NEW_J = j + DIR_J[k];
			if (NEW_I >= 0 && NEW_I < grid.length && NEW_J >=0 && NEW_J < grid[0].length && visited[NEW_I][NEW_J] == 0 && grid[NEW_I][NEW_J] == 1) {
				visited[NEW_I][NEW_J] = 1;
				dfs(grid, NEW_I, NEW_J, visited);
			}
		}
	}

	public static void main(String[] args) {
		NumberOfProvincesLC solution = new NumberOfProvincesLC();
		int[][] grid = new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
		int result = solution.findProvinces(grid);
		System.out.println(result);
	}
}
