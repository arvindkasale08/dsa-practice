public class ElementWithLeftSideSmallerRightSideGreater {
    int[] reverse(int a[]){
        int n = a.length;

        int i, t;
        for (i = 0; i < n / 2; i++) {
            t = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = t;
        }
  
        return a;  
    }

    int findElement(int []nums, int n){
        int left[] = new int[nums.length];
        int right[] = new int[nums.length];
        
        left[0] = nums[0];
        right[0] = nums[nums.length-1];
        
        for (int i = 1; i<n; i++){
            if (nums[i]>left[i-1]){
                left[i] = nums[i];
            }else{
                left[i] = left[i-1];
            }
            if (nums[n-i-1]<right[i-1]){
                right[i] = nums[n-i-1];
            }else{
                right[i] = right[i-1];
            }
        }

        right = reverse(right);

        for (int i = 1; i<n-1; i++){
            if (nums[i] >= left[i] && nums[i] <= right[i]){
                return nums[i];
            }
        }

        return -1;
    }

    public static void main(String[] args){
        ElementWithLeftSideSmallerRightSideGreater e = new ElementWithLeftSideSmallerRightSideGreater();
        int nums[] = new int[]{4,2,5,7};
        int target = 4;
        int num = e.findElement(nums, target);
        System.out.println("Num: "+num);
    }
}
