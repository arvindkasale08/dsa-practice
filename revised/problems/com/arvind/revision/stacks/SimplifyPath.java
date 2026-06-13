package com.arvind.revision.stacks;

import java.util.Iterator;
import java.util.Stack;

public class SimplifyPath {

    public String simplifyPath(String path) {
        // ToDo: Write Your Code Here.
        Stack<String> stack = new Stack<>();
        String[] arr = path.split("/");

        for (String s : arr) {
            if (s != null && !s.equals("") & !s.equals(".")) {
                if (s.equals("..")) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else {
                    stack.push(s);
                }
            }
        }

        StringBuilder res = new StringBuilder();
        res.append("/");
        Iterator<String> itr = stack.iterator();
        while (itr.hasNext()) {
            res.append(itr.next() + "/");
        }
        return res.length() == 1 ? "/" : res.deleteCharAt(res.length() - 1).toString();
    }

    public static void main(String[] args) {
        String str = "/home/user///Documents/../Pictures";
        String str2 = "/a//b////c/d//././/..";
        String str3= "/../";
        SimplifyPath solution = new SimplifyPath();
        String res = solution.simplifyPath(str3);
        System.out.println(res);
    }
}
