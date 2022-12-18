package arvind.neetcode;

public class IsTreeFlipEquivalent {

	public boolean isFlipEquiv(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if (p == null || q == null)
			return false;

		if (p.val != q.val)
			return false;
		TreeNode qleft = q.left;
		TreeNode qright = q.right;
		if (p.left == null && q.left != null) {
			qleft = q.right;
			qright = q.left;
		} else if (p.left != null && q.left == null) {
			qleft = q.right;
			qright = q.left;
		}
		else if (p.left != null && q.left != null && p.left.val != q.left.val) {
			qleft = q.right;
			qright = q.left;
		}

		if (!isFlipEquiv(p.left, qleft)) return false;
		if (!isFlipEquiv(p.right, qright)) return false;

		return true;
	}

	public static void main(String[] args) {
		IsTreeFlipEquivalent solution = new IsTreeFlipEquivalent();
		TreeNode p = new TreeNode(1);
		p.left = new TreeNode(2);
		p.right = new TreeNode(3);
		p.left.left = new TreeNode(4);
		p.left.right = new TreeNode(5);
		p.left.right.left = new TreeNode(7);
		p.left.right.right = new TreeNode(8);
		p.right = new TreeNode(3);
		p.right.left = new TreeNode(6);

		TreeNode q = new TreeNode(1);
		q.left = new TreeNode(3);
		q.right = new TreeNode(2);
		q.left.right = new TreeNode(6);
		q.right.left = new TreeNode(4);
		q.right.right = new TreeNode(5);
		q.right.right.left = new TreeNode(8);
		q.right.right.right = new TreeNode(7);

		boolean result = solution.isFlipEquiv(p, q);
		System.out.println(result);
	}
}
