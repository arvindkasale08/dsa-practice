package arvind.neetcode;

import java.util.PriorityQueue;

public class KLargestInArray {

	public int find(int[] arr, int k) {
		int n = arr.length;
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int i=0; i<n; i++) {
			if (i < k) {
				queue.offer(arr[i]);
			} else {
				if (queue.peek() < arr[i]) {
					queue.poll();
					queue.offer(arr[i]);
				}
			}
		}
		return queue.peek();
	}

	public static void main(String[] args) {
		KLargestInArray solution = new KLargestInArray();
		int k = 2;
		int[] arr = new int[] {3,2,1,5,6,4};
		int result = solution.find(arr, k);
		System.out.println(result);
	}
}
