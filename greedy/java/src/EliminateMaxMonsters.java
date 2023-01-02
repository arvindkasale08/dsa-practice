import java.util.Arrays;

public class EliminateMaxMonsters {

    public int eliminateMonsters(int[] dist, int[] speed) {
        int n = dist.length;
        int[] turns = new int[n];
        for (int i=0; i< n; i++) {
            turns[i] = (dist[i] + speed[i] - 1) / speed[i];
        }
        Arrays.sort(turns);

        int fired = 0;
        int count = 0;
        for (int i=0; i< n; i++) {
            if (fired < turns[i]) {
                count++;
                fired++;
            } else {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        EliminateMaxMonsters solution = new EliminateMaxMonsters();
        int[] dist = new int[] {3, 2, 4};
        int[] speed = new int[] {5, 3, 2};
        int monsters = solution.eliminateMonsters(dist, speed);
        System.out.println(monsters);
    }
}
