import java.util.*;

public class NextGreaterElement {
    public static int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() < num)
                map.put(stack.pop(), num);
            stack.push(num);
        }
        for (int i = 0; i < findNums.length; i++)
            findNums[i] = map.getOrDefault(findNums[i], -1);
        return findNums;
    }

    public static void main(String[] args) {
        int [] res = {2,4};
        int [] res1 = {1,2,3,4};
        int [] re = nextGreaterElement(res, res1);
        System.out.println("Res: " + Arrays.toString(re));
    }
}
