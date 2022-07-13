import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class KokoEatingBananas {

    public int rate(int[] piles, int hour) {
        int l =1, h = Arrays.stream(piles).max().getAsInt();
        int res = h;

        while (h > l) {
            int mid = (l + h) / 2;

            int rate = eat(piles, mid);
            if (rate <= hour) {
                res = Math.min(res, mid);
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

    public int eat(int[] piles, int val) {
        int rate = 0;
        int n = piles.length;
        for (int i=0; i<n; i++) {
            rate += piles[i] / val;
            if (piles[i] % val != 0)
                rate += 1;
        }
        return rate;
    }

    public static void main(String[] args) {
        KokoEatingBananas solution = new KokoEatingBananas();
        /*int[] piles = new int[] {3,6,7,11};
        int h = 8;*/
        int[] piles = new int[] {30, 11, 23, 4, 20};
        int h = 5;
        h = 6;
        int rate = solution.rate(piles, h);
        System.out.println("Eating rate is "+ rate);
    }
}
