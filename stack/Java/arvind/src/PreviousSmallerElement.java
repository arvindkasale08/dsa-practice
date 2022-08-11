import java.util.Stack;

public class PreviousSmallerElement {


    public int[] solve(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] pse = new int[n];
        for (int i=0; i<n; i++) {
            if (stack.isEmpty()) {
                pse[i] = -1;
                stack.push(arr[i]);
            } else {
                while (!stack.isEmpty() && arr[i] <= stack.peek()) {
                    stack.pop();
                }
                pse[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(arr[i]);
            }
        }
        return pse;
    }
    public void display(int[] arr) {
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 4, 5, 2, 10, 8};

        PreviousSmallerElement solution = new PreviousSmallerElement();
        solution.display(arr);
        int[] result = solution.solve(arr);
        solution.display(result);
    }
}
