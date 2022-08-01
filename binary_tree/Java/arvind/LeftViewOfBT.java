package arvind;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeftViewOfBT {
	static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
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
		solution.leftViewLevelOrder(root);
	}
}
