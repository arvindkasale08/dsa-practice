package arvind;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

    private class LargerComparator implements Comparator<String> {

        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        }
    }

    public String findLargestNumber(int[] nums) {
        String[] str = new String[nums.length];
        for (int i=0; i<nums.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(str, new LargerComparator());

        if (str[0].equals("0")) {
            return "0";
        }
        String largest = new String();

        for (String s : str) {
            largest+=s;
        }

        return largest;
    }

    public static void main(String[] args) {
        LargestNumber ln = new LargestNumber();
        int[] nums = new int[] {3,30,34,5,9};
        String result = ln.findLargestNumber(nums);
        System.out.println("Largest number is "+ result);
    }
}
