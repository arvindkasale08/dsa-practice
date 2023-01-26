import java.util.HashSet;
import java.util.Set;

public class MaximumNumberOfRemovableCharacters {

	public int maximumRemovals(String s, String p, int[] removable) {
		int low = 0;
		int high = removable.length - 1;
		int res = 0;
		while (low <= high) {
			int middle = low + (high - low) / 2;
			Set<Integer> removed = new HashSet<>();
			for (int i=0; i<= middle; i++) {
				removed.add(removable[i]);
			}
			if (isSubString(s, p, removed)) {
				res = Math.max(middle+1, res);
				low = middle + 1;
			} else {
				high = middle - 1;
			}
		}
		return res;
	}

	private boolean isSubString(String s, String p, Set<Integer> removed) {
		int i = 0;
		int j = 0;

		while (i < s.length()) {
			if (removed.contains(i)) {
				i++;
				continue;
			}
			if (j == p.length()) {
				return true;
			}
			if (s.charAt(i) == p.charAt(j)) {
				j++;
			}
			i++;
		}
		if (j == p.length()) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		MaximumNumberOfRemovableCharacters solution = new MaximumNumberOfRemovableCharacters();
		String s = "abcbddddd";
		String p = "abcd";
		int[] removable = new int[] {3,2,1,4,5,6};
		int no = solution.maximumRemovals(s, p, removable);
		System.out.println(no);
	}
}
