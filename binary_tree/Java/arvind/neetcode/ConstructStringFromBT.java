package arvind.neetcode;

public class ConstructStringFromBT {

	public String construct(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		construct(root, sb);
		return sb.toString();
	}

	private void construct(TreeNode root, StringBuilder sb) {
		if (root == null)
			return;
		sb.append(root.val);
		if (root.left != null || root.right != null)
		sb.append("(");
		construct(root.left, sb);
		if (root.left != null || root.right != null)
		sb.append(")");
		if (root.right != null )
		sb.append("(");
		construct(root.right, sb);
		if (root.right != null )
		sb.append(")");
	}

	public static void main(String[] args) {
		ConstructStringFromBT solution = new ConstructStringFromBT();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);

		String result = solution.construct(root);
		System.out.println(result);
	}
}
