package arvind.striver;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidth {

	static class Pair {
		Node node;
		int index;

		public Pair(Node node, int index) {
			this.index = index;
			this.node = node;
		}
	}

	public int findMaxWidth(Node root) {
		Queue<Pair> queue = new LinkedList<>();
		int maxWidth = Integer.MIN_VALUE;
		if (root == null) {
			return 0;
		}
		queue.offer(new Pair(root, 0)); // 0 based indexing...

		while (!queue.isEmpty()) {
			int left = Integer.MAX_VALUE;
			int right = Integer.MIN_VALUE;
			int size = queue.size();
			for (int i=0; i< size; i++) {
				Pair pair = queue.poll();
				Node node = pair.node;
				int index = pair.index;
				left = Math.min(left, index);
				right = Math.max(right, index);
				if (node.left != null) {
					queue.offer(new Pair(node.left, (2 * index) + 1));
				}
				if (node.right != null) {
					queue.offer(new Pair(node.right, (2 * index) + 2));
				}
			}
			int width = right - left + 1;
			maxWidth = Math.max(width, maxWidth);
		}
		return maxWidth;
	}

	public static void main(String[] args) {
		MaximumWidth solution = new MaximumWidth();
		Node root = new Node(1);
		/*root.left = new Node(3);
		root.right = new Node(2);
		root.left.left = new Node(5);
		root.left.left.left = new Node(6);
		root.right.right = new Node(9);
		//root.right.right.left = new Node(7);*/

		int maxwidth = solution.findMaxWidth(root);
		System.out.println(maxwidth);
	}
}
