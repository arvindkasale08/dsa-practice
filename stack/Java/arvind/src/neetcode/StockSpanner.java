package neetcode;

import java.util.Stack;

class StockSpanner {

    class Stock {
        int val;
        int spans;

        public Stock(int val) {
            this.spans = 1;
            this.val = val;
        }
    }

    private Stack<Stock> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        Stock stock = new Stock(price);
        if (stack.isEmpty() || stack.peek().val > price) {
            stack.push(stock);
            return 1;
        }
        int span = 1;

        while (!stack.isEmpty() && stack.peek().val <= price) {
            Stock popped = stack.pop();
            span += popped.spans;
        }
        stock.spans = span;
        stack.push(stock);
        return stock.spans;
    }

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100)); // return 1
        System.out.println(stockSpanner.next(80));  // return 1
        System.out.println(stockSpanner.next(60));  // return 1
        System.out.println(stockSpanner.next(70));  // return 2
        System.out.println(stockSpanner.next(60));  // return 1
        System.out.println(stockSpanner.next(75));  // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
        System.out.println(stockSpanner.next(85));  // return 6
    }
}
