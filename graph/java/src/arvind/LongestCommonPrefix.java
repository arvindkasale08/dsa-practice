package arvind;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonPrefix {

    private Node root = new Node('\0'); // dummy node
    class Node {
        char val;
        Map<Character, Node> children;
        boolean isEnd;

        public Node(char val) {
            this.val = val;
            this.children = new HashMap<>(); // lower case characters
            this.isEnd = false;
        }
    }

    public void insert(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new Node(c));
            }
            curr = curr.children.get(c);
        }
        curr.isEnd = true;
    }

    public String findLongestCommonPrefix() {
        Node curr = root;
        StringBuilder result = new StringBuilder();
        while (curr != null) {
            if (curr.children.size() != 1 || curr.isEnd) break;
            for (Node next : curr.children.values()) {
                if (next.val != '\0') // ignore dummy
                    result.append(next.val);
                curr = next;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        LongestCommonPrefix solution = new LongestCommonPrefix();
        //String[] words = {"flower", "flow", "flight"};
        String[] words = {"", "b"};
        for (String word : words) {
            solution.insert(word);
        }
        String prefix = solution.findLongestCommonPrefix();
        System.out.println(prefix);
    }
}
