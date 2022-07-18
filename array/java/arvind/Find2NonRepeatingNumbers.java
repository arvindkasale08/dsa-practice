package arvind;

public class Find2NonRepeatingNumbers {

    public int[] findNonRepeating(int[] arr) {
        int xorresult = arr[0];
        for (int i=1; i<arr.length; i++) {
            xorresult ^= arr[i];
        }
        int most_right_set_bit = xorresult & (~ (xorresult - 1));
        int a= 0, b =0;

        for (int i=0; i< arr.length; i++) {
            if ((arr[i] & most_right_set_bit) > 0) {
                a^= arr[i];
            } else {
                b^=arr[i];
            }
        }

        return new int[] {b, a};
    }

    public static void main(String[] args) {
        Find2NonRepeatingNumbers solution = new Find2NonRepeatingNumbers();
        int[] arr = new int[] {10, 2, 2, 6, 4, 6, 3, 7, 3, 7, 8, 8, 9, 9};
        int[] result = solution.findNonRepeating(arr);
        System.out.println("The 2 numbers are "+ result[0] + " "+ result[1]);
    }
}
