package com.arvind.revision.warmup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShortestWordDistance {

    public int shortestDistanceOption2(String[] words, String word1, String word2) {
        int idx1 = -1;
        int idx2 = -1;
        int minDistance = Integer.MAX_VALUE;

        for (int i=0; i< words.length; i++) {
            if (word1.equals(words[i])) {
                idx1 = i;
            } else if (word2.equals(words[i])) {
                idx2 = i;
            }
            if (idx1 != -1 && idx2 != -1) {
                minDistance = Math.min(minDistance, Math.abs(idx1-idx2));
            }
        }

        return minDistance;
    }

    public int shortestDistance(String[] words, String word1, String word2) {
        // TODO: Write your code here
        HashMap<String, List<Integer>> bank = new HashMap<>();

        for (int i=0; i< words.length; i++) {
            String word = words[i];
            if (!bank.containsKey(word)) {
                bank.put(word, new ArrayList<>());
            }
            bank.get(word).add(i);
        }

        List<Integer> word1IDX = bank.get(word1);
        List<Integer> word2IDX = bank.get(word2);
        int min = Integer.MAX_VALUE;
        for (int i: word1IDX) {
            for (int j: word2IDX) {
                min = Math.min(min, Math.abs(i-j));
            }
        }

        return min;
    }

    public static void main(String[] args) {
        String[] words = new String[] {"the","quick","brown","fox","jumps","over","the","lazy","dog"};
        String word1= "fox";
        String word2= "dog";
        ShortestWordDistance distance = new ShortestWordDistance();
        System.out.println(distance.shortestDistanceOption2(words, word1, word2));
    }
}
