package com.arvind.revision.hashing;

import java.util.HashSet;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> ref = new HashSet<>();
        HashSet<Integer> visited = new HashSet<>();
        for (int n : nums) {
            ref.add(n);
        }

        int maxLength = Integer.MIN_VALUE;
        for (int n : nums) {
            // left most elements
            if (!visited.contains(n) && !ref.contains(n-1)) {
                // probe and find till where the limit exists
                int length = 1;
                int offset = 1;
                while (ref.contains(n + offset)) {
                    length +=1;
                    offset +=1;
                }
                maxLength = Math.max(length, maxLength);
            }
            visited.add(n);
        }
        return maxLength == Integer.MIN_VALUE ? 0 : maxLength;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {100, 4, 200, 1, 3, 2};
        int[] arr2 = new int[] {0,3,7,2,5,8,4,6,0,1};
        LongestConsecutiveSequence solution = new LongestConsecutiveSequence();
        System.out.println(solution.longestConsecutive(arr2));

    }
}
