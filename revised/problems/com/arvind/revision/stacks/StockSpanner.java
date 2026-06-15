package com.arvind.revision.stacks;

import java.util.Stack;

public class StockSpanner {

    private Stack<Node> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int span = 1;
        while(!stack.isEmpty() && stack.peek().price <= price) {
            Node old = stack.pop();
            span += old.span;
        }
        stack.push(new Node(price, span));
        return span;
    }

    class Node {
        int price;
        int span;

        public Node(int price, int span) {
            this.price = price;
            this.span = span;
        }
    }

    public static void main(String[] args) {

        // [31, 27, 24, 28, 26, 32, 30]
        // [1, 1, 1, 3]
        StockSpanner stockSpanner = new StockSpanner();

        System.out.println(stockSpanner.next(100)); // 1
        System.out.println(stockSpanner.next(80));  // 1
        System.out.println(stockSpanner.next(60));  // 1
        System.out.println(stockSpanner.next(70));  // 2
        System.out.println(stockSpanner.next(60));  // 1
        System.out.println(stockSpanner.next(75));  // 4
        System.out.println(stockSpanner.next(85));  // 6
    }
}
