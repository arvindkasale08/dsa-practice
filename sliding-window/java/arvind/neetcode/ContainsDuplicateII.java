package arvind.neetcode;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> windowElements = new HashSet<>();
        int l = 0;
        int r = 0;
        int n = nums.length;
        if (k == 0)
            return false;
        while (r < n) {
            if (windowElements.contains(nums[r])) {
                return true;
            }
            if (r-l == k) {
                // remove the l side and move ahead;
                windowElements.remove(nums[l]);
                l +=1;
            }
            windowElements.add(nums[r]);
            r +=1;
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicateII solution = new ContainsDuplicateII();
        int[] nums = new int[] {1, 2, 1};
        int k= 0;
        boolean res = solution.containsNearbyDuplicate(nums, k);
    }
}
