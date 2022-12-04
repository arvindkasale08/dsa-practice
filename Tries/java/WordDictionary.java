public class WordDictionary {

	private Node root = new Node('\0');

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

	public void addWord(String word) {
		Node curr = root;
		for (char ch : word.toCharArray()) {
			int idx = ch - 'a';
			if (curr.children[idx] == null) {
				curr.children[idx] = new Node(ch);
			}
			curr = curr.children[idx];
		}
		curr.isEnd = true;
	}

	public boolean search(String word) {
		Node curr = root;
		return dfs(0, word, curr);
	}

	private boolean dfs(int idx, String word, Node curr) {
		if (idx == word.length()) {
			return curr != null && curr.isEnd;
		}
		if (curr == null)
			return false;
		char ch = word.charAt(idx);
		if (ch == '.') {
			for (Node next : curr.children) {
				if (next != null) {
					if (dfs(idx+1, word, next)) return true;
				}
			}
		} else {
			int i = ch - 'a';
			Node next = curr.children[i];
			if (dfs(idx+1, word, next)) return true;
		}
		return false;
	}

	public static void main(String[] args) {
		WordDictionary wordDictionary = new WordDictionary();
		wordDictionary.addWord("bad");
		wordDictionary.addWord("dad");
		wordDictionary.addWord("mad");
		System.out.println(wordDictionary.search("pad")); // return False
		System.out.println(wordDictionary.search("bad")); // return True
		System.out.println(wordDictionary.search(".ad")); // return True
		System.out.println(wordDictionary.search("b..")); // return True
	}
}
