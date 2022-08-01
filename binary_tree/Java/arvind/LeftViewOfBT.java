package arvind;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeftViewOfBT {

	public static int first_node_level = 0;

	static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	public int leftView(Node root, int level, int lastLevel) {
		if (root == null)
			return lastLevel;
		if (lastLevel < level) {
			System.out.print(root.data + " ");
			lastLevel = level;
		}
		lastLevel = leftView(root.left, level + 1, lastLevel);
		lastLevel = leftView(root.right, level + 1, lastLevel);
		return lastLevel;
	}

	public void leftViewWithStatic(Node root, int level) {
		if (root == null)
			return;
		if (first_node_level < level) {
			System.out.print(root.data + " ");
			first_node_level = level;
		}
		leftViewWithStatic(root.left, level + 1);
		leftViewWithStatic(root.right, level + 1);
	}

	public void leftViewWithStatic(Node root) {
		leftViewWithStatic(root, 1);
	}

	public void leftViewLevelOrder(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		List<List<Node>> result = new ArrayList<>();
		// just do level order traversal
		while (!queue.isEmpty()) {
			List<Node> list = new ArrayList<>();
			int size = queue.size();
			for (int i=0; i< size; i++) {
				Node node = queue.poll();
				list.add(node);
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}
			result.add(list);
		}

		for (List<Node> nodeList : result) {
			for (int i=0; i<nodeList.size(); i++) {
				if (i == 0) {
					System.out.print(nodeList.get(i).data+ " ");
				}
			}
		}
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.right = new Node(7);
		root.right.right = new Node(6);
		root.right.right.right = new Node(9);

		LeftViewOfBT solution = new LeftViewOfBT();
		System.out.println("Level order left view is: ");
		solution.leftViewLevelOrder(root);
		System.out.println("\nLeft View with Static");
		solution.leftViewWithStatic(root);
		System.out.println("\nLeft View no Static");
		solution.leftView(root, 0, -1);
	}
}
