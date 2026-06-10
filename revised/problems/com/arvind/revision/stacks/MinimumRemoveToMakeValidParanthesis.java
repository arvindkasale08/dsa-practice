package com.arvind.revision.stacks;

public class MinimumRemoveToMakeValidParanthesis {

    public String minRemoveToMakeValid(String s) {
        int unbalOpenCount = 0;
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                unbalOpenCount +=1;
                sb.append(c);
            } else if (c == ')') {
                if (unbalOpenCount > 0) {
                    unbalOpenCount -=1;
                    sb.append(c);
                }
            } else {
                sb.append(c);
            }
        }
        String str = sb.reverse().toString();
        sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c == '(' && unbalOpenCount > 0) {
                unbalOpenCount--;
                // do nothing
            } else {
                sb.append(c);
            }
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String str = "((a)b(c)d";
        MinimumRemoveToMakeValidParanthesis solution = new MinimumRemoveToMakeValidParanthesis();
        String res = solution.minRemoveToMakeValid(str);
        System.out.println(res);
    }
}
