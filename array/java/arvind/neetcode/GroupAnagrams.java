package arvind.neetcode;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String sortedString = getSorted(s);
            List<String> list = map.getOrDefault(sortedString, new ArrayList<>());
            list.add(s);
            map.put(sortedString, list);
        }
        return new ArrayList<>(map.values());
    }

    private String getSorted(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c-'a'] += 1;
        }
        StringBuilder res = new StringBuilder();
        for (int i=0; i<26; i++) {
            while (freq[i] > 0) {
                res.append((char)(i+97));
                freq[i] -= 1;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        GroupAnagrams solution = new GroupAnagrams();
        List<List<String>> result = solution.groupAnagrams(strs);
        System.out.println(result);
    }
}
