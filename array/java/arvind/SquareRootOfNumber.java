package arvind;

public class SquareRootOfNumber {

    public int findSquareRoot(int number) {
        int low =0, high = number;

        while (low <= high) {
            int mid = (low + high) / 2;
            int sqr = sqr(mid);
            int sqrp1 = sqr(mid + 1);
            if (sqr == number || (sqr < number && sqrp1 > number))
                return mid;

            if (sqr > number) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int sqr(int x) {
        return x * x;
    }

    public static void main(String[] args) {
        SquareRootOfNumber solution = new SquareRootOfNumber();
        int number = 10;
        int result = solution.findSquareRoot(number);
        System.out.println("Result is "+ result);
    }
}
