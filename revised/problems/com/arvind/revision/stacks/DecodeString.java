package com.arvind.revision.stacks;

import java.util.Iterator;
import java.util.Stack;

public class DecodeString {

    public String decodeString(String str) {
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            if (ch == ']') {
                StringBuilder bracketString = new StringBuilder();
                StringBuilder multiplier = new StringBuilder();
                while (!stack.isEmpty() && !"[".equals(stack.peek())) {
                    String currCh = new StringBuilder(stack.pop()).reverse().toString();
                    bracketString.append(currCh);
                }
                stack.pop();
                while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                    multiplier.append(stack.pop());
                }
                String resString = getResString(bracketString, multiplier);
                stack.push(resString);
            } else {
                stack.push(ch+"");
            }

        }
        Iterator<String> itr = stack.iterator();
        while (itr.hasNext()) {
            sb.append(itr.next());
        }

        return sb.toString();
    }

    private String getResString(StringBuilder bracketString, StringBuilder multiplier) {
        int mul = Integer.parseInt(multiplier.reverse().toString());
        String str = bracketString.reverse().toString();
        for (int i=1; i< mul; i++) {
            bracketString.append(str);
        }
        return bracketString.toString();
     }

    public static void main(String[] args) {
        String str = "3[a2[c]]";
        String str2 = "3[a]2[bc]";
        String str3 = "2[abc]3[cd]ef";
        String str4 = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
        String str5 = "2[c3[abc]]";
        DecodeString solution = new DecodeString();
        String res = solution.decodeString(str);
        System.out.println(res);
        String res2 = solution.decodeString(str2);
        System.out.println(res2);
        String res3 = solution.decodeString(str3);
        System.out.println(res3);
    }
}
