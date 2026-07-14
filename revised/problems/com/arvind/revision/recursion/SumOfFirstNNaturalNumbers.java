package com.arvind.revision.recursion;

public class SumOfFirstNNaturalNumbers {

    public int sum(int N) {
        if (N == 1) return N;
        return N + sum(N-1);
    }

    public static void main(String[] args) {
        SumOfFirstNNaturalNumbers solution = new SumOfFirstNNaturalNumbers();
        System.out.println(solution.sum(10));
    }
}
