package arvind.neetcode;

import java.util.HashSet;
import java.util.Set;

public class MaxLengthOfConcatString {

	public int findLength(String[] arr) {
		int[] length = new int[1];
		Set<Character> set = new HashSet<>();
		findLength(0, arr, set, length);
		return length[0];
	}

	private void findLength(int i, String[] arr, Set<Character> set, int[] length) {
		if (i == arr.length)
			return;

		// dont pick
		findLength(i+1, arr, set, length);
		int le = set.size();
		// pick
		String s = arr[i];
		HashSet<Character> newSet = new HashSet<>();
		for (char c : s.toCharArray()) {
			if (newSet.contains(c) || set.contains(c)) {
				return;
			}
			le+=1;
			newSet.add(c);
		}
		length[0] = Math.max(le, length[0]);
		newSet.addAll(set);
		findLength(i+1, arr, newSet, length);
	}

	public static void main(String[] args) {
		//String[] arr = {"un", "iq", "ue"};
		String[] arr = {"aa", "bb"};
		//String[] arr = {"abcdefghijklm","bcdefghijklmn","cdefghijklmno","defghijklmnop","efghijklmnopq","fghijklmnopqr","ghijklmnopqrs","hijklmnopqrst","ijklmnopqrstu","jklmnopqrstuv","klmnopqrstuvw","lmnopqrstuvwx","mnopqrstuvwxy","nopqrstuvwxyz","opqrstuvwxyza","pqrstuvwxyzab"};
		MaxLengthOfConcatString solution = new MaxLengthOfConcatString();
		int length = solution.findLength(arr);
		System.out.println(length);
	}
}
