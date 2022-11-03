package arvind.striver.practice;

import arvind.striver.Node;

public class ConstructBSTFromPreOrder {

	public Node construct(int[] arr) {
		if (arr.length == 0)
			return null;
		return construct(arr, Integer.MAX_VALUE, new int[1]);
	}

	private Node construct(int[] arr, int bound, int[] count) {
		if (arr.length == count[0] || arr[count[0]] > bound) {
			return null;
		}

		Node root = new Node(arr[count[0]++]);
		root.left = construct(arr, root.data, count);
		root.right = construct(arr, bound, count);
		return root;
	}

	public static void main(String[] args) {
		ConstructBSTFromPreOrder solution = new ConstructBSTFromPreOrder();
		int[] arr = {8, 5, 1, 7, 10, 12};
		Node node = solution.construct(arr);
		System.out.println(node.data);
	}
}
