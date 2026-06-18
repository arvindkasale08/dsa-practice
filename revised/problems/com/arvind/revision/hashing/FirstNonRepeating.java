package com.arvind.revision.hashing;

import java.util.HashMap;

public class FirstNonRepeating {

    public int firstUniqChar(String s) {
        int ans = -1;
        HashMap<Character, Integer> countMap = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            countMap.put(s.charAt(i), countMap.containsKey(s.charAt(i)) ? 2 : 1);
        }

        for (int i=0; i< s.length(); i++) {
            if (countMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String s1 = "leetcode";
        String s2 = "loveleetcode";
        String s3 = "aabb";
        FirstNonRepeating solution = new FirstNonRepeating();
        System.out.println(solution.firstUniqChar(s1));
        System.out.println(solution.firstUniqChar(s2));
        System.out.println(solution.firstUniqChar(s3));
    }
}
