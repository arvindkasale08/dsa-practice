package arvind;

import java.util.PriorityQueue;

public class RemoveStonesToMinimizeTotal {

	public int removeStones(int[] arr, int k) {
		int n = arr.length;
		PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
		for (int i=0; i<n; i++) {
			queue.offer(new int[] {arr[i], i});
		}
		int sum = 0;
		while(!queue.isEmpty()) {
			int[] node = queue.poll();
			int index = node[1];
			int val = node[0];
			int sub = (val / 2);
			if (k > 0) {
				arr[index] = val - sub;
				queue.offer(new int[]{arr[index], index});
				k--;
			}
		}
		for (int num : arr) {
			sum += num;
		}
		return sum;
	}

	public static void main(String[] args) {
		int[] arr = new int[] {5, 4, 9};
		int k = 2;
		RemoveStonesToMinimizeTotal solution = new RemoveStonesToMinimizeTotal();
		int total = solution.removeStones(arr, k);
		System.out.println(total);
	}
}
