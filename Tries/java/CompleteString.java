import java.util.Arrays;

public class CompleteString {

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

	public boolean isAllPrefixPresent(String word) {
		Node curr = root;
		for (char ch : word.toCharArray()) {
			int idx = ch - 'a';
			curr = curr.children[idx];
			if (!curr.isEnd) return false;
		}
		return true;
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

	public String completeString(String[] arr) {
		// put everything in a trie
		for (String str : arr) {
			insert(str);
		}
		int maxLength = 0;
		String res = "None";
		Arrays.sort(arr);
		for (int i=arr.length-1; i>=0; i--) {
			String s = arr[i];
			if (isAllPrefixPresent(s)) {
				if (s.length() >= maxLength) {
					res = s;
					maxLength = s.length();
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		CompleteString solution = new CompleteString();
		String[] arr = {"n", "l", "i", "um", "ar", "xcfyc" };
		String s = solution.completeString(arr);
		System.out.println(s);
	}
}
