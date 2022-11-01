package arvind.striver;

public class ChildrenSum {

	public void enforceChildrenSum(Node root) {
		if (root == null)
			return;

		int childSum = 0;
		if (root.left != null)
			childSum += root.left.data;
		if (root.right != null)
			childSum += root.right.data;

		if (childSum < root.data) {
			if (root.left != null)
				root.left.data = root.data;
			if (root.right != null)
				root.right.data = root.data;
		}

		enforceChildrenSum(root.left);
		enforceChildrenSum(root.right);

		int postTotal = 0;
		if (root.left != null)
			postTotal += root.left.data;
		if (root.right != null)
			postTotal += root.right.data;
		if (postTotal != 0)
		root.data = postTotal;
	}


	public static void main(String[] args) {
		ChildrenSum solution = new ChildrenSum();
		/*Node root = new Node(50);
		root.left = new Node(7);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(5);
		root.right.left = new Node(1);
		root.right.right = new Node(30);*/

		Node root = new Node(40);
		root.left = new Node(10);
		root.right = new Node(20);
		root.left.left = new Node(2);
		root.left.right = new Node(5);
		root.right.left = new Node(30);
		root.right.right = new Node(40);
		solution.enforceChildrenSum(root);
		System.out.println(root);
	}
}
