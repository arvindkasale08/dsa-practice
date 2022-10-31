package arvind.striver;

import java.util.ArrayList;
import java.util.List;

public class LeftRightView {

	public List<Integer> leftView(Node root) {
		List<Integer> results = new ArrayList<>();
		leftView(root, 0, results);
		return results;
	}

	private void leftView(Node node, int level, List<Integer> results) {
		if (node == null)
			return;
		if (results.size() == level)
			results.add(node.data);

		leftView(node.left, level + 1, results);
		leftView(node.right, level+1, results);
	}

	public List<Integer> rightView(Node root) {
		List<Integer> results = new ArrayList<>();
		rightView(root, 0, results);
		return results;
	}

	private void rightView(Node node, int level, List<Integer> results) {
		if (node == null)
			return;
		if (results.size() == level)
			results.add(node.data);

		rightView(node.right, level + 1, results);
		rightView(node.left, level+1, results);
	}

	public static void main(String[] args) {
		LeftRightView solution = new LeftRightView();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.left = new Node(6);
		root.right.right = new Node(7);

		List<Integer> result = solution.leftView(root);
		List<Integer> result2 = solution.rightView(root);
		System.out.println(result);
		System.out.println(result2);
	}
}
