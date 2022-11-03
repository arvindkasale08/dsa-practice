package arvind.striver;

import java.util.Stack;

public class BSTIterator {

	private Stack<Node> stack;

	public BSTIterator(Node root) {
		stack = new Stack<>();
		putAllLeft(root, stack);
		System.out.println(stack);
	}

	public int next() {
		Node node = stack.pop();
		if (node.right != null)
			putAllLeft(node.right, stack);
		return node.data;
	}

	public boolean hasNext() {
		return !stack.isEmpty();
	}

	private void putAllLeft(Node root, Stack<Node> stack) {
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
	}

	public static void main(String[] args) {
		Node root = new Node(7);
		root.left = new Node(3);
		root.right = new Node(10);
		root.left.left = new Node(2);
		root.left.left.left = new Node(1);
		root.left.right = new Node(6);
		root.left.right.left = new Node(5);
		root.left.right.left.left = new Node(4);
		root.right.left = new Node(9);
		root.right.left.left = new Node(8);

		BSTIterator iterator = new BSTIterator(root);
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
