package arvind.striver;

import java.util.ArrayList;
import java.util.List;

public class RootToNodePath {

	public List<Integer> findPath(Node root, int data) {
		List<Integer> path = new ArrayList<>();
		findPath(root, data, path);
		return path;
	}

	private boolean findPath(Node node, int data, List<Integer> path) {

		if (node == null)
			return false;


		path.add(node.data);

		if (node.data == data) {
			return true;
		}


		if (findPath(node.left, data, path) || findPath(node.right, data, path)) return true;

		path.remove(path.size()-1);

		return false;
	}

	public static void main(String[] args) {
		RootToNodePath solution = new RootToNodePath();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.left = new Node(6);
		root.left.right.right = new Node(7);
		int node = 7;
		List<Integer> path = solution.findPath(root, node);
		System.out.println(path);
	}
}
