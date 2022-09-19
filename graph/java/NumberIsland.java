import java.util.*;
public class NumberIsland {
    public static int numIslands(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for (int i=0;i<m;i++){
            for (int j = 0;j<n;j++){
                if (!visited[i][j] && grid[i][j] == 1){
                    bfs(grid, i, j ,visited);
                    count++;
                }
            }
        }
        return count;
    }

    public static void bfs(int[][] grid, int i, int j,boolean[][] visited){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});

        while (!q.isEmpty()){
            int[] cell = q.poll();
            int X = cell[0];
            int Y = cell[1];
            visited[X][Y] = true;
            int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
            for (int[] dir : dirs){
                int nx = X + dir[0];
                int ny = Y + dir[1];
                if (nx >=0 && ny >=0 && nx < grid.length && ny < grid[0].length && !visited[nx][ny] && grid[nx][ny] == 1){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx,ny});
                }
            }
        }
    }

    public static void main(String[] args) {
        int arr[][] = new int[][] { { 1, 1, 0, 0, 0 },
                { 1, 1, 0, 0, 0 },
                { 0, 0, 1, 0, 0 },
                { 0, 0, 0, 1, 1 }};
        System.out.println("Number of islands is: " + numIslands(arr));
    }
}
