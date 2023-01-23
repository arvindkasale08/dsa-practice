public class ArrangingCoins {

	public int arrangeCoins(int n) {
		int res = 1;
		int currentStep = 1;
		while (true) {
			if (n <= currentStep) {
				return res;
			}
			n -= currentStep;
			currentStep += 1;
			res +=1;
		}
	}

	public int arrangeCoinsBinarySearch(int n) {
		int low = 0;
		int high = n;

		while (low <= high) {
			int middle = low + (high - low) / 2;
		long sum = (middle * (middle + 1)) / 2;
			if (sum == n) {
				return middle;
			}
			if (sum < n) {
				low = middle + 1;
			} else {
				high = middle - 1;
			}
		}
		return high;
	}

	public static void main(String[] args) {
		ArrangingCoins solution = new ArrangingCoins();
		int n = 1804289383;
		int res = solution.arrangeCoinsBinarySearch(n);
		System.out.println(res);
	}
}
