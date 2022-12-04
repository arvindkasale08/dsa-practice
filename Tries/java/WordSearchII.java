import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {

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

	public Node getLast(String prefix) {
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

	public List<String> findWords(char[][] grid, String[] words) {
		for (String word : words) {
			insert(word);
		}
		int m = grid.length;
		int n = grid[0].length;
		Set<String> result = new HashSet<>();
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				int[][] visited = new int[m][n];
				StringBuilder sb = new StringBuilder();
				sb.append(grid[i][j]);
				dfs(i, j, m, n, sb, visited, grid, result);
			}
		}
		return new ArrayList(result);
	}

	private void dfs(int i, int j, int m, int n, StringBuilder sb, int[][] visited, char[][] grid, Set<String> result) {

		String s = sb.toString();
		// get node representation of the string
		Node curr = getLast(s);
		if (curr == null)
			return;
		if (curr.isEnd)
			result.add(s);
		visited[i][j] = 1;
		int[] DIR_I = {-1, 0, 1, 0};
		int[] DIR_J = {0, 1, 0, -1};

		for (int k=0; k<4; k++) {
			int newI = i + DIR_I[k];
			int newJ = j + DIR_J[k];
			if (newI >= 0 && newI < m && newJ >=0 && newJ < n && visited[newI][newJ] == 0) {
				sb.append(grid[newI][newJ]);
				dfs(newI, newJ, m, n, sb, visited, grid, result);
				sb.setLength(sb.length()-1);
			}
		}
		visited[i][j] = 0;
	}

	public static void main(String[] args) {
		char[][] grid = new char[][] {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
		String[] words = new String[] {"oath","pea","eat","rain","hklf", "hf"};
		WordSearchII solution = new WordSearchII();
		List<String> result = solution.findWords(grid, words);
		System.out.println(result);
	}
}
