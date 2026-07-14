package com.arvind.revision.recursion;

public class FiboUsingRecursion {

    public int fib(int N) {
        if (N <= 1) return N;
        return fib(N-1) + fib(N-2);
    }

    public static void main(String[] args) {
        FiboUsingRecursion solution = new FiboUsingRecursion();
        System.out.println(solution.fib(5));
    }
}
