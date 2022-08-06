import java.util.Stack;

public class NextGreaterElement {

    public int[] findNGE(int[] arr) {
        int n = arr.length;
        int[] nge = new int[n];
        Stack<Integer> stack = new Stack<>();

        // run this twice to handle circular array
        for (int i= (2*n-1); i>0; i--) {
            int index = i % n;
            while (!stack.isEmpty() && stack.peek() <= arr[index]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nge[index] = -1;
            } else {
                nge[index] = stack.peek();
            }
            stack.push(arr[index]);
        }
        return nge;
    }

    public void display(int[] arr) {
        for(int i: arr) {
            System.out.print(i+" ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        int[] arr = {3, 10, 4, 2, 1, 2, 6, 1, 7, 2, 9};
        NextGreaterElement solution = new NextGreaterElement();
        int[] result = solution.findNGE(arr);
        System.out.println("Input is ");
        solution.display(arr);
        System.out.println("Output is ");
        solution.display(result);
    }
}
