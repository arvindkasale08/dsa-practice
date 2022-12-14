package arvind.neetcode;

public class Merge2Trees {

	public TreeNode combine(TreeNode p, TreeNode q) {
		if (p == null)
			return q;
		if (q == null)
			return p;

		int sum = p.val + q.val;
		p.val = sum;
		p.left = combine(p.left, q.left);
		p.right = combine(p.right, q.right);
		return p;
	}

	public static void main(String[] args) {
		TreeNode p = new TreeNode(1);
		p.left = new TreeNode(3);
		p.right = new TreeNode(2);
		p.left.left = new TreeNode(5);

		TreeNode q = new TreeNode(2);
		q.left = new TreeNode(1);
		q.right = new TreeNode(3);
		q.left.right = new TreeNode(4);
		q.right.right = new TreeNode(7);

		Merge2Trees solution = new Merge2Trees();
		TreeNode ans = solution.combine(p, q);
		System.out.println(ans);
	}
}
