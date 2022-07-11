public class TrappingRainWater {

    public int trap(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = arr[0];
        right[n-1] = arr[n-1];
        int totalWaterTrapped = 0;

        for (int i=1; i<n; i++) {
            left[i] = Math.max(arr[i], left[i-1]);
        }

        for (int i=n-2; i>=0; i--) {
            right[i] = Math.max(arr[i], right[i+1]);
        }

        for (int i =0; i < n; i++) {
            totalWaterTrapped += Math.min(left[i], right[i]) - arr[i];
        }

        return totalWaterTrapped;
    }

    public static void main(String[] args) {
        TrappingRainWater solution = new TrappingRainWater();
        int[] arr = new int[] {4, 2, 0, 3, 2, 5};
        int totalWater = solution.trap(arr);
        System.out.println("Total water trapped by contraption= "+ totalWater);
    }
}
