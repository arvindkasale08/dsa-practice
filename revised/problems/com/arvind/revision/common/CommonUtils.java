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

    public static ListNode createList(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode temp = head;
        for (int i=1; i< arr.length; i++) {
            ListNode curr = new ListNode(arr[i]);
            temp.next = curr;
            temp = curr;
        }
        return head;
    }
}
