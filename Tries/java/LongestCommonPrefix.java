import java.util.HashMap;
import java.util.Map;

public class LongestCommonPrefix {

	class Trie {

		private Node root = new Node('\0');

		public void insert(String word) {
			Node curr = root;
			for (char ch : word.toCharArray()) {
				if (!curr.children.containsKey(ch)) {
					curr.children.put(ch, new Node(ch));
				}
				curr = curr.children.get(ch);
			}
			curr.isEnd = true;
		}

		public String prefix() {
			StringBuilder sb = new StringBuilder();
			Node curr = root;
			while (curr != null) {
				if (curr.children.size() != 1) break;
				for (Node child : curr.children.values()) {
					sb.append(child.val);
					curr = child;
					break;
				}
			}

			return sb.toString();
		}

		class Node {
			char val;
			Map<Character, Node> children;
			boolean isEnd;

			public Node(char val) {
				this.children = new HashMap<>();
				this.val = val;
				this.isEnd = false;
			}
		}
	}

	public String findLCP(String[] input) {
		Trie trie = new Trie();
		for (String word : input) {
			trie.insert(word);
		}
		return trie.prefix();
	}

	public static void main(String[] args) {
		String[] input = new String[]{"flower", "flow", "flight"};
		LongestCommonPrefix solution = new LongestCommonPrefix();
		String prefix = solution.findLCP(input);
		System.out.println(prefix);
	}
}
