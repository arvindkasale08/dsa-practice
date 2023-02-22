package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {

    public int minimumTotalMemoDP(List<List<Integer>> list) {
        int m = list.size();
        int n = m;
        int[][] dp = new int[m][n];

        // base case last row
        for (int i=0; i<n; i++) {
            dp[m-1][i] = list.get(m-1).get(i);
        }

        for (int i=m-2; i>=0; i--) {
            for (int j=0; j<=i; j++) {
                int down = list.get(i).get(j) + dp[i+1][j];
                int downRight = list.get(i).get(j) + dp[i+1][j+1];

                // take minimum of both paths
                dp[i][j] = Math.min(down, downRight);
            }
        }

        return dp[0][0];
    }

    public int minimumTotalMemo(List<List<Integer>> list) {
        int m = list.size();
        int n = m;
        int[][] memo = new int[m][n];
        for (int[] a : memo) {
            Arrays.fill(a, -1);
        }
        return minimumTotalMemo(0, 0, m, n, memo, list);
    }

    private int minimumTotalMemo(int i, int j, int m, int n, int[][] memo, List<List<Integer>> list) {
        // last row
        if (i == m-1 && j <= i) {
            return memo[i][j] = list.get(i).get(j);
        }

        if (i >= m || j > i) {
            return memo[i][j] = 100000; // big number to make this path invalid
        }

        // we have two option
        int down = list.get(i).get(j) + minimumTotalMemo(i+1, j, m, n, memo, list);
        int downRight = list.get(i).get(j) + minimumTotalMemo(i+1, j+1, m, n, memo, list);

        // take minimum of both paths
        return memo[i][j] = Math.min(down, downRight);
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(2));
        list.add(Arrays.asList(3, 4));
        list.add(Arrays.asList(6, 5, 7));
        list.add(Arrays.asList(4, 1, 8, 3));

        Triangle solution = new Triangle();
        int res = solution.minimumTotalMemo(list);
        int res2 = solution.minimumTotalMemoDP(list);
        System.out.println(res);
        System.out.println(res2);
    }
}
