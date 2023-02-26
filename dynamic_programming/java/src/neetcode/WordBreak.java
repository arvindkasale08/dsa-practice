package neetcode;

import java.util.Arrays;
import java.util.List;

public class WordBreak {

    public boolean wordBreakMemo(String s, List<String> wordDict) {
        int n = s.length();
        Boolean[] memo = new Boolean[n];
        return wordBreakMemo(0, n, s, wordDict, memo);
    }

    private boolean wordBreakMemo(int idx, int n, String s, List<String> wordDict, Boolean[] memo) {
        if (idx >= n) {
            return true;
        }

        if (memo[idx] != null) {
            return memo[idx];
        }

        for (String word : wordDict) {
            int l = word.length();
            int endIdx = idx + l - 1;
            if (endIdx+1 > s.length()) {
                continue;
            }
            String s1 = s.substring(idx, endIdx+1);
            if (word.equals(s1)) {
                boolean ans = wordBreakMemo(endIdx + 1, n, s, wordDict, memo);
                if (endIdx+1 < memo.length) {
                    memo[endIdx + 1] = ans;
                }
                if (ans) {
                    return true;
                }
            }
        }
        return memo[idx] = false;
    }

    public static void main(String[] args) {
        WordBreak solution = new WordBreak();
        String s = "neetcode";
        String[] wordDict = new String[] {"lee", "neet", "code"};
        boolean res = solution.wordBreakMemo(s, Arrays.asList(wordDict));
        System.out.println(res);
    }
}
