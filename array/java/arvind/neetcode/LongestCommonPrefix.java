package arvind.neetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonPrefix {

    Node root = new Node('\0');

    class Node {
        char val;
        Map<Character, Node> children;
        boolean isEnd;

        public Node(char val) {
            this.val = val;
            this.children = new HashMap<>();
            this.isEnd = false;
        }
    }

    public void insert(String s) {
        Node curr = root;
        for (char c : s.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new Node(c));
            }
            curr = curr.children.get(c);
        }
        curr.isEnd = true;
    }

    public String findLongestString() {
        StringBuilder sb = new StringBuilder();
        Node curr = root;

        while (curr != null) {
            if (curr.children.size() != 1 || curr.isEnd) break;
            for (Node next : curr.children.values()) {
                sb.append(next.val);
                curr = next;
            }
        }
        return sb.toString();
    }

    public String find(String[] strs) {
        for (String s : strs) {
            insert(s);
        }
        return findLongestString();
    }

    public static void main(String[] args) {
        LongestCommonPrefix solution = new LongestCommonPrefix();
        String[] strs = {"flower","flow","flight"};
        String result = solution.find(strs);
        System.out.println(result);
    }
}
