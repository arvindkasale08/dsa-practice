package arvind.neetcode;

public class KSmallestElementInBST {

	public int find(TreeNode root, int k) {
		int[] count = new int[1];
		count[0] = k-1;
		return find(root, count);
	}

	private int find(TreeNode root, int[] count) {
		if (root == null)
			return -1;

		int left = find(root.left, count);
		if (left != -1)
			return left;
		if (count[0] == 0)
			return root.val;
		count[0] -=1;

		int right = find(root.right, count);
		if (right != -1)
			return right;

		return -1;
	}

	public static void main(String[] args) {
		KSmallestElementInBST solution = new KSmallestElementInBST();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.left.left.left = new TreeNode(1);
		int k = 1;
		int result = solution.find(root, k);
		System.out.println(result);
	}
}
