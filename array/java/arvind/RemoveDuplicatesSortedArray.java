package arvind;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class RemoveDuplicatesSortedArray {

	// TC: O(n*m) SC: O(n)
	public void removeDuplicatesBF(int[] arr) {
		LinkedHashSet linkedHashSet = new LinkedHashSet();
		for (int i=0; i< arr.length; i++) {
			linkedHashSet.add(arr[i]);
		}
		Iterator itr = linkedHashSet.iterator();
		int i =0;
		while(itr.hasNext()) {
			arr[i] = (int) itr.next();
			i++;
		}
		while (i < arr.length) {
			arr[i] = 0;
			i++;
		}
	}

	// TC: O(n) SC: O(1)
	public void removeDuplicates(int[] arr) {

	}

	public void display(int[] arr) {
		for (int i=0; i< arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		RemoveDuplicatesSortedArray rdsa = new RemoveDuplicatesSortedArray();
		int[] arr = new int[] {1, 1, 1, 1, 3, 3, 3, 4, 5, 5, 5, 8, 8, 9, 10, 10};
		rdsa.removeDuplicatesBF(arr);
		rdsa.display(arr);

		int[] arr2 = new int[] {1, 1, 1, 1, 3, 3, 3, 4, 5, 5, 5, 8, 8, 9, 10, 10};
		rdsa.removeDuplicates(arr2);
		rdsa.display(arr2);
	}
}
