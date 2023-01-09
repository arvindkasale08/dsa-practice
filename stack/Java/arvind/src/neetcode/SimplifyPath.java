package neetcode;

import java.util.Iterator;
import java.util.Stack;

public class SimplifyPath {

    public String simplifyPath(String path) {
        String[] str = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String s : str) {
            if (s == null || s.equals("") || s.equals(".")) {
                continue;
            } else if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(s);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        String res = "";
        Iterator<String> itr = stack.iterator();
        while (itr.hasNext()) {
            res += "/".concat(itr.next());
        }
        return res;
    }

    public static void main(String[] args) {
        String path = "/..//home//foo/";
        SimplifyPath solution = new SimplifyPath();
        String out = solution.simplifyPath(path);
        System.out.println(out);
    }
}
