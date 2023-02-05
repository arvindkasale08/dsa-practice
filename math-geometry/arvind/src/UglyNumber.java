public class UglyNumber {

    public boolean isUgly(int n) {
        int[] factors = {2, 3, 5};


        for (int factor : factors) {
            while (n > 0 && n % factor == 0) {
                n /= factor;
            }
        }
        return n == 1;
    }

    public static void main(String[] args) {
        UglyNumber solution = new UglyNumber();
        int n = 3;
        boolean result = solution.isUgly(n);
        System.out.println(result);
    }
}
