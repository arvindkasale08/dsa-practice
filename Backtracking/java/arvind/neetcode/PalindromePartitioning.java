package arvind.neetcode;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public List<List<String>> findPartitions(String str) {
        List<List<String>> results = new ArrayList<>();
        find(0, str, new ArrayList<>(), results);
        return results;
    }

    private void find(int ind, String str, List<String> list, List<List<String>> results) {
        if (ind == str.length()) {
            results.add(new ArrayList<>(list));
            return;
        }

        for (int k=ind; k< str.length(); k++) {
            String newString = str.substring(ind, k+1);
            if (isPalindrome(newString)) {
                list.add(newString);
                find(k + 1, str, list, results);
                list.remove(list.size()-1);
            }
        }
    }

    private boolean isPalindrome(String str) {
        int i = 0;
        int k = str.length() -1;
        while (i < k) {
            if (str.charAt(i) != str.charAt(k)) return false;
            i++;
            k--;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "BaaB";
        PalindromePartitioning solution = new PalindromePartitioning();
        List<List<String>> result = solution.findPartitions(str);
        System.out.println(result);
    }
}
