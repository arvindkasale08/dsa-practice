package practice2;

public class BuySellStock {

    public int findProfit(int[] arr) {
        int buy = arr[0];
        int totalProfit = 0;

        for (int i=1; i<arr.length; i++) {
            if (arr[i] < arr[i-1]) {
                totalProfit += arr[i-1] - buy;
                buy = arr[i];
            }
        }

        return totalProfit + arr[arr.length - 1] - buy;
    }

    public static void main(String[] args) {
        BuySellStock stock = new BuySellStock();
        int[] arr = new int[] {98, 178, 250, 300, 40, 540, 690};
        int result = stock.findProfit(arr);
        System.out.println("Total profit is "+ result);
    }
}
