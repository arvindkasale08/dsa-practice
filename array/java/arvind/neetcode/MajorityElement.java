package arvind.neetcode;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int maj = nums[0];
        int count = 1;

        for (int i=1; i< nums.length; i++) {
            if (maj == nums[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    maj = nums[i];
                    count = 1;
                }
            }
        }
        return maj;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        MajorityElement solution = new MajorityElement();
        int result = solution.majorityElement(nums);
        System.out.println(result);
    }
}
