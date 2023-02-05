import java.util.Arrays;

public class PlusOne {

    public int[] plusOne(int[] digits) {
        int[] newDigits = new int[digits.length+1];
        newDigits[0] = 1;
        int carry = 1;
        for (int i=digits.length-1; i>=0; i--) {
            if (carry > 0) {
                if (digits[i] == 9) {
                    digits[i] = 0;
                    newDigits[i+1] = 0;
                    carry = 1;
                } else {
                    digits[i] += 1;
                    newDigits[i+1] = digits[i];
                    carry = 0;
                }
            } else {
                newDigits[i+1] = digits[i];
            }
        }
        if (carry == 1) {
            return newDigits;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] digits = new int[] {9};
        PlusOne solution = new PlusOne();
        int[] result = solution.plusOne(digits);
        System.out.println(Arrays.toString(result));
    }
}
