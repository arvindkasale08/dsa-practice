package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DeleteAndEarn {

    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            max = Math.max(max, num);
        }
        Integer[] points = countMap.keySet().toArray(new Integer[0]);
        Arrays.sort(points);
        int n = points.length;
        int[][] memo = new int[n][max+1];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }

        // similar to house robber pick and dont pick
        return deleteAndEarn(0, -1 , n, countMap, memo, points);
    }

    private int deleteAndEarn(int idx, int prev, int n, Map<Integer, Integer> countMap, int[][] memo, Integer[] points) {
        if (idx >= n) {
            return 0;
        }

        if (memo[idx][prev+1] != -1) {
            return memo[idx][prev+1];
        }

        int pick = Integer.MIN_VALUE;
        if (prev == points[idx] - 1) {
            pick = 0 + deleteAndEarn(idx+1, prev, n, countMap, memo, points);
        } else {
            pick = (points[idx] * countMap.get(points[idx])) + deleteAndEarn(idx+1, points[idx], n, countMap, memo, points);
        }

        int dontPick = deleteAndEarn(idx+1, prev, n, countMap, memo, points);

        return memo[idx][prev+1] = Math.max(pick, dontPick);
    }

    public static void main(String[] args) {
        //int[] nums = {2, 2, 3, 3, 3, 4};
        // int[] nums = {3, 4, 2};
        int[] nums = {1};
        DeleteAndEarn solution = new DeleteAndEarn();
        int points = solution.deleteAndEarn(nums);
        System.out.println(points);
    }
}
