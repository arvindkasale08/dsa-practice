package arvind.neetcode;

public class CheckIfMoveIsLegal {

    public boolean checkMove(char[][] grid, int rmove, int cmove, char color) {
        int m = grid.length;
        int n = grid[0].length;
        // do a dfs
        int[] DIR_I = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] DIR_J = {0, 1, 1, 1, 0, -1, -1, -1};

        for (int k=0; k<8; k++) {
            int offsetI = DIR_I[k];
            int offsetJ = DIR_J[k];
            if (dfs(rmove, cmove, grid, offsetI, offsetJ, color, 0)) return true;
        }
        return false;
    }

    private boolean dfs(int i, int j, char[][] grid, int offsetI, int offsetJ, char color, int nodes) {
        if (isTerminal(i+offsetI, j+offsetJ, grid)) {
            if (grid[i][j] == color) {
                if (nodes >= 2) {
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }
        if (nodes != 0) {
            if (grid[i][j] == color || grid[i][j] == '.') {
                return false;
            }
        }
        return dfs(i+offsetI, j+ offsetJ, grid, offsetI, offsetJ, color, nodes + 1);
    }

    private boolean isTerminal(int i, int j, char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        return i< 0 || i >= m || j < 0 || j >= n;
    }

    public static void main(String[] args) {
        CheckIfMoveIsLegal solution = new CheckIfMoveIsLegal();
        char[][] grid = new char[][] {{'.','.','.','B','.','.','.','.'},{'.','.','.','W','.','.','.','.'},{'.','.','.','W','.','.','.','.'},{'.','.','.','W','.','.','.','.'},{'W','B','B','.','W','W','W','B'},{'.','.','.','B','.','.','.','.'},{'.','.','.','B','.','.','.','.'},{'.','.','.','W','.','.','.','.'}};
        int rmove = 4;
        int cmove = 3;
        char color = 'B';
        boolean result = solution.checkMove(grid, rmove, cmove, color);
        System.out.println(result);
    }
}
