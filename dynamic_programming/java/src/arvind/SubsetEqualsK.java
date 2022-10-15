package arvind;

public class SubsetEqualsK {

    public boolean exists(int[] arr, int target) {
        int n = arr.length;
        Boolean[][] dp = new Boolean[n][target + 1];
        return exists(n-1, target, arr, dp);
    }

    private boolean exists(int index, int target, int[] arr, Boolean[][] dp) {
        if (target == 0)
            return true;
        if (index == 0)
            return arr[index] == target;
        if (dp[index][target] != null) return dp[index][target];

        boolean pick = false;
        if (target >= arr[index]) {
            pick = exists(index - 1, target - arr[index], arr, dp);
        }
        boolean dontpick = exists(index - 1, target, arr, dp);
        return dp[index][target] = pick || dontpick;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {6, 1, 2, 1};
        int target = 4;
        SubsetEqualsK solution = new SubsetEqualsK();
        boolean doesExist = solution.exists(arr, target);
        System.out.println(doesExist);
    }
}
