package arvind.striver;

public class IdenticalTrees {

	public boolean isIdentical(Node p, Node q) {
		if (p == null && q == null)
			return true;
		if (p == null || q == null)
			return false;
		return p.data == q.data && isIdentical(p.left, q.left) && isIdentical(p.right, q.right);
	}

	public static void main(String[] args) {
		IdenticalTrees solution = new IdenticalTrees();
		Node root1 = new Node(5);
		root1.left = new Node(2);
		root1.right = new Node(3);
		root1.right.left = new Node(6);


		Node root2 = new Node(8);
		boolean isIdentical = solution.isIdentical(root1, root2);
		System.out.println(isIdentical);

	}
}
