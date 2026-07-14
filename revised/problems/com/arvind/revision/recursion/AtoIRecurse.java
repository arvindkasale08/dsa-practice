package com.arvind.revision.recursion;

public class AtoIRecurse {

    public int myAtoi(String s) {
        int i = 0;
        s = s.stripLeading();
        char[] arr = s.toCharArray();
        boolean isPos = true;
        boolean hasLeading = false;
        StringBuilder sb = new StringBuilder();
        // make the string better
        while (i < arr.length) {
            char c = arr[i];
            if (c == '0') {
                hasLeading = true;
                i++;
            } else if (c == '-') {
                if (hasLeading) break;
                isPos = false;
                i++;
            } else if (c == '+') {
                if (hasLeading) break;
                isPos = true;
                i++;
            } else {
                break;
            }
        }
        convertor(i, arr, sb);
        if (sb.isEmpty()) return 0;
        int result = clamp(isPos ? Long.parseLong(sb.toString()) : - Long.parseLong(sb.toString()));
        return result;
    }

    private int clamp(long result) {
        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        return (int) result;
    }

    private void convertor(int idx, char[] arr, StringBuilder sb) {
        if (idx >= arr.length) return;
        if (!Character.isDigit(arr[idx])) return;
        sb.append(arr[idx]);
        convertor(idx+1, arr, sb);
    }

    public static void main(String[] args) {
        String s = "-91283472332";
        String s2 = "0-1";
        AtoIRecurse solution = new AtoIRecurse();
        System.out.println(solution.myAtoi(s));
    }
}
