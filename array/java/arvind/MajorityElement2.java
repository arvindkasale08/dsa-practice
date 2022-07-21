package arvind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MajorityElement2 {

    public List<Integer> findMajority(int[] arr) {
        int maj1 = arr[0];
        int maj2 = arr[1];
        int count1 = 1;
        int count2 = 1;

        for (int i=2; i< arr.length; i++) {
            if (maj1 == arr[i]) {
                count1++;
            } else if (maj2 == arr[i]) {
                count2++;
            } else {
                count1--;
                count2--;
            }
            if (count1 == 0) {
                maj1 = arr[i];
                count1 = 1;
            } else if (count2 == 0) {
                maj2 = arr[i];
                count2 = 1;
            }
        }

        return Arrays.asList(maj1, maj2);
    }

    public List < Integer > majorityElement(int[] nums) {

        // 1st pass
        int count1 = 0;
        int count2 = 0;

        Integer candidate1 = null;
        Integer candidate2 = null;

        for (int n: nums) {
            if (candidate1 != null && candidate1 == n) {
                count1++;
            } else if (candidate2 != null && candidate2 == n) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = n;
                count1++;
            } else if (count2 == 0) {
                candidate2 = n;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        // 2nd pass
        List result = new ArrayList <> ();

        count1 = 0;
        count2 = 0;

        for (int n: nums) {
            if (candidate1 != null && n == candidate1) count1++;
            if (candidate2 != null && n == candidate2) count2++;
        }

        int n = nums.length;
        if (count1 > n/3) result.add(candidate1);
        if (count2 > n/3) result.add(candidate2);

        return result;
    }

    public static void main(String[] args) {
        MajorityElement2 solution = new MajorityElement2();
        int[] arr = new int[] {3, 2, 3};
        List<Integer> result = solution.findMajority(arr);
        System.out.println(result);
    }
}
