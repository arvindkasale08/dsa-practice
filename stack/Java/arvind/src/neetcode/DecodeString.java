package neetcode;

import java.util.Iterator;
import java.util.Stack;

public class DecodeString {

    public String decodeString(String str) {
        char[] ch = str.toCharArray();
        int n= ch.length;
        Stack<String> stack = new Stack<>();

        for (int i=0; i<n; i++) {
            char c = ch[i];
            if (c == ']') {
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && !stack.peek().equals("[")) {
                    String s1 = stack.pop();
                    if (s1.length() > 1) {
                        sb.append(new StringBuilder(s1).reverse());
                    } else {
                        sb.append(s1);
                    }
                }
                String bracketContents = sb.reverse().toString();
                stack.pop(); // remove the [
                sb = new StringBuilder();
                // get the integer
                while (!stack.isEmpty()) {
                    String s = stack.peek();
                    if (s.length() == 1) {
                        char x = s.charAt(0);
                        if (Character.isDigit(x)) {
                            stack.pop();
                            sb.append(x);
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                Integer multiplier = Integer.parseInt(sb.reverse().toString());

                sb = new StringBuilder();
                for (int j=0; j<multiplier; j++) {
                    sb.append(bracketContents);
                }
                stack.push(sb.toString());
            } else {
                stack.push(c + "");
            }
        }
        StringBuilder result = new StringBuilder();
        Iterator<String> itr = stack.iterator();
        while (itr.hasNext()) {
            result.append(itr.next());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        DecodeString solution = new DecodeString();
        String str = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
        String s = solution.decodeString(str);
        System.out.println(s);
    }
}
