package com.arvind.revision.recursion;

public class PrintNameNTimes {

    public void printName(String name, int idx, int N) {
        if (idx >= N) {
            return;
        }
        System.out.println(name);
        printName(name, idx+1, N);
    }

    public static void main(String[] args) {
        PrintNameNTimes solution = new PrintNameNTimes();
        solution.printName("Arvind", 0, 5);
    }
}
