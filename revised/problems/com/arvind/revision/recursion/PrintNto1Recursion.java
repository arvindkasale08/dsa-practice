package com.arvind.revision.recursion;

public class PrintNto1Recursion {

    public void printDesc(int n) {
        if (n == 0) return;

        System.out.print(n + " ");
        printDesc(n-1);
    }

    public static void main(String[] args) {
        PrintNto1Recursion solution = new PrintNto1Recursion();
        solution.printDesc(10);
    }
}
