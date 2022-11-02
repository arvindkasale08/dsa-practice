package arvind.striver;

import java.util.HashMap;
import java.util.Map;

public class ConstructTreeFromInOrderAndPostOrder {

	public Node findTree(int[] inorder, int[] postorder) {
		Map<Integer, Integer> inorderhash = new HashMap<>();
		for (int i=0; i<inorder.length; i++) {
			inorderhash.put(inorder[i], i);
		}
		return findTree(inorder, postorder, 0, inorder.length -1, 0, postorder.length -1, inorderhash);
	}

	public Node findTree(int[] inorder, int[] postorder, int instart, int inend, int poststart, int postend, Map<Integer, Integer> hash) {
		if (instart > inend || poststart > postend)
			return null;

		Node node = new Node(postorder[postend]);
		int hashIndex = hash.get(postorder[postend]);
		int diff = hashIndex - instart;

		node.left = findTree(inorder, postorder, instart, hashIndex - 1, poststart, poststart + diff - 1, hash);
		node.right = findTree(inorder, postorder, hashIndex + 1, inend, poststart + diff, postend - 1, hash);

		return node;
	}

	public static void main(String[] args) {
		ConstructTreeFromInOrderAndPostOrder solution = new ConstructTreeFromInOrderAndPostOrder();
		int[] inorder = {9, 3, 15, 20, 7};
		int[] postorder = {9, 15, 7, 20, 3};
		Node node = solution.findTree(inorder, postorder);
		System.out.println(node);
	}
}
