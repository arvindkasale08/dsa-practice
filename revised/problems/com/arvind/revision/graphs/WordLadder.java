package com.arvind.revision.graphs;

import java.util.*;
import java.util.stream.Collectors;

public class WordLadder {

    class Pair {
        private String word;
        private int level;

        public Pair(String word, int level) {
            this.word = word;
            this.level = level;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // convert the wordlist into a set
        Set<String> words = new HashSet<>(wordList);

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(beginWord, 1));
        words.remove(beginWord);

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            String currWord = pair.word;
            int currLevel = pair.level;
            if (endWord.equals(currWord)) {
                return currLevel;
            }
            Set<String> validWords = getValidWords(currWord, words);
            for (String validWord : validWords) {
                queue.offer(new Pair(validWord, currLevel + 1));
                words.remove(validWord);
            }
        }

        return 0;
    }

    private Set<String> getValidWords(String currWord, Set<String> words) {
        Set<String> validWords = new HashSet<>();
        for (String word : words) {
            int diff = 0;
            for (int i=0; i<currWord.length(); i++) {
                if (currWord.charAt(i) == word.charAt(i)) {
                    continue;
                } else {
                    diff++;
                }
            }
            if (diff == 1) {
                validWords.add(word);
            }
        }
        return validWords;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        WordLadder solution = new WordLadder();
        System.out.println(solution.ladderLength(beginWord, endWord, wordList));
    }
}
