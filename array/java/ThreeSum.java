import java.util.*;

public class ThreeSum {
    int[] threeSumBruteForce(int arr[], int target){
        int[] answer = new int[3];
        int arrSize = arr.length;
        for (int i = 0; i < arrSize - 2; i++){
            for (int j = i + 1; j < arrSize - 1; j++){
                for (int k = j + 1; k < arrSize; k++){
                    if (arr[i] + arr[j] + arr[k] == target){
                        answer[0] = i;
                        answer[1] = j;
                        answer[2] = k;
                        return answer;
                    }
                }
            }
        }
        return answer;
    }

    int[] threeSumUsingHash(int arr[], int target){
        int[] answer = new int[3];
        int arrSize = arr.length;
        for (int i = 0; i < arrSize - 2; i++) {
            HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
            int currtarget = target - arr[i];
            for (int j = i + 1; j < arrSize; j++){
                if (hashMap.containsKey(currtarget - arr[j])){
                    answer[0] = i;
                    answer[1] = j;
                    answer[2] = hashMap.get(currtarget - arr[j]);
                    return answer;
                }
                hashMap.put(arr[j], j);
            }
        }
        return answer;
    }

    public static void main(String[] args){
        ThreeSum ts = new ThreeSum();
        int arr[] = {1,5,3,4,2};
        int target = 9;
        int ans[] = ts.threeSumBruteForce(arr, target);
        System.out.println("Three sum: "+ans[0]+", "+ans[1]+" and "+ans[2]);

        ans = ts.threeSumUsingHash(arr, target);
        System.out.println("Three sum: "+ans[0]+", "+ans[1]+" and "+ans[2]);

    }

}
