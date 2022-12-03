import java.util.ArrayList;
import java.util.List;

public class AutocompleteSuggestion {

	public List<String> autocomplete(String[] input, String prefix) {
		Trie trie = new Trie();
		for (String word : input) {
			trie.insert(word);
		}
		List<String> result = trie.getSuggestions(prefix);
		return result;
	}

	class Trie {

		private Node root = new Node('\0');

		public void insert(String word) {
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

		public List<String> getSuggestions(String prefix) {
			List<String> result = new ArrayList<>();
			Node curr = getLast(prefix);
			if (curr == null)
				return result;
			StringBuilder sb = new StringBuilder();
			sb.append(prefix);
			dfs(curr, sb, result);
			return result;
		}

		private void dfs(Node curr, StringBuilder builder, List<String> result) {
			if (curr != null && curr.isEnd) {
				result.add(builder.toString());
			}
			if (curr == null)
				return;
			for (Node child : curr.children) {
				if (child != null) {
					builder.append(child.val);
					dfs(child, builder, result);
					builder.setLength(builder.length()-1);
				}
			}
		}

		private Node getLast(String prefix) {
			Node curr = root;
			for (char ch : prefix.toCharArray()) {
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
	}

	public static void main(String[] args) {
		String[] input = new String[] {
			"hello",
			"dog",
			"hell",
			"cat",
			"a",
			"hel",
			"help",
			"helps",
			"helping"
		};
		String prefix = "help";
		AutocompleteSuggestion solution = new AutocompleteSuggestion();
		List<String> result = solution.autocomplete(input, prefix);
		System.out.println(result);
	}
}
