package arvind;

import java.util.*;

public class MinimumGeneticMutation {

    class Pair {
        String s;
        int level;

        public Pair(String s, int level) {
            this.s = s;
            this.level = level;
        }
    }
    public int minMutations(String startGene, String endGene, String[] bank) {
        Set<String> bankset = new HashSet<>();
        for (String s : bank) {
            bankset.add(s);
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(startGene, 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            String s = pair.s;
            int level = pair.level;

            List<String> possible = getPossibleMutations(s, bankset);
            for (String poss : possible) {
                int nextLevel = level + 1;
                if (poss.equals(endGene)) {
                    return nextLevel;
                }
                queue.offer(new Pair(poss, nextLevel));
                bankset.remove(poss);
            }
        }

        return -1;
    }

    private List<String> getPossibleMutations(String s, Set<String> bank) {
        Character[] choices = new Character[] {'A', 'C', 'G', 'T'};
        List<String> possible = new ArrayList<>();
        for (int i=0; i<s.length(); i++) {
            StringBuilder sb = new StringBuilder(s);
            for (int j=0; j<choices.length; j++) {
                char x = choices[j];
                sb.setCharAt(i, x);
                if (bank.contains(sb.toString())) {
                    possible.add(sb.toString());
                }
            }
        }
        return possible;
    }

    public static void main(String[] args) {
        MinimumGeneticMutation solution = new MinimumGeneticMutation();
        String startGene = "AACCGGTT";
        String endGene = "AAACGGTA";
        String[] bank = new String[] {"AACCGGTA","AACCGCTA","AAACGGTA"};
        int count = solution.minMutations(startGene, endGene, bank);
        System.out.println(count);
    }
}
