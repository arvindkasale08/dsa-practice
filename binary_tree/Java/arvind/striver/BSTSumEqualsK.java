package arvind.striver;

import java.util.Stack;

public class BSTSumEqualsK {

	static class BSTIterator {
		private Stack<Node> stack;
		private Stack<Node> reverseStack;

		public BSTIterator(Node root) {
			stack = new Stack<>();
			reverseStack = new Stack<>();
			pushAllLeft(stack, root);
			pushAllRight(reverseStack, root);
		}

		public boolean hasNext() {
			return !stack.isEmpty();
		}

		public boolean hasBefore() {
			return !reverseStack.isEmpty();
		}

		public Node next() {
			if (hasNext()) {
				Node node = stack.pop();
				if (node.right != null)
					pushAllLeft(stack, node.right);
				return node;
			}
			return null;
		}

		public Node nextPeek() {
			if (hasNext()) {
				Node node = stack.peek();
				return node;
			}
			return null;
		}

		public Node before() {
			if (hasBefore()) {
				Node node = reverseStack.pop();
				if (node.left != null)
					pushAllRight(reverseStack, node.left);
				return node;
			}
			return null;
		}

		public Node beforePeek() {
			if (hasNext()) {
				Node node = reverseStack.peek();
				return node;
			}
			return null;
		}

		private void pushAllLeft(Stack<Node> stack, Node root) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
		}

		private void pushAllRight(Stack<Node> reverseStack, Node root) {
			while (root != null) {
				reverseStack.push(root);
				root = root.right;
			}
		}
	}

	public boolean solve(Node root, int k) {
		BSTIterator iterator = new BSTIterator(root);
		while (iterator.hasNext() && iterator.hasBefore()) {
			if (iterator.nextPeek() == iterator.beforePeek()) return false;
			int p = iterator.nextPeek().data;
			int q = iterator.beforePeek().data;
			if (p + q == k) {
				return true;
			} else if (p + q > k) {
				iterator.before();
			} else {
				iterator.next();
			}
		}
		return false;
	}

	public static void main(String[] args) {
		BSTSumEqualsK solution = new BSTSumEqualsK();
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
		root.right.right = new Node(11);
		int k = 21;
		boolean flag = solution.solve(root, k);
		System.out.println(flag);
 	}
}
