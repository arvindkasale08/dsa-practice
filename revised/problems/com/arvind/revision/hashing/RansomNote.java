package com.arvind.revision.hashing;

public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        // ToDo: Write Your Code Here.
        int[] bank = new int[26];
        for (char c: magazine.toCharArray()) {
            bank[c-'a'] +=1;
        }
        for (char c: ransomNote.toCharArray()) {
            bank[c-'a'] -=1;
        }

        for (int i: bank) {
            if (i < 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String note = "hello";
        String magazine = "helloworld";
        RansomNote solution = new RansomNote();
        System.out.println(solution.canConstruct(note, magazine));
    }
}
