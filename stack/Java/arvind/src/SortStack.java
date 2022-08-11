import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class SortStack {

    public static void insertSorted(Stack<Integer> stack, int key) {
        // base case
        // stack is empty or the key is greater than stack
        if (stack.isEmpty() || key < stack.peek())
        {
            stack.push(key);
            return;
        }

        // we remove the top element
        int top = stack.pop();
        // recur for remaining elements
        insertSorted(stack, key);
        // we push back the top
        stack.push(top);
    }
    public static void sortStack(Stack<Integer> stack) {
        // base case: stack is empty
        if (stack.isEmpty()) {
            return;
        }
        // get the top element
        int top = stack.pop();
        // recur for the remaining elements in stack
        sortStack(stack);

        // insert the popped elements back into the sorted stack
        insertSorted(stack, top);
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, -2, 9, -7, 3);
        Stack<Integer> stack = new Stack<>();
        stack.addAll(list);

        System.out.println("Stack before sorting: "+ stack);
        sortStack(stack);
        System.out.println("Stack after sorting:  "+ stack);
    }
}