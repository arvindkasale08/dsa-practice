package practice2;

import arvind.Find2NonRepeatingNumbers;

public class FindTwoNonRepeatingNumbers {

    public int[] findNonRepeating(int[] arr) {
        int xorResult = 0;

        for (int a: arr) {
            xorResult ^= a;
        }

        System.out.println(xorResult);

        // find the last most set bit
        int lastMostSetBit = xorResult & (~(xorResult - 1));

        // divide numbers into 2 groups
        int a = 0, b = 0;

        for (int x : arr) {
            if ((x & lastMostSetBit) > 0) {
                a ^= x;
            } else {
                b ^= x;
            }
        }

        return new int[] { a, b};
    }

    public static void main(String[] args) {
        FindTwoNonRepeatingNumbers solution = new FindTwoNonRepeatingNumbers();
        int[] arr = new int[] {10, 2, 2, 6, 4, 6, 3, 7, 3, 7, 8, 8, 9, 9, 10, 8};
        int[] result = solution.findNonRepeating(arr);
        System.out.println("2 non repeating numbers are "+ result[0] + " "+ result[1]);
    }
}
