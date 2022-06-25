import java.util.*;

public class ThreeSumClosest {
    int threeSumClosest(int nums[], int target){
        int res = 9999;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2;i++){
            int l = i + 1;
            int r = nums.length - 1;
            
            while (l < r) {
                int threeSum = nums[i] + nums[l] + nums[r];
                if (Math.abs(target - threeSum) < Math.abs(res)) {
                    res = target - threeSum;
                }
                if (threeSum < target) {
                    l += 1;
                } else {
                    r -= 1;
                }
                if (res == 0){
                    break;
                }
            }
        }
        return target - res;
    }

    public static void main(String[] args){
        ThreeSumClosest ts = new ThreeSumClosest();
        int arr[] = {-1,2,1,-4};
        int target = 1;
        
        int ans = ts.threeSumClosest(arr, target);
        System.out.println("Three sum closest: "+ans);

    }
}
