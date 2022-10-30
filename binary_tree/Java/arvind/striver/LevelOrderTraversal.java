package arvind.striver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

	public List<Integer> levelOrder(Node root) {
		List<Integer> result = new ArrayList<>();
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			result.add(node.data);
			if (node.left != null)
				queue.offer(node.left);
			if (node.right != null)
				queue.offer(node.right);
		}

		return result;
	}

	public List<List<Integer>> levelOrderList(Node root) {
		List<List<Integer>> result = new ArrayList<>();
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			int n = queue.size();
			List<Integer> result2 = new ArrayList<>();
			for (int i=0; i<n; i++) {
				Node node = queue.poll();
				result2.add(node.data);
				if (node.left != null)
					queue.offer(node.left);
				if (node.right != null)
					queue.offer(node.right);
			}
			result.add(result2);
		}
		return result;
	}

	public static void main(String[] args) {
		LevelOrderTraversal solution = new LevelOrderTraversal();
		Node root = new Node(20);
		root.left = new Node(10);
		root.right = new Node(30);
		root.left.left = new Node(5);
		root.left.right = new Node(15);
		root.right.left = new Node(25);
		root.right.right = new Node(35);

		List<Integer> result = solution.levelOrder(root);
		List<List<Integer>> result2 = solution.levelOrderList(root);
		System.out.println(result);
		System.out.println(result2);
	}
}
