public class TrappingRainWater {
    int trap(int[] height){
        if (height.length == 0){
            return 0;
        }
        int res = 0;
        int left[] = new int[height.length];
        int right[] = new int[height.length];
        left[0] = height[0];
        right[height.length-1] = height[height.length-1];
        for (int i = 1; i<height.length; i++){
            left[i] = Math.max(left[i-1], height[i]);
        } 
        for (int i = height.length-2; i>-1; i--){
            right[i] = Math.max(right[i+1], height[i]);
        } 
        for (int i = 0; i<height.length; i++){
            res = Math.min(left[i],right[i]-height[i]);
        } 
        return res;
    }

    public static void main(String[] args){
        TrappingRainWater trw = new TrappingRainWater();
        int height[] = new int[]{1,2,3,4,5,6,5,4,3,2,1};
        int res = trw.trap(height);
        System.out.println("Traped water: "+res);
    }
}
