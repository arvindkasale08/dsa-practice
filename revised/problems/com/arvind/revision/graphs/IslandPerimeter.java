package com.arvind.revision.graphs;

public class IslandPerimeter {

    public int islandPerimeter(int[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (visited[i][j] == 0) {
                    if (grid[i][j] == 1) {
                        count += dfs(i, j, m, n, visited, grid);
                    }
                }
            }
        }
        return count;
    }

    private int dfs(int i, int j, int m, int n, int[][] visited, int[][] grid) {
        if (i<0 || i>=m || j<0 || j>=n) return 1;
        if (grid[i][j] == 0) return 1;
        if (visited[i][j] == 1) return 0;
        visited[i][j] = 1;

        return dfs(i-1, j, m, n, visited, grid)
                + dfs(i, j+1, m, n, visited, grid)
                + dfs(i+1, j, m, n, visited, grid)
                + dfs(i, j-1, m, n, visited, grid);

    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };
        IslandPerimeter solution = new IslandPerimeter();
        System.out.println(solution.islandPerimeter(grid));
    }
}
