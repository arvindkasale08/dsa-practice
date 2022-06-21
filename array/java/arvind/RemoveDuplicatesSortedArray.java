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

		int j = 0;

		for (int i=1; i< arr.length - 1; i++) {
			if (arr[i] != arr[i+1]) {
				arr[j] = arr[i];
				j++;
			}
		}

		arr[j] = arr[arr.length - 1];
		j++;
		while (j < arr.length) {
			arr[j] = 0;
			j++;
		}
	}

	public void removeDuplicates2(int[] arr) {

		int j = 0;

		for (int i=0; i< arr.length; i++) {
			if (arr[i] > arr[j]) {
				j++;
				swap(arr, i, j);
			}
		}

		j++;

		while (j < arr.length) {
			arr[j] = 0;
			j++;
		}
	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
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

		int[] arr3 = new int[] {1, 1, 1, 1, 3, 3, 3, 4, 5, 5, 5, 8, 8, 9, 10, 10};
		rdsa.removeDuplicates2(arr3);
		rdsa.display(arr3);
	}
}
