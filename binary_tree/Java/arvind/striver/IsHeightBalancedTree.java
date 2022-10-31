package arvind.striver;

public class IsHeightBalancedTree {

	public boolean isHeightBalanced(Node root) {
		return dfsHeight(root) != -1;
	}

	public int dfsHeight(Node root) {
		if (root == null)
			return 0;

		int lh = dfsHeight(root.left);
		if (lh == -1) return -1;
		int rh = dfsHeight(root.right);
		if (rh == -1) return -1;

		if (Math.abs(lh - rh) > 1) return -1;
		return 1 + Math.max(lh, rh);
	}

	public static void main(String[] args) {
		IsHeightBalancedTree solution = new IsHeightBalancedTree();
		Node root = new Node(4);
		root.left = new Node(7);
		root.right = new Node(8);
		root.right.left = new Node(1);
		root.right.right= new Node(0);
		//root.right.left.left = new Node(3);
		//root.right.left.right = new Node(5);
		boolean result = solution.isHeightBalanced(root);
		System.out.println(result);
	}
}
