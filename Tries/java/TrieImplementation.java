public class TrieImplementation {

	private Node root = new Node('\0');

	public void insert(String str) {
		Node curr = root;
		for (char ch : str.toCharArray()) {
			int idx = ch - 'a';
			if (curr.children[idx] == null) {
				curr.children[idx] = new Node(ch);
			}
			curr = curr.children[idx];
		}
		curr.isEnd = true;
	}

	public boolean delete(String word) {
		Node curr = getLast(word);
		if (curr == null || !curr.isEnd) {
			return false;
		}
		curr.isEnd = false;
		return true;
	}

	public void update(String oldWord, String newWord) {
		delete(oldWord);
		insert(newWord);
	}

	public boolean search(String word) {
		Node curr = getLast(word);
		return curr != null && curr.isEnd;
	}

	public boolean startsWith(String word) {
		Node curr = getLast(word);
		return curr != null;
	}

	private Node getLast(String word) {
		Node curr = root;
		for (char ch : word.toCharArray()) {
			int idx = ch - 'a';
			if (curr.children[idx] == null) return null;
			curr = curr.children[idx];
		}
		return curr;
	}

	class Node {
		char val;
		Node[] children;
		boolean isEnd;

		public Node(char val) {
			this.val = val;
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

		System.out.println(trie.search("logic")); // true
		trie.delete("logic");
		trie.delete("logics");
		System.out.println(trie.search("logic"));
		System.out.println(trie.search("logo"));
		System.out.println(trie.search("pogo"));
		trie.update("logo", "pogo");
		System.out.println(trie.search("logo"));
		System.out.println(trie.search("pogo"));
	}
}
