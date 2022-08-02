package arvind;

import java.util.Scanner;

public class Solution {

	static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	public static Node insertLevelOrder(int[] arr, int i)
	{
		Node root = null;
		// Base case for recursion
		if (i < arr.length) {
			root = new Node(arr[i]);

			// insert left child
			root.left = insertLevelOrder(arr, 2 * i + 1);

			// insert right child
			root.right = insertLevelOrder(arr, 2 * i + 2);
		}
		return root;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		int[] arr = new int[t];
		int i = 0;
		while(i < t) {
			int data = scan.nextInt();
			arr[i] = data;
			i += 1;
		}
		Node root = insertLevelOrder(arr, 0);
		scan.close();
	}
}

/**
 * 15
 * 1
 * 2
 * 3
 * -1
 * -1
 * 5
 * 6
 * -1
 * -1
 * -1
 * -1
 * 7
 * 8
 * -1
 * -1
 */
