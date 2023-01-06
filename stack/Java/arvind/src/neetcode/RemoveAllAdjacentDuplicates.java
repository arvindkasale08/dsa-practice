package neetcode;

import java.util.Iterator;
import java.util.Stack;

public class RemoveAllAdjacentDuplicates {

    class Node {
        char c;
        int occurence;

        public Node (char c) {
            this.c = c;
            this.occurence = 1;
        }
    }

    public String removeDuplicates(String s, int k) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        Stack<Node> stack = new Stack<>();

        for (int i=0; i<n; i++) {
            Node current = new Node(ch[i]);

            while (!stack.isEmpty() && stack.peek().c == current.c) {
                if (stack.peek().occurence == k-1) {
                    stack.pop();
                    current = null;
                    break;
                } else {
                    Node popped = stack.pop();
                    popped.occurence += 1;
                    stack.push(popped);
                    current = null;
                    break;
                }
            }
            if (current != null)
            stack.push(current);
        }

        StringBuilder sb = new StringBuilder();
        Iterator<Node> itr = stack.iterator();
        while (itr.hasNext()) {
            Node node = itr.next();
            for (int i=0; i< node.occurence; i++) {
                sb.append(node.c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "pbbcggttciiippooaais";
        int k = 2;
        RemoveAllAdjacentDuplicates solution = new RemoveAllAdjacentDuplicates();
        String result = solution.removeDuplicates(s, k);
        System.out.println(result);
    }
}
