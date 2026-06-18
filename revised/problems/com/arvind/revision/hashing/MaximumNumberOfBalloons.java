package com.arvind.revision.hashing;

import java.net.Inet4Address;
import java.util.HashMap;
import java.util.Map;

public class MaximumNumberOfBalloons {

    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> refCountMap = new HashMap<>();
        for (char c : "balloon".toCharArray()) {
            refCountMap.put(c, refCountMap.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> sampleCountMap = new HashMap<>();
        for (char c : text.toCharArray()) {
            sampleCountMap.put(c, sampleCountMap.getOrDefault(c, 0) + 1);
        }
        int count = Integer.MAX_VALUE;
        if (sampleCountMap.size() < 5) return 0;
        for (Map.Entry<Character, Integer> entry : refCountMap.entrySet()) {
            if (sampleCountMap.getOrDefault(entry.getKey(), -1) < entry.getValue()) return 0;
            count = Math.min(count, sampleCountMap.get(entry.getKey()) / entry.getValue());
        }

        return count;
    }

    public static void main(String[] args) {
        String s1 = "nlaebolko";
        String s2 = "loonbalxballpoon";
        String s3 = "leetcode";
        MaximumNumberOfBalloons solution = new MaximumNumberOfBalloons();
        System.out.println(solution.maxNumberOfBalloons(s1));
        System.out.println(solution.maxNumberOfBalloons(s2));
        System.out.println(solution.maxNumberOfBalloons(s3));
    }
}
