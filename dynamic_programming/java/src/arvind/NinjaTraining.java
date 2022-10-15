package arvind;

import java.util.Arrays;

public class NinjaTraining {

    public int findPoints(int[][] trainings) {
        int days = trainings.length;
        int[][] dp = new int[days][4]; // days by 0,1,2,3
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return findPoints(trainings, days - 1, 3, dp);
    }

    private int findPoints(int[][] trainings, int index, int last, int[][] dp) {
        if (index == 0) {
            int maximum = Integer.MIN_VALUE;
            for (int i=0; i<3; i++) {
                if (i != last)
                    maximum = Math.max(maximum, trainings[index][i]);
            }
            return maximum;
        }
        if (dp[index][last] != -1) return dp[index][last];
        int maxPoints = Integer.MIN_VALUE;
        for (int i=0; i< 3; i++) {
            if (i != last) {
                int points = trainings[index][i] + findPoints(trainings, index - 1, i, dp);
                maxPoints = Math.max(maxPoints, points);
            }
        }
        return dp[index][last] = maxPoints;
    }

    private int findPointsTab(int[][] trainings) {
        int[][] dp = new int[trainings.length][4]; // days by 0,1,2,3

        // base case when day = 0;

        for (int j=0; j< dp[0].length - 1; j++) {
            int maximum = Integer.MIN_VALUE;
            for (int task = 0; task < 3; task++) {
                if (task != j)
                    maximum = Math.max(maximum, trainings[0][task]);
            }
            dp[0][j] = maximum;
        }

        for (int day = 1; day < trainings.length; day++) {
            for (int last = 0; last < 4; last++) {
                dp[day][last] = 0;
                for (int task = 0; task <= 2; task++) {
                    if (task != last) {
                        int activity = trainings[day][task] + dp[day - 1][task];
                        dp[day][last] = Math.max(dp[day][last], activity);
                    }
                }
            }

        }

        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static void main(String[] args) {
        NinjaTraining solution = new NinjaTraining();
        int[][] trainings = new int[][]
                {
                        {10, 40, 70},
                        {20, 50, 80},
                        {30, 60, 90}
                };

        /* int[][] trainings = new int[][] {
                {10, 50, 1},
                {5, 100, 11}
        }; */
        int maxPoints = solution.findPointsTab(trainings);
        System.out.println(maxPoints);
    }
}
