package arvind;

public class BuySellStock {

    public int findTotalProfit(int[] arr) {
        int totalProfit = 0;
        int buy = arr[0];

        for (int i=1; i<arr.length; i++) {
            if (arr[i] < arr[i-1]) {
                totalProfit+= arr[i-1] - buy;
                buy = arr[i];
            }
        }

        return totalProfit + arr[arr.length - 1] - buy;
    }

    public static void main(String[] args) {
        BuySellStock stock = new BuySellStock();
        int[] arr = new int[] {98, 178, 250, 300, 40, 540, 690};
        int result = stock.findTotalProfit(arr);
        System.out.println("Total Profit is "+ result);
    }
}
