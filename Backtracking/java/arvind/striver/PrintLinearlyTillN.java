package arvind.striver;

public class PrintLinearlyTillN {

    public void print(int i, int n) {
        if (i > n)
            return;
        System.out.println(i);
        print(i+1, n);
    }

    public static void main(String[] args) {
        PrintLinearlyTillN solution = new PrintLinearlyTillN();
        int n = 2;
        solution.print(1, n);
    }
}
