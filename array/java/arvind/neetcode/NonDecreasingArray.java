package arvind.neetcode;

public class NonDecreasingArray {

	public boolean checkPossibility(int[] nums) {
		int numberOfInfractions = 0;
		int i = 1;
		while(i < nums.length) {
			if (nums[i-1] > nums[i]) {
				if (i == nums.length - 1 || (i+1 < nums.length && nums[i+1] >= nums[i-1])) {
					nums[i] = nums[i-1];
					i++;
				} else {
					nums[i-1] = nums[i];
					i = i - 2 <= 0 ? 1 : i - 2;
				}
				numberOfInfractions += 1;
				if (numberOfInfractions > 1) {
					return false;
				}
				continue;
			}

			i++;
		}

		return true;
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 4, 5, 3};
		NonDecreasingArray solution = new NonDecreasingArray();
		boolean flag = solution.checkPossibility(nums);
		System.out.println(flag);
	}
}
