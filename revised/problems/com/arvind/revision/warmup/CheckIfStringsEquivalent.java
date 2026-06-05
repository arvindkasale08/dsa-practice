package com.arvind.revision.warmup;

public class CheckIfStringsEquivalent {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for (String word: word1) {
            sb1.append(word);
        }
        for (String word: word2) {
            sb2.append(word);
        }
        return sb1.toString().contentEquals(sb2);
    }

    public static void main(String[] args) {
        String[] words1 = new String[] {"ab", "c"};
        String[] words2 = new String[] {"a", "bc"};
        CheckIfStringsEquivalent solution = new CheckIfStringsEquivalent();
        System.out.println(solution.arrayStringsAreEqual(words1, words2));
    }
}
