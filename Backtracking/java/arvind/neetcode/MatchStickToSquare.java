package arvind.neetcode;

import java.util.Arrays;
import java.util.Collections;

public class MatchStickToSquare {

	public boolean isValidSquare(int[] arr) {
		if (arr.length < 4)
			return false;
		int sum = Arrays.stream(arr).sum();
		int max = Arrays.stream(arr).max().getAsInt();
		if (sum % 4 != 0)
			return false;
		int sideLength = sum / 4;
		if (max > sideLength)
			return false;
		return isValidSquare(0, 0, 0, 0, 0, arr, sideLength);
	}

	private boolean isValidSquare(int i, int l, int t, int r, int b, int[] arr, int sideLength) {
		if (allEqual(l, t, r, b) && i == arr.length)
			return true;
		if (l > sideLength || t > sideLength || r > sideLength || b > sideLength)
			return false;
		int stick = arr[i];
		if (isValidSquare(i+1, l + stick, t, r, b, arr, sideLength)) return true;
		if (isValidSquare(i+1, l, t+stick, r, b, arr, sideLength)) return true;
		if (isValidSquare(i+1, l, t, r+stick, b, arr, sideLength)) return true;
		if (isValidSquare(i+1, l, t, r, b+stick, arr, sideLength)) return true;

		return false;
	}

	private boolean allEqual(int l, int t, int r, int b) {
		return l == t && t == r && r == b && b == l;
	}

	public static void main(String[] args) {
		MatchStickToSquare solution = new MatchStickToSquare();
		//int[] arr = {1, 1, 2, 2, 2};
		int[] arr = {3,9,2,2,2,9,10,8,3,9,10,10,1,9,9};
		boolean flag = solution.isValidSquare(arr);
		System.out.println(flag);
	}
}
