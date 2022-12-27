package arvind.neetcode;

import java.util.ArrayList;
import java.util.List;

public class FullBinaryTreesPossible {

	public List<TreeNode> possible(int n) {
		List<TreeNode> result = new ArrayList<>();
		if (n == 0 || n % 2 == 0)
			return result;
		possibleCombinations(n, result, true);
		return result;
	}

	private TreeNode possibleCombinations(int n, List<TreeNode> result, boolean first) {
		if (n == 1)
			return new TreeNode(0);
		if (n <= 0)
			return null;

		int i = 1;
		n = n-1; // use up 1 for root
		while (i <= n) {
			TreeNode root = new TreeNode(0);
			int left = i;
			int right = n - i;
			root.left = possibleCombinations(left, result, false);
			root.right = possibleCombinations(right, result, false);
			i+=2;
			if (first)
				result.add(root);
			else
				return root;
		}
		return null;
	}

	public static void main(String[] args) {
		FullBinaryTreesPossible solution = new FullBinaryTreesPossible();
		int n = 7;
		List<TreeNode> result = solution.possible(n);
		System.out.println(result);
	}
}
