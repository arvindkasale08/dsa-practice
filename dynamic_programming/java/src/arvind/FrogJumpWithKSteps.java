package arvind;

import java.util.Arrays;

public class FrogJumpWithKSteps {

    public int findMinimumEnergy(int[] heights, int n, int k) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        findMinimumEnergy(heights, n - 1, k, dp);
        return dp[dp.length - 1];
    }

    private int findMinimumEnergy(int[] heights, int index, int k, int[] dp) {
        if (index == 0) return 0;
        if (dp[index] != -1) return dp[index];
        int minenergy = Integer.MAX_VALUE;
        for (int i=1; i<=k; i++) {
            if (index - i >= 0) {
                int energy = findMinimumEnergy(heights, index - i, k, dp) + Math.abs(heights[index] - heights[index - i]);
                minenergy = Math.min(energy, minenergy);
            }
        }
        dp[index] = minenergy;
        return minenergy;
    }

    public static void main(String[] args) {
        int[] heights = {30, 10, 60, 10, 60, 50};
        int n = heights.length;
        int k = 2;
        FrogJumpWithKSteps solution = new FrogJumpWithKSteps();
        int energy = solution.findMinimumEnergy(heights, n, k);
        System.out.println(energy);
    }
}
