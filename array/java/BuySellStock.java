public class BuySellStock {
    int maxProfit(int[] nums){
        int buy = nums[0];
        int profit = 0;
        for (int i = 1; i<nums.length; i++) {
            if (nums[i] < nums[i-1]){
                profit += nums[i-1]-buy;
                buy = nums[i];
            }
        }
        return profit + nums[nums.length - 1] - buy;
    }

    public static void main(String[] args){
        BuySellStock bs = new BuySellStock();
        int nums[] = new int[]{7,1,5,3,6,4};
        System.out.println(bs.maxProfit(nums)); 
    }
}
