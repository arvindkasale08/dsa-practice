package arvind.neetcode;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

    class StringComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            String s1 = o1 + o2;
            String s2 = o2 + o1;

            return s2.compareTo(s1);
        }
    }

    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for (int i=0; i<nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr, new StringComparator());

        if (arr[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();

        for (String s : arr) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        LargestNumber solution = new LargestNumber();
        String s = solution.largestNumber(nums);
        System.out.println(s);
    }
}
