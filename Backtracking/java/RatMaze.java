public class RatMaze {
    static void printpathution(int path[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + path[i][j] + " ");
            System.out.println();
        }

    }

    static int N;

    static boolean isValid(int matrix[][], int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N && matrix[x][y] == 0);
    }

    static boolean findPath(int matrix[][]) {
        int path[][] = new int[N][N];
        if (findPathInMaze(matrix, 0, 0, path) == false) {
            System.out.print("pathution doesn't exist");
            return false;

        }
        printpathution(path);
        return true;

    }

    static boolean findPathInMaze(int matrix[][], int x, int y, int path[][]) {
        if (x == N - 1 && y == N - 1 && matrix[x][y] == 0) {
            path[x][y] = 1;
            return true;

        }
        if (isValid(matrix, x, y) == true) {
            path[x][y] = 1;
            if (findPathInMaze(matrix, x + 1, y, path))
                return true;
            if (findPathInMaze(matrix, x, y + 1, path))
                return true;
            path[x][y] = 0;
            return false;

        }
        return false;

    }

    public static void main(String args[]) {
        int matrix[][] = {{0, 1, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 0, 1, 0, 0},
                {1, 0, 0, 1, 0}};
        N = matrix.length;
        findPath(matrix);


    }
}

