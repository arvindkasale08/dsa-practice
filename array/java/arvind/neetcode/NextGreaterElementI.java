package arvind.neetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class NextGreaterElementI {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> bank = new HashMap<>();
        for (int i=0; i<nums1.length; i++) {
            bank.put(nums1[i], i);
        }
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<nums2.length; i++) {

            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                int popped = stack.pop();
                nums1[bank.get(popped)] = nums2[i];
            }

            if (bank.containsKey(nums2[i])) {
                stack.push(nums2[i]);
            }
        }

        while (!stack.isEmpty()) {
            int popped = stack.pop();
            nums1[bank.get(popped)] = -1;
        }

        return nums1;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {2, 1, 3, 4};
        NextGreaterElementI solution = new NextGreaterElementI();
        int[] result = solution.nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }
}
