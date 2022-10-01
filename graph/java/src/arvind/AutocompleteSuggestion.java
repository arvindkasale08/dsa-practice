package arvind;

import java.util.ArrayList;
import java.util.List;

public class AutocompleteSuggestion {

    private Node root = new Node('\0'); // dummy root node

    class Node {
        char val;
        Node[] children;
        boolean isEnd;

        public Node(char val) {
            this.val = val;
            children = new Node[26];
            isEnd = false;
        }
    }

    public void insert(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new Node(c);
            }
            curr = curr.children[index];
        }
        curr.isEnd = true;
    }

    public List<String> findResults(String prefix) {
        List<String> results = new ArrayList<>();
        Node curr = getLast(prefix);
        if (curr == null) return new ArrayList<>(); // prefix doesnt return valid results return back an empty list.
        StringBuilder res = new StringBuilder(prefix);
        dfs(curr, res, results);
        return results;
    }

    private void dfs(Node curr, StringBuilder res, List<String> results) {
        if (curr != null && curr.isEnd) {
            results.add(res.toString());
        }
        if (curr == null) {
            return;
        }
        for (Node child : curr.children) {
            if (child != null) {
                res.append(child.val);
                dfs(child, res, results);
                res.setLength(res.length() - 1);
            }
        }
    }

    private Node getLast(String prefix) {
        Node curr = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (curr.children[index] == null) return null;
            curr = curr.children[index];
        }
        return curr;
    }

    public static void main(String[] args) {
        AutocompleteSuggestion solution = new AutocompleteSuggestion();
        String[] input = {"hello", "dog", "hell", "cat", "a","hel", "help", "helps", "helping"};
        for (String ip : input) {
            solution.insert(ip);
        }
        String prefix = "help";
        List<String> results = solution.findResults(prefix);
        System.out.println(results);
    }

}
