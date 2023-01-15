package arvind.neetcode;

import java.util.HashMap;

public class SubArrayEqualsK {

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixCount = new HashMap<>();
        // remember to add a 0
        prefixCount.put(0, 1);
        int res = 0;
        int currSum = 0;
        for (int i=0; i<nums.length; i++) {
            currSum += nums[i];
            prefixCount.put(currSum, prefixCount.getOrDefault(currSum, 0) + 1);
            res += prefixCount.containsKey(currSum - k) ? prefixCount.get(currSum - k): 0;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        int k = 0;
        SubArrayEqualsK solution = new SubArrayEqualsK();
        int sum = solution.subarraySum(nums, k);
        System.out.println(sum);
    }
}
