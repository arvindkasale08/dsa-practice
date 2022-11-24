package arvind.neetcode;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {

    public void wallsAndGates(int[][] maze) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] visited = new int[m][n];

        Queue<int[]> queue = new LinkedList<>();
        for (int i=0; i< m; i++) {
            for (int j=0; j<n; j++) {
                if (maze[i][j] == 0) {
                    visited[i][j] = 1;
                    queue.offer(new int[] {i, j, 0});
                }
            }
        }

        int[] DIR_I = {-1, 0, 1, 0};
        int[] DIR_J = {0, 1, 0, -1};

        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            int I = node[0];
            int J = node[1];
            int level = node[2];
            visited[I][J] = 1;
            for (int k=0; k<4; k++) {
                int newI = I + DIR_I[k];
                int newJ = J + DIR_J[k];

                if (newI >=0 && newI < m && newJ >=0 && newJ < n && visited[newI][newJ] == 0 && maze[newI][newJ] == 2147483647) {
                    visited[newI][newJ] = 1;
                    maze[newI][newJ] = Math.min(level+1, maze[newI][newJ]);
                    queue.offer(new int[] {newI, newJ, level+1});
                }
            }
        }
    }

    public static void main(String[] args) {
        WallsAndGates solution = new WallsAndGates();
        int[][] maze = new int[][] {{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
        solution.wallsAndGates(maze);
        System.out.println(maze);
    }
}
