package arvind;

import java.util.*;

public class GroupAnagrams {

    public Map<String, List<String>> solveBF(String[] arr) {
        Map<String, List<String>> result = new HashMap<>();
        for (String s : arr) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String sorted = new String(c);
            if (!result.containsKey(sorted)) {
                result.put(sorted, new ArrayList<>());
            }
            result.get(sorted).add(s);
        }
        return result;
    }

    public static void display(Map<String, List<String>> result) {
        for(Map.Entry<String, List<String>> entry : result.entrySet()) {
            System.out.print(entry.getKey() + " - ");
            for (String s : entry.getValue()) {
                System.out.print(s + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams solution = new GroupAnagrams();
        Map<String, List<String>> result = solution.solveBF(input);
        display(result);
    }
}
