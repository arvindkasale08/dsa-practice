package arvind.striver;

public class ConstructBSTFromPreOrder {

	public Node createTree(int[] arr) {
		if (arr.length == 0)
			return null;
		return createTree(arr, Integer.MAX_VALUE, new int[1]);
	}

	private Node createTree(int[] arr, int ub, int[] count) {
		if (arr.length == count[0] || arr[count[0]] > ub) return null;
		Node root = new Node(arr[count[0]++]);
		root.left = createTree(arr, root.data, count);
		root.right = createTree(arr, ub, count);
		return root;
	}

	public static void main(String[] args) {
		ConstructBSTFromPreOrder solution = new ConstructBSTFromPreOrder();
		int[] arr = {8, 5, 1, 7, 10, 12};
		Node node = solution.createTree(arr);
		System.out.println(node.data);
	}
}
