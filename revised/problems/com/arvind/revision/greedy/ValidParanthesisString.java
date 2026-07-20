package com.arvind.revision.greedy;

public class ValidParanthesisString {

    public boolean checkValidString(String s) {
        int minOpen = 0;
        int maxOpen = 0;

        for (int i=0; i< s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                maxOpen++;
                minOpen++;
            } else if (c == '*') {
                minOpen--;
                maxOpen++;
                minOpen = Math.max(minOpen, 0);
            } else {
                minOpen--;
                maxOpen--;
                minOpen = Math.max(minOpen, 0);
                if (maxOpen < 0) return false;
            }
        }
        return minOpen == 0;
    }

    public static void main(String[] args) {
        String s = "(*))";
        ValidParanthesisString solution = new ValidParanthesisString();
        System.out.println(solution.checkValidString(s));
    }
}
