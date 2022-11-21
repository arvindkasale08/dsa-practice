package arvind.p1;

public class KPermutationSequence {

	public String find(int n, int k) {
		int[] arr = new int[n];
		for (int i=1; i<=n; i++) {
			arr[i-1] = i;
		}
		StringBuilder sb = new StringBuilder();
		find(n, k-1, arr, sb);
		return sb.toString();
	}

	private void find(int n, int k, int[] arr, StringBuilder sb) {
		if (n == 0)
			return;
		int fact = fact(n-1);
		int key = k / fact;
		sb.append(arr[key]);
		int[] newArr = remove(arr, key);
		find(n-1, k % fact, newArr, sb);
	}

	private int[] remove(int[] arr, int key) {
		int[] newArr = new int[arr.length-1];
		int idx = 0;
		for (int i=0; i< arr.length; i++) {
			if (i == key)
				continue;
			newArr[idx] = arr[i];
			idx++;
		}
		return newArr;
	}

	private int fact(int n) {
		int ans = 1;
		while (n > 0) {
			ans *= n;
			n--;
		}
		return ans;
	}

	public static void main(String[] args) {
		int n = 3;
		int k = 3;
		KPermutationSequence solution = new KPermutationSequence();
		String str = solution.find(n, k);
		System.out.println(str);
	}
}

