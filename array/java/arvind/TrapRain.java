package arvind;

public class TrapRain {

    public int measure(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = arr[0];
        right[n-1] = arr[n-1];

        // create left
        for (int i=1; i < n; i++) {
            left[i] = Math.max(arr[i], left[i-1]);
        }

        for (int i=n-2; i>=0; i--) {
            right[i] = Math.max(arr[i], right[i+1]);
        }
        int totalWater = 0;
        for (int i=0; i< n; i++) {
            totalWater += Math.min(left[i], right[i])-arr[i];
        }
        return totalWater;
    }

    public static void main(String[] args) {
        TrapRain rain = new TrapRain();
        int[] arr = new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int collectedWater = rain.measure(arr);
        System.out.println("Collected rain water is "+ collectedWater);
    }
}
