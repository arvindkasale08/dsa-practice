package com.arvind.revision.hashing;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> fwdMap = new HashMap<>();
        Map<Character, Character> revMap = new HashMap<>();
        for (int i=0; i< s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (fwdMap.getOrDefault(b, a) != a) return false;
            if (revMap.getOrDefault(a, b) != b) return false;
            fwdMap.put(b, a);
            revMap.put(a, b);
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "egg";
        String s2 = "add";
        IsomorphicStrings solution = new IsomorphicStrings();
        System.out.println(solution.isIsomorphic(s1, s2));
    }
}
