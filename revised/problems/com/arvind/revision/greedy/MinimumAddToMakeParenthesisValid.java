package com.arvind.revision.greedy;

public class MinimumAddToMakeParenthesisValid {

    public int minAddToMakeValid(String s) {
        int ans = 0;
        int open = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                open += 1;
            } else {
                if (open > 0) {
                    open -= 1;
                } else {
                    ans += 1;
                }
            }
        }
        ans += open;

        return ans;
    }

    public static void main(String[] args) {
        String s1 = "))((";
        String s2 = "(()())(";
        MinimumAddToMakeParenthesisValid solution = new MinimumAddToMakeParenthesisValid();
        System.out.println(solution.minAddToMakeValid(s2));
    }
}
