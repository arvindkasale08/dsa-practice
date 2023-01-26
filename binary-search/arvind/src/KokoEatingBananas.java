import java.util.Arrays;

public class KokoEatingBananas {

	public int minEatingSpeed(int[] piles, int h) {
		int low = 1;
		int high = Arrays.stream(piles).max().getAsInt();
		int res = h;

		while (low <= high) {
			int middle = low + (high - low) / 2;
			int hoursTaken = getHoursTaken(middle, piles);

			if (hoursTaken <= h) {
				res = Math.min(res, middle);
				high = middle - 1;
			} else {
				low = middle + 1;
			}
		}

		return res;
	}

	private int getHoursTaken(int val, int[] piles) {
		int rate = 0;

		for (int pile : piles) {
				rate += (pile + (val -1)) / val;
		}

		return rate;
	}

	public static void main(String[] args) {
		int[] piles = {3, 6, 7, 11};
		int h = 10;
		KokoEatingBananas solution = new KokoEatingBananas();
		int rate = solution.minEatingSpeed(piles, h);
		System.out.println(rate);
	}
}
