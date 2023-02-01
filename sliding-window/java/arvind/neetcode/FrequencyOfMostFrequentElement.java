package arvind.neetcode;

import java.util.Arrays;

public class FrequencyOfMostFrequentElement {

	public int maxFrequency(int[] nums, int k) {
		Arrays.sort(nums);
		int l = 0;
		int sum = 0;
		int length = 0;
		for (int r = 0;r <nums.length; r++) {
			sum += nums[r];
			if (!isValid(nums, k, l ,r, sum)) {
				sum -= nums[l];
				l++;
			}
			length = Math.max(length, r-l+1);
		}

		return length;
	}

	private boolean isValid(int[] nums, int k, int l, int r, int sum) {
		return (k + sum) >= (nums[r] * (r-l+1));
	}

	public static void main(String[] args) {
		int[] nums = {1, 4, 8, 13};
		int k = 11;
		FrequencyOfMostFrequentElement solution = new FrequencyOfMostFrequentElement();
		int result = solution.maxFrequency(nums, k);
		System.out.println(result);
	}
}
