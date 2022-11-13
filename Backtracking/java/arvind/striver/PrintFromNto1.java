package arvind.striver;

public class PrintFromNto1 {

    public void printReverse(int i, int n) {
        if (i > n)
            return;
        printReverse(i+1, n);
        System.out.println(i);
    }

    public static void main(String[] args) {
        PrintFromNto1 solution = new PrintFromNto1();
        int n = 5;
        solution.printReverse(1, n);
    }
}
