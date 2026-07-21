package com.arvind.revision.greedy;

import java.util.Arrays;

public class MaximumLengthOfPairChains {

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (o1, o2) -> o1[1] - o2[1]);
        int count = 0;
        int lastRight = Integer.MIN_VALUE;
        for (int[] pair : pairs) {
            if (pair[0] > lastRight) {
                count ++;
                lastRight = pair[1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] pairs = new int[][] {{1,2},{2,3},{3,4}};
        MaximumLengthOfPairChains solution = new MaximumLengthOfPairChains();
        System.out.println(solution.findLongestChain(pairs));
    }
}
