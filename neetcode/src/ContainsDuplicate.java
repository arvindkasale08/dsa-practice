import java.util.HashSet;

public class ContainsDuplicate {

    public boolean solve(int[] nums) {
        HashSet<Integer> set = new HashSet();
        for (int i=0; i< nums.length; i++) {
            if (set.contains(nums[i]))
                return true;
            set.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        int[] arr = new int[] {1, 2, 3, 1};
        boolean result = containsDuplicate.solve(arr);
        System.out.println(result);
    }
}
