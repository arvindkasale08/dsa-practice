package com.arvind.revision;

public class Sqrt {

    public int mySqrt(int x) {
        // TODO: Write your code here
        // if 0 or 1
        if (x < 2) return x;

        // else
        int left = 0;
        int right = x/2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long mul = (long) mid * mid;
            if (mul <  x) {
                left = mid + 1;
            } else if (mul > x){
                right = mid - 1;
            } else {
                return(mid);
            }
        }
        return right;
    }

    public static void main(String[] args) {
        int x = 2147395600;
        Sqrt sqrt = new Sqrt();
        int out = sqrt.mySqrt(x);
        System.out.println(out);
    }
}
