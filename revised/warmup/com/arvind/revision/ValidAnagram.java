package com.arvind.revision;

import java.util.Arrays;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        // TODO: Write your code here
        if (s.length() != t.length()) {
            return false;
        }
        int[] arr = new int[26];
        for (char c: s.toCharArray()) {
            int idx = (int) c - 97;
            arr[idx]+=1;
        }
        for (char c: t.toCharArray()) {
            int idx = (int) c - 97;
            arr[idx]-=1;
        }
        for (int i : arr) {
            if (i!=0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1= "listen";
        String s2= "silent";

        ValidAnagram anagram = new ValidAnagram();
        System.out.println(anagram.isAnagram(s1, s2));

    }
}
