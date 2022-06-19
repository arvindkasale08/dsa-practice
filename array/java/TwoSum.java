import java.util.*;

public class TwoSum {

    int[] twoSumBruteForce(int arr[],  int target) {
        int[] answer = new int[2];
        for (int i = 0; i < (arr.length - 1); i++) {
            for (int j = (i + 1); j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    answer[0] = j;
                    answer[1] = i;
                    return answer;
                }
            }
        }
        return answer;
    }

    public int[] twoSumUsingHash(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        int[] answer = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                answer[0] = i;
                answer[1] = hashMap.get(target - nums[i]);
				break;
            }

            hashMap.put(nums[i], i);
        }
        return answer;
    }

    public static void main(String[] args){
        TwoSum ts = new TwoSum();
        int arr[] = {1,2,3,4,2};
        int target = 7;
        int ans[] = ts.twoSumBruteForce(arr, target);
        System.out.println("Two sum: "+ans[0]+" and "+ans[1]);

        ans = ts.twoSumUsingHash(arr, target);
        System.out.println("Two sum: "+ans[0]+" and "+ans[1]);

    }
}
