import java.util.Arrays;

public class FractionalKnapsack {
    public float fractionalknapsack(int[][] Items, float W) {
        float profit = 0;

        Arrays.sort(Items, (a,b)-> (b[1] / b[0]) - (a[1] / a[0]));
        
        for(int i = 0; i < Items.length; i++) {
            if(W >= Items[i][0]) {
                W -= Items[i][0];
                profit += Items[i][1];
            } else {
                profit += (W / Items[i][0]) * Items[i][1];
                break;
            }
        }
        return profit;
    }
    public static void main(String[] args){
        FractionalKnapsack fs = new FractionalKnapsack();
        int Items[][] = new int[][]{{10, 60}, {20, 100}, {30, 120}};
        int W = 50;
        System.out.println(fs.fractionalknapsack(Items, W));
    }
}
