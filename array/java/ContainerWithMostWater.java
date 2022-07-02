public class ContainerWithMostWater {
    int maxArea(int height[]) {
        int mArea = 0;
        int i = 0;
        int j = height.length - 1;
        while(i != j) {
            mArea = Math.max(mArea, (j - i) * Math.min(height[i], height[j]));
            if (height[i] > height[j]) {
                j -= 1;
            } else {
                i += 1;
            }
        }
        return mArea;
    }

    public static void main(String[] args){
        ContainerWithMostWater cw = new ContainerWithMostWater();
        int height[] = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(cw.maxArea(height));

    }
}
