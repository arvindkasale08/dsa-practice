package arvind.neetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestBridge {

    public int shortestBridge(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        List<int[]> islandNodes = new ArrayList<>();
        outerloop:
        for (int i=0; i< m ; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    dfs(i, j, grid, visited, islandNodes);
                    break outerloop;
                }
            }
        }

        // perform a multisource bfs
        return bfs(grid, visited, islandNodes);
    }

    private int bfs(int[][] grid, int[][] visited, List<int[]> islandNodes) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int[] node : islandNodes) {
            queue.offer(new int[] {node[0], node[1], 0});
            visited[node[0]][node[1]] = 1;
        }
        int[] DIR_I = {-1, 0, 1, 0};
        int[] DIR_J = {0, 1, 0, -1};
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int I = node[0];
            int J = node[1];
            int level = node[2];

            for (int k = 0; k<4; k++) {
                int newI = I + DIR_I[k];
                int newJ = J + DIR_J[k];
                if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && visited[newI][newJ] == 0) {
                    if (grid[newI][newJ] == 1) {
                        return level;
                    }
                    visited[newI][newJ] = 1;
                    queue.offer(new int[] {newI, newJ, level+1});
                }
            }
        }
        return -1;
    }

    private void dfs(int i, int j, int[][] grid, int[][] visited, List<int[]> islandNodes) {
        int m = grid.length;
        int n = grid[0].length;
        visited[i][j] = 1;
        islandNodes.add(new int[] {i, j});
        int[] DIR_I = {-1, 0, 1, 0};
        int[] DIR_J = {0, 1, 0, -1};

        for (int k=0; k< 4; k++) {
            int newI = i + DIR_I[k];
            int newJ = j + DIR_J[k];
            if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && visited[newI][newJ] == 0 && grid[newI][newJ] == 1) {
                dfs(newI, newJ, grid, visited, islandNodes);
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = new int[][] {
                {0, 1, 0, 0, 0},
                {0, 1, 0, 0, 0},
                {1, 1, 0, 0, 1},
                {0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1}
        };
        ShortestBridge solution = new ShortestBridge();
        int noOfFlips = solution.shortestBridge(grid);
        System.out.println(noOfFlips);
    }
}
