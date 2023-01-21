package arvind.neetcode;

import java.util.HashMap;

public class ContinousSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> remainderMap = new HashMap<>();
        remainderMap.put(0, -1);
        int prefixedSum = 0;
        for (int i=0; i<nums.length; i++) {
            prefixedSum += nums[i];
            int rem = prefixedSum % k;
            if (remainderMap.containsKey(rem) && i - remainderMap.get(rem) > 1) {
                return true;
            }
            if (!remainderMap.containsKey(rem)) {
                remainderMap.put(rem, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {5, 0, 0, 0};
        int k = 3;
        ContinousSubarraySum solution = new ContinousSubarraySum();
        boolean flag = solution.checkSubarraySum(nums, k);
        System.out.println(flag);
    }
}
