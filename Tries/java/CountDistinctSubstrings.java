public class CountDistinctSubstrings {

	Node root = new Node('\0');

	public Node insert(Node node, char ch) {
		int idx = ch - 'a';
		if (node.children[idx] == null) {
			node.children[idx] = new Node(ch);
		}
		return node.children[idx];
	}

	public boolean contains(Node node, char ch) {
		int idx = ch - 'a';
		return node.children[idx] != null;
	}

	class Node {
		char val;
		Node[] children;

		public Node(char val) {
			this.val = val;
			this.children = new Node[26];
		}
	}

	public int countDistinctSubstrings(String s) {
		int m = s.length();
		int count = 1;
		for (int i=0; i<m; i++) {
			Node curr = root;
			for (int j=i; j<m; j++) {
				char ch = s.charAt(j);
				if (!contains(curr, ch)) {
					count++;
					curr = insert(curr, ch);
				}
			}
		}

		return count;
	}

	public static void main(String[] args) {
		CountDistinctSubstrings solution = new CountDistinctSubstrings();
		String s = "abcabcabcabcabc";
		int count = solution.countDistinctSubstrings(s);
		System.out.println(count);
	}
}
