package com.arvind.revision.backtracking;

public class CountGoodNumbers {

    public static final int  MODULO = 1000000007;

    public int countGoodNumbers(long n) {
        long evenPositions = (n + 1) / 2;
        long oddPositions = n / 2;

        long ans = (pow(5, evenPositions) * pow(4, oddPositions)) % MODULO;
        return (int) ans;
    }

    private long pow(long x, long n) {
        if(n == 0) return 1;
        if (n == 1) return x;

        if (n % 2 == 0) {
            return pow((x*x) % MODULO, n/2);
        } else {
            return (x * (pow(x, n-1)% MODULO)) % MODULO;
        }
    }

    public static void main(String[] args) {
        CountGoodNumbers solution = new CountGoodNumbers();
        //System.out.println(solution.countGoodNumbers(50));
        System.out.println(solution.countGoodNumbers(806166225460393l));
    }
}
