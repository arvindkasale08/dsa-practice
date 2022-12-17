package arvind.neetcode;

import java.util.ArrayList;
import java.util.List;

public class BTRightSideView {

	public List<Integer> view(TreeNode root) {
		List<Integer> results = new ArrayList<>();
		view(root, 0, results);
		return results;
	}

	private void view(TreeNode root, int level, List<Integer> results) {
		if (root == null)
			return;

		if (results.size() == level)
			results.add(root.val);

		view(root.right, level+1, results);
		view(root.left, level+1, results);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(4);

		BTRightSideView solution = new BTRightSideView();
		List<Integer> result = solution.view(root);
		System.out.println(result);
	}
}
