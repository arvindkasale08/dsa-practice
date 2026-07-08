package com.arvind.revision.fastslow;

public class CircularArrayLoop {

    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            boolean forward = nums[i] > 0;
            int slow = i;
            int fast = i;

            while (isValid(nums, slow, forward) && isValid(nums, fast, forward)) {
                int nextFast = nextIndex(nums, fast);
                if (!isValid(nums, nextFast, forward)) break;

                slow = nextIndex(nums, slow);
                fast = nextIndex(nums, nextFast);

                if (slow == fast) {
                    if (slow == nextIndex(nums, slow)) {
                        break;
                    }
                    return true;
                }
            }

            int curr = i;
            while (!visited[curr] && isValid(nums, curr, forward)) {
                visited[curr] = true;
                curr = nextIndex(nums, curr);
            }
        }

        return false;
    }

    private boolean isValid(int[] nums, int index, boolean forward) {
        return (nums[index] > 0) == forward;
    }

    private int nextIndex(int[] nums, int index) {
        int n = nums.length;
        int next = (index + nums[index]) % n;
        if (next < 0) next += n;
        return next;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {2,-1,1,2,2};
        System.out.println(new CircularArrayLoop().circularArrayLoop(arr));
    }
}
