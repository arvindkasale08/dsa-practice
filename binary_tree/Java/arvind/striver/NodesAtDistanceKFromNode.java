package arvind.striver;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class NodesAtDistanceKFromNode {

	public List<Integer> findNodes(Node root, int t, int k) {
		// create a hashmap of parent pointers for each node;
		Map<Node, Node> parentMap = new HashMap<>();
		dfs(root, parentMap);

		// keep a visited set;
		Set<Node> visited = new HashSet<>();
		// now levels do level order traversal from target
		Queue<Node> queue = new LinkedList<>();
		int level = 0;
		Node target = search(root, t);
		System.out.println(target);

		if (target != null) {
			queue.offer(target);
			visited.add(target);
		}

		while (!queue.isEmpty()) {
			int size = queue.size();
			if (level == k) {
				break;
			}

			for (int i=0; i<size; i++) {
				Node node = queue.poll();
				visited.add(node);
				if (parentMap.containsKey(node) && !visited.contains(parentMap.get(node))) {
					queue.offer(parentMap.get(node));
				}
				if (node.left != null && !visited.contains(node.left)) {
					queue.offer(node.left);
				}
				if (node.right != null && !visited.contains(node.right)) {
					queue.offer(node.right);
				}
			}
			level++;
		}

		return queue.stream().map(node -> node.data).collect(Collectors.toList());
	}

	private Node search(Node root, int t) {
		if (root == null || root.data == t)
			return root;

		Node leftroot = search(root.left, t);
		Node rightroot = search(root.right, t);
		if (leftroot != null)
			return leftroot;
		if (rightroot != null)
			return rightroot;
		else
			return null;
	}

	private void dfs(Node root, Map<Node, Node> parentMap) {
		if (root == null)
			return;

		if (root.left != null)
		parentMap.put(root.left, root);
		if (root.right != null)
		parentMap.put(root.right, root);

		dfs(root.left, parentMap);
		dfs(root.right, parentMap);
	}

	public static void main(String[] args) {
		NodesAtDistanceKFromNode solution = new NodesAtDistanceKFromNode();
		Node root = new Node(3);
		root.left = new Node(5);
		root.right = new Node(1);
		root.left.left = new Node(6);
		root.left.right = new Node(2);
		root.left.right.left = new Node(7);
		root.left.right.right = new Node(4);
		root.right.left = new Node(0);
		root.right.right = new Node(8);
		int k = 2;
		List<Integer> result = solution.findNodes(root, 5, k);
		System.out.println(result);
	}
}
