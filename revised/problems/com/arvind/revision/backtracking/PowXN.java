package com.arvind.revision.backtracking;

public class PowXN {

    public double myPow(double x, int n) {
        double res = myPowInner(x, Math.abs((long)n));
        return n < 0 ? 1 / res : res;
    }

    public double myPowInner(double x, long n) {
        if (n == 0) return 1;
        if (n == 1) return x;

        if (n % 2 == 0) {
            return myPowInner(x * x, n/2);
        } else {
            return x * myPowInner(x, n-1);
        }
    }

    public static void main(String[] args) {
        PowXN solution = new PowXN();
        System.out.println(solution.myPow(2.00000, -2));
    }
}
