package com.arvind.revision.recursion;

public class Factorial {

    public int fact(int num) {
        if (num == 1) return num;
        return num * fact(num - 1);
    }

    public static void main(String[] args) {
        Factorial solution = new Factorial();
        System.out.println(solution.fact(10));
    }
}
