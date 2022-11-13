package arvind.striver;

public class PrintNameNTime {

    public void print(int n) {
        if (n == 0)
            return;
        System.out.println("Arvind");
        print(n-1);
    }

    public static void main(String[] args) {
        int n = 5;
        PrintNameNTime solution = new PrintNameNTime();
        solution.print(n);
    }
}
