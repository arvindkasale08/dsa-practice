package arvind;

public class MatrixChainMultiplication {

    static int iterations = 0;
    public int findCostOfMultiplication(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];
        // prepop with -1
        for (int i=0 ; i < dp.length; i++) {
            for (int j = 0; j<dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return findCostOfMultiplication(arr, 1, arr.length - 1, dp);
    }

    private int findCostOfMultiplication(int[] arr, int i, int j, int[][] dp) {
        if (i == j) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        iterations += 1;
        int result = Integer.MAX_VALUE;
        for (int k=i; k<j; k++) {
            int leftAns = findCostOfMultiplication(arr, i, k, dp);
            int rightAns = findCostOfMultiplication(arr, k+1, j, dp);
            int cost = arr[i-1] * arr[k] * arr[j];
            result = Math.min(result, (leftAns + rightAns + cost));
        }
        System.out.println(iterations);
        dp[i][j] = result;
        return result;
    }

    public static void main(String[] args) {
        MatrixChainMultiplication solution = new MatrixChainMultiplication();
        //int[] arr = new int[] { 40, 20, 30, 10, 30};

        int[] arr = new int[] {1, 2, 3, 4, 3};

        int result = solution.findCostOfMultiplication(arr);
        //expected output = 26000
        System.out.println(result);
    }
}
