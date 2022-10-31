package arvind.striver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoundaryTraversal {

	private boolean isLeaf(Node node) {
		return node.left == null && node.right == null;
	}

	public List<Integer> boundary(Node root) {
		List<Integer> result = new ArrayList<>();
		addLeft(root, result);
		addLeaf(root, result);
		List<Integer> tempList = new ArrayList<>();
		addRight(root, root, tempList);
		Collections.reverse(tempList);
		result.addAll(tempList);
		return result;
	}

	private void addLeaf(Node node, List<Integer> result) {
		if (node == null)
			return;
		if (isLeaf(node)) {
			result.add(node.data);
			return;
		}
		addLeaf(node.left, result);
		addLeaf(node.right, result);
	}

	private void addLeft(Node node, List<Integer> result) {
		if (node == null || isLeaf(node)) {
			return;
		}
		result.add(node.data);
		if (node.left != null)
			addLeft(node.left, result);
		else
			addLeft(node.right, result);
	}

	private void addRight(Node node, Node root, List<Integer> result) {
		if (node == null || isLeaf(node)) {
			return;
		}
		if (node != root)
		result.add(node.data);
		if (node.right != null)
			addRight(node.right, root, result);
		else
			addRight(node.left, root, result);
	}

	public static void main(String[] args) {
		BoundaryTraversal solution = new BoundaryTraversal();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(7);
		root.left.left = new Node(3);
		root.left.left.right = new Node(4);
		root.left.left.right.left = new Node(5);
		root.left.left.right.right = new Node(6);
		root.right.right = new Node(8);
		root.right.right.left = new Node(9);
		root.right.right.left.left = new Node(10);
		root.right.right.left.right = new Node(11);

		List<Integer> result = solution.boundary(root);
		System.out.println(result);
	}
}
