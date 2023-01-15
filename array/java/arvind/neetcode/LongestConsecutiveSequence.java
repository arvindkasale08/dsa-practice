package arvind.neetcode;

import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSequence {

    public int longestConsecutiveBetter(int[] nums) {
        HashSet<Integer> hash = new HashSet<>();
        for (int num : nums) {
            hash.add(num);
        }
        int maxConsecutive = 0;
        for (int i=0; i<nums.length; i++) {
            int num = nums[i];
            // check if number is left most of sequence
            if (!hash.contains(num-1)) {
                int consecutive = 1;
                int offset = 1;
                while (hash.contains(num + offset)) {
                    consecutive += 1;
                    offset +=1;
                }
                maxConsecutive = Math.max(consecutive, maxConsecutive);
            }
        }
        return maxConsecutive;
    }

    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int currentConsecutive = 1;
        int maxConsecutive = currentConsecutive;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] == nums[i-1] + 1) {
                currentConsecutive += 1;
                maxConsecutive = Math.max(maxConsecutive, currentConsecutive);
            } else {
                currentConsecutive = 1;
            }
        }
        return maxConsecutive;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence solution = new LongestConsecutiveSequence();
        int[] nums = {100, 4, 200, 1, 3, 2};
        int count = solution.longestConsecutiveBetter(nums);
        System.out.println(count);
    }
}
