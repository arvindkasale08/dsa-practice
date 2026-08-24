package com.arvind.revision.pod;

public class CheckDivBySumProd {

    public boolean checkDivisibility(int n) {
        int sum = 0;
        int prod = 1;
        int num = n;
        while (n > 0) {
            int rem = n % 10;
            n = n / 10;
            sum += rem;
            prod *= rem;
        }
        return num % (sum + prod) == 0;
    }

    public static void main(String[] args) {
        int n = 99;
        CheckDivBySumProd solution = new CheckDivBySumProd();
        System.out.println(solution.checkDivisibility(n));
    }
}
