package arvind.neetcode;

import java.util.Arrays;

public class ReplaceWithGreaterElementOnRight {

    public int[] replaceElements(int[] arr) {
        int maxSoFar = -1;

        for (int i= arr.length - 1; i>= 0; i--) {
            int temp = arr[i];
            arr[i] = maxSoFar;
            maxSoFar = Math.max(maxSoFar, temp);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {17, 18, 5, 4, 6, 1};
        ReplaceWithGreaterElementOnRight solution = new ReplaceWithGreaterElementOnRight();
        int[] res = solution.replaceElements(arr);
        System.out.println(Arrays.toString(res));
    }
}
