public class TrappingRainWater {

    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = height[0];
        right[n-1] = height[n-1];
        int waterCollected = 0;

        // Populate the left array starting from 1 till n
        for (int i=1; i<n; i++) {
            left[i] = Math.max(left[i-1], height[i]);
        }

        // Populate the right array starting from n-2 till 0
        for (int i=n-2; i>=0; i--) {
            right[i] = Math.max(right[i+1], height[i]);
        }

        for (int i=0; i<n; i++) {
            waterCollected += Math.min(left[i], right[i]) - height[i];
        }

        return waterCollected;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        TrappingRainWater solution = new TrappingRainWater();
        int waterCollected = solution.trap(height);
        System.out.println(waterCollected);
    }
}
