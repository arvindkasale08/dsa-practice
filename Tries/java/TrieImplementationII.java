public class TrieImplementationII {

	private Node root = new Node('\0');

	public void insert(String word) {
		Node curr = root;
		for (char ch : word.toCharArray()) {
			int idx = ch - 'a';
			if (curr.children[idx] == null) {
				curr.children[idx] = new Node(ch);
			}
			curr.children[idx].count += 1;
			curr = curr.children[idx];
		}
		curr.countEndingHere += 1;
		curr.isEnd = true;
	}

	public int countWordsEqualTo(String word) {
		Node node = getLast(word);
		return node == null ? 0 : node.countEndingHere;
	}

	public int countWordsStartingWith(String prefix) {
		Node node = getLast(prefix);
		return node == null ? 0 : node.count;
	}

	public void erase(String word) {
		Node curr = root;
		for (char ch : word.toCharArray()) {
			int idx = ch - 'a';
			curr = curr.children[idx];
			curr.count -= 1;
		}
		curr.countEndingHere -= 1;
		curr.isEnd = false;
		if (curr.count == 0) {
			curr.children = new Node[26];
		}
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
		int count;
		int countEndingHere;

		public Node(char val) {
			this.val = val;
			this.children = new Node[26];
			this.isEnd = false;
			this.count = 0;
			this.countEndingHere = 0;
		}
	}

	public static void main(String[] args) {
		TrieImplementationII solution = new TrieImplementationII();
		solution.insert("abc");
		solution.insert("abc");
		solution.insert("aef");
		System.out.println(solution.countWordsEqualTo("abc"));
		System.out.println(solution.countWordsStartingWith("a"));
	}
}
