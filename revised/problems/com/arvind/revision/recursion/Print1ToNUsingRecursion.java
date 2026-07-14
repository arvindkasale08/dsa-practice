package com.arvind.revision.recursion;

public class Print1ToNUsingRecursion {

    public void printNumbers(int idx, int N) {
        if (idx > N) return;
        System.out.print(idx + " ");
        printNumbers(idx + 1, N);
    }

    public static void main(String[] args) {
        Print1ToNUsingRecursion solution = new Print1ToNUsingRecursion();
        solution.printNumbers(1, 5);
    }
}
