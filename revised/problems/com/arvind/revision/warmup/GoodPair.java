package com.arvind.revision.warmup;

import java.util.HashMap;
import java.util.Map;

public class GoodPair {

    public int numGoodPairs(int[] nums) {
        int pairCount = 0;
        // TODO: Write your code here
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int n : nums) {
            pairCount += countMap.getOrDefault(n, 0);
            countMap.put(n, countMap.getOrDefault(n, 0) + 1);
        }

        return pairCount;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,1,1,3};
        GoodPair goodPair = new GoodPair();
        int pairCount = goodPair.numGoodPairs(nums);
        System.out.println(pairCount);
    }
}
