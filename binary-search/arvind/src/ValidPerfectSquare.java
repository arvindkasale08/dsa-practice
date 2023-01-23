public class ValidPerfectSquare {

	public boolean isPerfectSquare(int num) {
		long low = 0;
		long high = num / 2;

		if (num == 1)
			return true;

		while (low <= high) {
			long middle = low + (high - low) / 2;
			if (middle * middle == num) return true;

			if (middle * middle < num) {
				low = middle + 1;
			} else {
				high = middle - 1;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int num = 808201;
		ValidPerfectSquare solution = new ValidPerfectSquare();
		boolean result = solution.isPerfectSquare(num);
		System.out.println(result);
	}
}
