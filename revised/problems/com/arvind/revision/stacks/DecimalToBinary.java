package com.arvind.revision.stacks;

public class DecimalToBinary {

    public String decimalToBinary(int num) {
        StringBuilder sb = new StringBuilder();
        // ToDo: Write Your Code Here.
        while (num > 0) {
            int rem = num % 2;
            num /= 2;
            sb.append(rem);
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        int ip = 18;
        int ip2 = 17;
        DecimalToBinary solution = new DecimalToBinary();
        String op = solution.decimalToBinary(ip);
        System.out.println(op);
        String op2 = solution.decimalToBinary(ip2);
        System.out.println(op2);
    }
}
