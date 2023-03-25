import java.util.HashSet;
import java.util.Set;

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

	public int countDistinctSubstrings2(String s) {
		Set<String> hashSet = new HashSet<>();
		int m = s.length();
		int count = 1;
		for (int i=0; i<m; i++) {
			for (int j=i; j<m; j++) {
				String si = s.substring(i, j+1);
				if (!hashSet.contains(si)) {
					count++;
					hashSet.add(si);
				}
			}
		}

		return count;
	}

	public static void main(String[] args) {
		CountDistinctSubstrings solution = new CountDistinctSubstrings();
		String s = "abcabcabcabcabc";
		int count = solution.countDistinctSubstrings(s);
		int count2 = solution.countDistinctSubstrings2(s);
		System.out.println(count);
		System.out.println(count2);
	}
}
