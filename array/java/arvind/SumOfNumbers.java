package arvind;

public class SumOfNumbers {

    public int sum(int a, int b) {
        while (b != 0) {
            int temp = (a&b) << 1;
            a = (a^b);
            b = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        SumOfNumbers solution = new SumOfNumbers();
        int a = 2;
        int b = 13;
        int result = solution.sum(a, b);
        System.out.println("The sum of a and b is "+ result);
    }
}
