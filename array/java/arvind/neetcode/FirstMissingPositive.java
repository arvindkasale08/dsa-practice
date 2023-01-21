package arvind.neetcode;

public class FirstMissingPositive {

	public int firstMissingPositive(int[] nums) {
		int n = nums.length;

		for (int i=0; i<n; i++) {
			if (nums[i] < 0) {
				nums[i] = n+2;
			}
		}

		for (int i=0; i<n; i++) {
			int absnums = Math.abs(nums[i]);
			if (absnums >=0 && absnums <= n) {
				if (nums[absnums-1] >= 0) {
					nums[absnums-1] = 0 - nums[absnums-1];
				}
			}
		}


		for (int i=1; i<= n; i++) {
			if (nums[i-1] > 0) {
				return i;
			}
		}

		return n+1;
	}

	public static void main(String[] args) {
		FirstMissingPositive solution = new FirstMissingPositive();
		int[] nums = new int[] {3, 4, -1, 1};
		int result = solution.firstMissingPositive(nums);
		System.out.println(result);
	}
}
