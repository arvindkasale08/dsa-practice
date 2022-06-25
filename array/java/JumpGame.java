public class JumpGame {
    int jumpGame(int []nums){
        if (nums.length <= 1){
            return 0;
        }
        int a = nums[0];
        int b = nums[0];

        int jumps = 0;

        for (int i = 1; i<nums.length; i++){
            a-=1;
            b-=1;
            b = Math.max(b,nums[i]);
            if (a == 0){
                jumps+=1;
                if (b == 0){
                    return -1;
                }
                a = b;
                if (i == nums.length-1){
                    return jumps;
                }
            }
        }
        return jumps + 1;
    }

    public static void main(String[] args){
        JumpGame jg = new JumpGame();
        int nums[] = new int[]{2,3,0,1,4};
        int jump = jg.jumpGame(nums);
        System.out.println("Jump: "+jump);
    }
}
