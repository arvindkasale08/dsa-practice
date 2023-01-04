package arvind;

import java.util.HashMap;
import java.util.Map;

public class MinimumRoundsToCompleteAllTasks {

    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int task : tasks) {
            countMap.put(task, countMap.getOrDefault(task, 0) + 1);
        }

        int count = 0;
        for (int t : countMap.values()) {
            if (t == 1)
                return -1;

            count += t / 3;

            if (t % 3 != 0)
                count += 1;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] tasks = {2, 2, 3, 3, 2, 4, 4, 4, 4, 4};
        MinimumRoundsToCompleteAllTasks solution = new MinimumRoundsToCompleteAllTasks();
        int result = solution.minimumRounds(tasks);
        System.out.println(result);
    }
}
