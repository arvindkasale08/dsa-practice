package arvind.neetcode;

public class GridGame {

    public int gridGame(int[][] grid) {
        int n = grid[0].length;
        int[] row1Prefix = new int[n];
        int[] row2Prefix = new int[n];

        for (int i=0; i<n; i++) {
            row1Prefix[i] = grid[0][i];
            row2Prefix[i] = grid[1][i];
            if (i > 0) {
                row1Prefix[i] += row1Prefix[i-1];
                row2Prefix[i] += row2Prefix[i-1];
            }
         }

        int res = Integer.MAX_VALUE;

        for (int i=0; i<n; i++) {
            int top = i == n-1 ? 0 : row1Prefix[n-1] - row1Prefix[i];
            int bottom = i == 0 ? 0 : row2Prefix[i-1];
            int robot2 = Math.max(top, bottom);
            res = Math.min(robot2, res);
        }


        return res;
    }

    public static void main(String[] args) {
        GridGame solution = new GridGame();
        int[][] grid = new int[][] {{2,5,4},{1,5,1}};
        int result = solution.gridGame(grid);
        System.out.println(result);
    }
}
