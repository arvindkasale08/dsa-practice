package com.arvind.revision.fastslow;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();
        visited.add(n);
        while (n != 1) {
            n = sumOfSquares(n);
            System.out.println(n);
            if (visited.contains(n)) return false;
            visited.add(n);
        }
        return true;
    }

    private int sumOfSquares(int n) {
        int sumOfSq = 0;
        while (n > 0) {
            int i = n % 10;
            n = n / 10;
            sumOfSq += i * i;
        }
        return sumOfSq;
    }

    public static void main(String[] args) {
        HappyNumber solution = new HappyNumber();
        System.out.println(solution.isHappy(19));
    }
}
