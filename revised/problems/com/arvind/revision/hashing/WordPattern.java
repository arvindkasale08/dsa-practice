package com.arvind.revision.hashing;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split("\\s");
        Map<String, String> bank = new HashMap<>();
        Map<String, String> revBank = new HashMap<>();
        if (pattern.length() != arr.length) return false;
        for (int i=0; i< arr.length; i++) {
            String patternStr = (pattern.charAt(i)+"");
            if (!revBank.getOrDefault(arr[i], patternStr).equals(patternStr)) return false;
            if (!bank.getOrDefault(patternStr, arr[i]).equals(arr[i])) return false;
            bank.put(patternStr, arr[i]);
            revBank.put(arr[i], patternStr);
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog cat cat dog";
        WordPattern solution = new WordPattern();
        System.out.println(solution.wordPattern(pattern, s));
    }
}
