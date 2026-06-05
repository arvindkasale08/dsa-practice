package com.arvind.revision.warmup;

public class Pangram {

    public boolean checkIfPangram(String sentence) {
        // TODO: Write your code here
        int[] res = new int[26];

        for (char c : sentence.toCharArray()) {
            c = Character.toLowerCase(c);
            int idx = (int) c - 97;
            if (idx >=0 && idx < 26) {
                res[idx]++;
            }
        }

        for (int r: res) {
            if (r == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "This is not a pangram";
        String s2 = "TheQuickBrownFoxJumpsOverTheLazyDog";

        Pangram p = new Pangram();
        System.out.println(p.checkIfPangram(s));
        System.out.println(p.checkIfPangram(s2));

    }
}
