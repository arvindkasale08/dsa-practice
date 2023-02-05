public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] res = new int[m+n];

        int carry = 0;
        int offset = 0;
        int sumCarry = 0;
        for (int j=n-1; j>=0; j--) {
            int rIdx = m + n - 1 - offset;
            for (int i=m-1; i>=0; i--) {
                int x = Character.getNumericValue(num1.charAt(i));
                int y = Character.getNumericValue(num2.charAt(j));
                int result = x * y + carry;
                if (result > 9) {
                    carry = result / 10;
                    result = result % 10;
                } else {
                    carry = 0;
                }
                res[rIdx] = res[rIdx] + result + sumCarry;
                if (res[rIdx] > 9) {
                    sumCarry = res[rIdx] / 10;
                    res[rIdx] %= 10;
                } else {
                    sumCarry = 0;
                }
                rIdx -= 1;
            }
            offset += 1;
        }


        StringBuilder sb = new StringBuilder();

        boolean firstZerosExcluded = false;
        for (int i=0; i<res.length; i++) {
            if (res[i] == 0 && !firstZerosExcluded) {
                continue;
            }
            firstZerosExcluded = true;
            sb.append(res[i]);
        }


        return sb.toString();
    }

    public static void main(String[] args) {
        MultiplyStrings solution = new MultiplyStrings();
        String num1 = "9";
        String num2 = "9";
        String output = solution.multiply(num1, num2);
        System.out.println(output);
    }
}
