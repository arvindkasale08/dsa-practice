package arvind.neetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FullBinaryTreesPossible {

	public List<TreeNode> possible(int n) {
		return possibleCombinations(n);
	}

	private List<TreeNode> possibleCombinations(int n) {
		if (n == 1)
			return Arrays.asList(new TreeNode(0));
		if (n <= 0)
			return new ArrayList<>();

		List<TreeNode> result = new ArrayList<>();
		int i = 1;
		n = n-1; // use up 1 for root
		while (i <= n) {
			int left = i;
			int right = n - i;
			List<TreeNode> leftTree = possibleCombinations(left);
			List<TreeNode> rightTree = possibleCombinations(right);
			i+=1;

			for (TreeNode lt : leftTree) {
				for (TreeNode rt : rightTree) {
					TreeNode root = new TreeNode(0);
					root.left = lt;
					root.right = rt;
					result.add(root);
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		FullBinaryTreesPossible solution = new FullBinaryTreesPossible();
		int n = 7;
		List<TreeNode> result = solution.possible(n);
		System.out.println(result);
	}
}
