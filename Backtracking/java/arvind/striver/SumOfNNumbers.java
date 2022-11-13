package arvind.striver;

public class SumOfNNumbers {

    public int find(int n) {
        if (n == 0)
            return 0;

        return n + find(n-1);
    }

    public static void main(String[] args) {
        SumOfNNumbers solution = new SumOfNNumbers();
        int n = 10;
        System.out.println(solution.find(n));
    }
}
