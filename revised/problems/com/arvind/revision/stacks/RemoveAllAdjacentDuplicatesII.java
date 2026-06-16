package com.arvind.revision.stacks;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesII {

    public String removeDuplicates(String s, int k) {
        // TODO: Write your code here
        StringBuilder stringBuilder = new StringBuilder();
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(s.charAt(0)));
        for (int i=1; i<s.length(); i++) {
            Node curr = new Node(s.charAt(i));
            Node prev = stack.isEmpty() ? null : stack.peek();

            if (prev != null && curr.c == prev.c) {
                // found k elements remove them
                if (prev.times + 1 == k) {
                    for (int j=0; j<k-1; j++) {
                        stack.pop();
                    }
                } else {
                    curr.times= prev.times + 1;
                    stack.push(curr);
                }
            } else {
                stack.push(curr);
            }
        }

        for (Node node : stack) {
            stringBuilder.append(node.c);
        }

        return stringBuilder.toString();
    }

    class Node {
        char c;
        int times;

        public Node(char c) {
            this.c = c;
            this.times = 1;
        }
    }

    public static void main(String[] args) {
        String str = "abbbaaca";
        int k = 3;
        RemoveAllAdjacentDuplicatesII solution = new RemoveAllAdjacentDuplicatesII();
        System.out.println(solution.removeDuplicates(str, k));
        System.out.println(solution.removeDuplicates("abbaccaa", 3));
        System.out.println(solution.removeDuplicates("abbacccaa", 3));
    }
}
