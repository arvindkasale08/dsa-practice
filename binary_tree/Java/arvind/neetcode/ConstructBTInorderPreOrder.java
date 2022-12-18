package arvind.neetcode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBTInorderPreOrder {

	public TreeNode create(int[] inorder, int[] preorder) {
		Map<Integer, Integer> inorderIDX = new HashMap<>();
		for (int i=0; i<inorder.length; i++) {
			inorderIDX.put(inorder[i], i);
		}
		// inorder, preorder, instart, inend, prestart, preend, idx
		return create(inorder, preorder, 0, inorder.length-1, 0, preorder.length-1, inorderIDX);
	}

	private TreeNode create(int[] inorder, int[] preorder, int instart, int inend, int prestart, int preend, Map<Integer, Integer> inorderIDX) {
		if (instart > inend || prestart > preend)
			return null;
		int data = preorder[prestart];
		TreeNode root = new TreeNode(data);
		int idx = inorderIDX.get(data);
		int delta = idx - instart;
		root.left = create(inorder, preorder, instart, idx-1, prestart+1, prestart + delta, inorderIDX);
		root.right = create(inorder, preorder, idx+1, inend, prestart + delta + 1, preend, inorderIDX);
		return root;
	}

	public static void main(String[] args) {
		ConstructBTInorderPreOrder solution = new ConstructBTInorderPreOrder();
		int[] inorder = {9, 3, 15, 20, 7};
		int[] preorder = {3, 9, 20, 15, 7};

		TreeNode node = solution.create(inorder, preorder);
		System.out.println(node);
	}
}
