package arvind;

import java.util.ArrayList;
import java.util.List;

public class PhoneDirectoryProblem {

	private Node root = new Node('\0'); // dummy node to be used as reference.

	class Node {
		char val;
		Node[] children;
		boolean isEnd;

		public Node(char val) {
			this.val = val;
			this.children = new Node[26]; // handle all lowercase characters
			this.isEnd = false;
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

	private Node getLast(String prefix) {
		Node curr = root;
		for (char ch: prefix.toCharArray()) {
			int index = ch - 'a';
			if (curr.children[index] == null) return null;
			curr = curr.children[index];
		}
		return curr;
	}

	public List<List<String>> find(String[] contacts, String query) {
		// insert contacts into a trie
		List<List<String>> results = new ArrayList<>();
		for (String contact : contacts) {
			insert(contact);
		}
		char[] ch = query.toCharArray();
		StringBuilder prefix = new StringBuilder();
		for (int i=0; i< ch.length; i++) {
			List<String> list = new ArrayList<>();
			prefix.append(ch[i]);
			Node curr = getLast(prefix.toString());
			if (curr != null) {
				if (curr.isEnd) {
					list.add(prefix.toString());
				}
				dfs(curr, prefix, list);
				results.add(list);
			} else {
				results.add(new ArrayList<>());
			}
		}
		return results;
	}

	private void dfs(Node curr, StringBuilder prefix, List<String> result) {
		if (curr != null && curr.isEnd) {
			result.add(prefix.toString());
		}
		if (curr == null)
			return;
		for (Node next : curr.children) {
			if (next != null) {
				prefix.append(next.val);
				dfs(next, prefix, result);
				prefix.setLength(prefix.length() - 1);
			}
		}
	}

	public static void main(String[] args) {
		PhoneDirectoryProblem solution = new PhoneDirectoryProblem();
		String[] contacts = {"phantom", "phone", "phul"};
		String queryString = "phum";
		List<List<String>> suggestions = solution.find(contacts, queryString);
		System.out.println(suggestions);
	}
}
