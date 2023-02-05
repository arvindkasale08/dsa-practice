import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();
        return isHappy(n, visited);
    }

    private boolean isHappy(int n, Set<Integer> visited) {
        if (n == 1 || n == -1) {
            return true;
        }
        if (visited.contains(n)) {
            return false;
        }

        visited.add(n);
        int output = findSquare(n);
        return isHappy(output, visited);
    }

    private int findSquare(int n) {
        int output = 0;

        while (n > 0) {
            int digit = n % 10;
            output += digit * digit;
            n /= 10;
        }

        return output;
    }

    public static void main(String[] args) {
        int n = 2;
        HappyNumber solution = new HappyNumber();
        boolean result = solution.isHappy(n);
        System.out.println(result);
    }
}
