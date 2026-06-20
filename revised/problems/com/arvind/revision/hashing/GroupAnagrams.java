package com.arvind.revision.hashing;

import com.arvind.revision.common.CommonUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> bank = new HashMap<>();

        for (String s : strs) {
            String sorted = sort(s);
            if (!bank.containsKey(sorted)) {
                bank.put(sorted, new ArrayList<>());
            }
            bank.get(sorted).add(s);
        }
        return bank.values().stream().collect(Collectors.toList());
    }

    private String sort(String s) {
        int[] ref = new int[26];
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            ref[c-'a'] += 1;
        }
        for (int i=0; i< ref.length; i++) {
            while (ref[i] > 0) {
                sb.append((char) ('a' + i));
                ref[i] -=1;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] arr = new String[] {"eat","tea","tan","ate","nat","bat"};
        String[] arr2 = new String[] {""};
        String[] arr3= new String[] {"a"};
        GroupAnagrams solution = new GroupAnagrams();

        List<List<String>> res1 = solution.groupAnagrams(arr);
        List<List<String>> res2 = solution.groupAnagrams(arr2);
        List<List<String>> res3 = solution.groupAnagrams(arr3);

        CommonUtils.print(res1);
        CommonUtils.print(res2);
        CommonUtils.print(res3);
    }
}
