package arvind.neetcode;

import java.util.HashMap;
import java.util.Map;

public class MaximumNumberOfBalloons {

    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> bank = new HashMap<>();
        String ref = "balloon";
        for (int i=0; i<ref.length(); i++) {
            bank.put(ref.charAt(i), bank.getOrDefault(ref.charAt(i), 0)+1);
        }
        Map<Character, Integer> inputMap = new HashMap<>();
        for (int i=0; i<text.length(); i++) {
            if (bank.containsKey(text.charAt(i))) {
                inputMap.put(text.charAt(i), inputMap.getOrDefault(text.charAt(i), 0) + 1);
            }
        }
        if (inputMap.size() < 5) {
            return 0;
        }

        int count = Integer.MAX_VALUE;

        for (Map.Entry<Character, Integer> entry : bank.entrySet()) {
            int v = entry.getValue();
            int u = inputMap.get(entry.getKey());
            count = Math.min(count, u / v);
        }

        return count;
    }

    public static void main(String[] args) {
        String text = "loonbalxballpoon";
        MaximumNumberOfBalloons solution = new MaximumNumberOfBalloons();
        int result = solution.maxNumberOfBalloons(text);
        System.out.println(result);
    }
}
