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

	public static void main(String[] args) {
		ArrangingCoins solution = new ArrangingCoins();
		int n = 8;
		int res = solution.arrangeCoins(n);
		System.out.println(res);
	}
}
