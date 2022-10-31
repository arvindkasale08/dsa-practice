package arvind.striver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeTraversalZigZag {

	public List<List<Integer>> zigzag(Node root) {
		Queue<Node> queue = new LinkedList<>();
		List<List<Integer>> result = new ArrayList<>();
		boolean flag = true;
		if (root != null) {
			queue.offer(root);
		}
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> r = new ArrayList<>();
			for (int i=0; i<size; i++) {
				Node node = queue.poll();
				r.add(node.data);
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}
			flag = !flag;
			if (flag) {
				Collections.reverse(r);
			}
			result.add(r);
		}

		return result;
	}

	public static void main(String[] args) {
		TreeTraversalZigZag solution = new TreeTraversalZigZag();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.right = new Node(6);

		List<List<Integer>> result = solution.zigzag(root);
		System.out.println(result);
	}
}
