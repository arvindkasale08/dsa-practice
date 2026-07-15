package com.arvind.revision.common;

import java.util.List;

public class CommonUtils {

    public static void print(int[] num) {
        for (int n : num) {
            System.out.print(n + ", ");
        }
        System.out.println("\n #########################");
    }

    public static void printList(List<Integer> num) {
        for (Integer i : num) {
            System.out.print(i + ", ");
        }
        System.out.println("\n#################");
    }

    public static void printListStr(List<String> lst) {
        for (String s : lst) {
            System.out.print(s + ", ");
        }
        System.out.println("\n#################");
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

    public static void printListListInt(List<List<Integer>> res) {
        for (List<Integer> r : res) {
            for (Integer i : r) {
                System.out.print(i + ", ");
            }
            System.out.println("\n ############################");
        }
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

    public static void print(ListNode head) {
        if(head == null) {
            System.out.println("Null head");
        }
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(" "+ head.val + ",");
            head = head.next;
        }
        System.out.println(sb.deleteCharAt(sb.length()-1));
    }
}
