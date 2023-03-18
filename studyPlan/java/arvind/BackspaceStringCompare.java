package arvind;

import java.util.Stack;

public class BackspaceStringCompare {

    public boolean backspaceCompare(String s, String t) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch != '#') {
                s1.push(ch);
            } else {
                if (!s1.isEmpty())
                    s1.pop();
            }
        }

        for (char ch : t.toCharArray()) {
            if (ch != '#') {
                s2.push(ch);
            } else {
                if (!s2.isEmpty())
                    s2.pop();
            }
        }

        // compare the 2 stacks
        while (!s1.isEmpty() && !s2.isEmpty()) {
            char x = s1.pop();
            char y = s2.pop();
            if (x != y) return false;
        }

        return s1.isEmpty() && s2.isEmpty();
    }

    public static void main(String[] args) {
        String s = "ab#c";
        String t = "ac#c";
        BackspaceStringCompare solution = new BackspaceStringCompare();
        boolean res = solution.backspaceCompare(s, t);
        System.out.println(res);
    }
}
