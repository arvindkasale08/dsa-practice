package arvind.neetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PushDominoes {

    class Domino {
        char c;
        int i;

        public Domino(char c, int i) {
            this.c = c;
            this.i = i;
        }
    }

    public String push(String dominoes) {
        char[] ch = dominoes.toCharArray();
        Queue<Domino> queue = new LinkedList<>();

        for (int i=0; i<ch.length; i++) {
            if (ch[i] != '.') {
                queue.offer(new Domino(ch[i], i));
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Domino> affected = new ArrayList<>();
            for (int i=0; i<size; i++) {
                Domino d = queue.poll();
                if (d.c == 'L') {
                    if (d.i - 1 >= 0 && ch[d.i - 1] == '.') {
                        if (d.i - 2 >= 0) {
                            if (ch[d.i-2] != 'R') {
                                affected.add(new Domino('L', d.i-1));
                                //ch[d.i - 1] = 'L';
                                queue.offer(new Domino('L', d.i - 1));
                            }
                        } else {
                            affected.add(new Domino('L', d.i-1));
                            //ch[d.i - 1] = 'L';
                            queue.offer(new Domino('L', d.i - 1));
                        }
                    }
                } else if (d.c == 'R') {
                    if (d.i + 1 < ch.length && ch[d.i+1] == '.') {
                        if (d.i + 2 < ch.length) {
                            if (ch[d.i+2] != 'L') {
                                affected.add(new Domino('R', d.i+1));
                                //ch[d.i+1] = 'R';
                                queue.offer(new Domino('R', d.i+1));
                            }
                        } else {
                            affected.add(new Domino('R', d.i+1));
                            //ch[d.i+1] = 'R';
                            queue.offer(new Domino('R', d.i+1));
                        }
                    }
                }
            }
            for (Domino d : affected) {
                ch[d.i] = d.c;
            }
        }

        return new String(ch);
    }

    public static void main(String[] args) {
        PushDominoes solution = new PushDominoes();
        String dominoes = ".L.R...LR..L..";
        String str = solution.push(dominoes);
        System.out.println(str);
    }
}
