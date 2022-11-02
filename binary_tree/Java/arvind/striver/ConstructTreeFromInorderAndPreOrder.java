package arvind.striver;

import java.util.HashMap;
import java.util.Map;

public class ConstructTreeFromInorderAndPreOrder {

	public Node findTree(int[] preorder, int[] inorder) {
		Map<Integer, Integer> inorderidx = new HashMap<>();
		for (int i=0; i<inorder.length; i++) {
			inorderidx.put(inorder[i], i);
		}
		return findTree(preorder, inorder, 0, preorder.length -1, 0, inorder.length - 1, inorderidx);
	}

	public Node findTree(int[] preOrder, int[] inOrder, int prestart, int preend, int instart, int inend, Map<Integer, Integer> map) {
		if (prestart > preend || instart > inend) return null;

		Node node = new Node(preOrder[prestart]);
		int inorderidx = map.get(preOrder[prestart]);
		int predelta = inorderidx - instart;
		node.left = findTree(preOrder, inOrder, prestart+1, prestart + predelta, instart, inorderidx - 1, map);
		node.right = findTree(preOrder, inOrder, prestart + predelta + 1, preend, inorderidx + 1, inend, map);
		return node;
	}

	public static void main(String[] args) {
		int[] preorder = {3, 9, 20, 15, 7};
		int[] inorder = {9, 3, 15, 20, 7};
		ConstructTreeFromInorderAndPreOrder solution = new ConstructTreeFromInorderAndPreOrder();
		Node root = solution.findTree(preorder, inorder);
		System.out.println(root.data);
	}
}
