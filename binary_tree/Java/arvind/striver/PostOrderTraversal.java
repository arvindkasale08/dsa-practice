package arvind.striver;

import java.util.ArrayList;
import java.util.List;

public class PostOrderTraversal {

	public List<Integer> postOrder(Node root) {
		List<Integer> result = new ArrayList<>();
		postOrder(root, result);
		return result;
	}

	private void postOrder(Node root, List<Integer> result) {
		if (root == null)
			return;

		postOrder(root.left, result);
		postOrder(root.right, result);
		result.add(root.data);
	}


	public static void main(String[] args) {
		PostOrderTraversal solution = new PostOrderTraversal();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.left = new Node(8);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.right.left = new Node(9);
		root.right.right.right = new Node(10);
		List<Integer> result = solution.postOrder(root);
		System.out.println(result);
	}
}
