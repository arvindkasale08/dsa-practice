package arvind;

import java.util.Arrays;

public class FrogJump {


    public int findEnergyTab(int n, int[] heights) {
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = Math.abs(heights[0] - heights[1]);
        for (int i=2; i<n; i++) {
            dp[i] = Math.min((dp[i-1] + Math.abs(heights[i] - heights[i-1])), (dp[i-2] + Math.abs(heights[i] - heights[i-2])));
        }
        return dp[dp.length - 1];
    }
    public int findEnergy(int n, int[] heights) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int energy = findEnergy(n - 1, heights, dp);
        return energy;
    }

    private int findEnergy(int index, int[] heights, int[] dp) {
        if (index == 0)
            return 0;
        if (dp[index] != -1) return dp[index];
        int once = findEnergy(index - 1, heights, dp) + Math.abs(heights[index] - heights[index-1] );
        if (index > 1) {
            int twice = findEnergy(index - 2, heights, dp) + Math.abs(heights[index] - heights[index - 2]);
            dp[index] = Math.min(once, twice);
        } else {
            dp[index] = once;
        }
        return dp[index];
    }

    public static void main(String[] args) {
        FrogJump solution = new FrogJump();
        int[] heights = {7, 4, 4, 2, 6, 6, 3, 4 };
        int n = 8;
        int minEnergy = solution.findEnergyTab(n, heights);
        System.out.println(minEnergy);
    }
}
