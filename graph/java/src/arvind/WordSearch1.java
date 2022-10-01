package arvind;

// Without a trie
public class WordSearch1 {

    public boolean doesContain(char[][] matrix, String word) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] visited = new int[m][n];
        char[] input = word.toCharArray();
        int index = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (visited[i][j] == 0 && matrix[i][j] == input[index]) {
                    visited[i][j]=1;
                    if (dfs(matrix, i, j, input, index, visited)) return true;
                    visited[i][j]=0;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] matrix, int i, int j, char[] input, int index, int[][] visited) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (index == input.length - 1) return true;
        int newIndex = index + 1;
        // actually per the question we cant go diagonally so only 4 directions are valid

        int[] DIR_I = {-1, 0, 1, 0};
        int[] DIR_J = {0, 1, 0, -1};

        //int[] DIR_I = {-1, -1, 0, 1, 1, 1, 0, -1};
        //int[] DIR_J = {0, 1, 1, 1, 0, -1, -1, -1};

        for (int k=0; k<4; k++) {
            int newI = i + DIR_I[k];
            int newJ = j + DIR_J[k];

            if (newI > -1 && newI < m && newJ > -1 && newJ < n && matrix[newI][newJ] == input[newIndex] && visited[newI][newJ] == 0) {
                visited[newI][newJ] = 1;
                if (dfs(matrix, newI, newJ, input, newIndex, visited)) return true;
                visited[newI][newJ] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //char[][] matrix = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        char[][] matrix = new char[][]{{'a','a'}};
        String word = "aaa";
        WordSearch1 solution = new WordSearch1();
        boolean result = solution.doesContain(matrix, word);
        System.out.println(result);
    }
}
