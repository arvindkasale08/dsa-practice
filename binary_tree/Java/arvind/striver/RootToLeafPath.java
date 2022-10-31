package arvind.striver;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafPath {

	public List<List<Integer>> findPath(Node root) {
		List<List<Integer>> paths = new ArrayList<>();
		findPath(root, new ArrayList<>(), paths);
		ArrayList<String> res = new ArrayList();
		for (List<Integer> list : paths) {
			StringBuilder sb = new StringBuilder();
			for (Integer i : list) {
				sb.append(i).append(" ");
			}
			res.add(sb.toString().trim());
		}
		System.out.println(res);
		return paths;
	}

	private boolean isLeaf(Node node) {
		return node.left == null && node.right == null;
	}

	private boolean findPath(Node node, List<Integer> path, List<List<Integer>> paths) {
		if (node == null)
			return false;
		path.add(node.data);
		if (isLeaf(node)) {
			paths.add(new ArrayList<>(path));
			return true;
		}

		findPath(node.left, path, paths);
		path.remove(path.size() -1);
		findPath(node.right, path, paths);
		path.remove(path.size() -1);

		return false;
	}

	public static void main(String[] args) {
		RootToLeafPath solution = new RootToLeafPath();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		List<List<Integer>> result = solution.findPath(root);
		System.out.println(result);
	}
}
