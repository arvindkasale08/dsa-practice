package practice2;

public class SumOfNumbers {

    public int sum(int a, int b) {
        while (b != 0) {
            int tmp = (a & b) << 1;
            a = (a ^ b);
            b = tmp;
        }
        return a;
    }

    public static void main(String[] args) {
        SumOfNumbers solution = new SumOfNumbers();
        int a = 4;
        int b = 3;

        // expected ans is 9
        int result = solution.sum(a, b);
        System.out.println(" The sum of a and b is "+ result);
    }
}
