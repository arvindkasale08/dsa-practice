package com.arvind.revision.common;

import java.util.List;

public class CommonUtils {

    public static void print(int[] num) {
        for (int n : num) {
            System.out.print(n + ", ");
        }
        System.out.println("\n #########################");
    }

    public static void print(List<List<String>> res) {
        for (List<String> r: res) {
            for (String s : r) {
                System.out.print(s + ", ");
            }
            System.out.println("\n ###########################");
        }
        System.out.println("\n ###########################");
    }
}
