package arvind.neetcode;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue {

	public int findBottomLeft(TreeNode root) {
		// lets do a bfs at each level keep track of the left most
		int leftMost = -1;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i=0; i<size; i++) {
				TreeNode node = queue.poll();
				if (i == 0)
					leftMost = node.val;

				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
		}
		return leftMost;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(6);
		root.right.left.left = new TreeNode(7);

		FindBottomLeftTreeValue solution = new FindBottomLeftTreeValue();
		int res = solution.findBottomLeft(root);
		System.out.println(res);
	}
}
