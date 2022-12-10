package arvind.neetcode;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {

	public List<Integer> inorder(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		inorder(root, result);
		return result;
	}

	private void inorder(TreeNode root, List<Integer> result) {
		if (root == null)
			return;

		inorder(root.left, result);
		result.add(root.val);
		inorder(root.right, result);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		InorderTraversal solution = new InorderTraversal();
		List<Integer> result = solution.inorder(root);
		System.out.println(result);
	}
}
