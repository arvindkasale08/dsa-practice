package arvind.striver;

public class SymmetricBinaryTree {

	public boolean isSymmetric(Node root) {
		if (root == null) return true;
		return isSymmetric(root.left, root.right);
	}

	public boolean isSymmetric(Node p, Node q) {
		if (p == null && q == null)
			return true;
		if (p == null || q == null)
			return false;
		return p.data == q.data && isSymmetric(p.right, q.left) && isSymmetric(p.left, q.right);
	}

	public static void main(String[] args) {
		SymmetricBinaryTree solution = new SymmetricBinaryTree();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(4);
		root.right.left = new Node(4);
		root.right.right = new Node(3);

		boolean flag = solution.isSymmetric(root);
		System.out.println(flag);
	}
}
