package com.arvind.revision.warmup;

public class FindNumbersWithEvenDigits {

    public int findNumbers(int[] nums) {
        int ans = 0;

        for (int num: nums) {
            String strRep = num + "";
            if (strRep.length() %2 == 0) {
                ans +=1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {12, 345, 2, 6, 7896};
        FindNumbersWithEvenDigits solution = new FindNumbersWithEvenDigits();
        int ans = solution.findNumbers(nums);
        System.out.println(ans);
    }
}
