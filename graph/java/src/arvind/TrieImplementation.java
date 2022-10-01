package arvind;

public class TrieImplementation {

    private Node root = new Node('\0'); // dummy node

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

    public boolean search(String word) {
        Node curr = getLast(word);
        return curr != null && curr.isEnd;
    }

    private Node getLast(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (root.children[index] == null) return null;
            curr = root.children[index];
        }
        return curr;
    }

    class Node {
        char val;
        Node[] children;
        boolean isEnd;

        public Node(char val) {
            this.val = val;
            // to hold all lowercase characters. Could be replaced with a Hashmap too
            this.children = new Node[26];
            this.isEnd = false;
        }
    }


    public static void main(String[] args) {
        TrieImplementation trie = new TrieImplementation();
        trie.insert("log");
        trie.insert("logic");
        trie.insert("logicmojo");
        trie.insert("logo");
        trie.insert("large");
        System.out.println(trie);
    }

}
