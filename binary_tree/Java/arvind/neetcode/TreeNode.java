package arvind.neetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	public TreeNode(int val) {
		this.val = val;
	}

	@Override
	public String toString() {
		List<List<Integer>> result = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(this);
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> res = new ArrayList<>();
			for (int i=0; i< size; i++) {
				TreeNode node = queue.poll();
				res.add(node.val);
				if (node.left != null)
					queue.offer(node.left);
				if (node.right != null)
					queue.offer(node.right);
			}
			result.add(res);
		}
		return result.toString();
	}
}
