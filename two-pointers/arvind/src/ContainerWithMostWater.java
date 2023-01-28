public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int maxArea = 0;
        int l = 0;
        int h = height.length - 1;

        while (l < h) {
            int currentArea = (h - l) * Math.min(height[l], height[h]);
            maxArea = Math.max(currentArea, maxArea);

            if (height[h] >= height[l]) {
                l += 1;
            } else {
                h -= 1;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater solution = new ContainerWithMostWater();
        int[] heights = {1,8,6,2,5,4,8,3,7};
        int area = solution.maxArea(heights);
        System.out.println(area);
    }
}
