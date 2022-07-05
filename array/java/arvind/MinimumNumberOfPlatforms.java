package arvind;

import java.util.Arrays;

public class MinimumNumberOfPlatforms {

    public int findTotalNeeded(int[] arrival, int[] departure) {
        // sort both arrays first
        Arrays.sort(arrival);
        Arrays.sort(departure);
        int i = 0, j = 0;
        int curPlatform = 0, maxPlatform = 0;

        while (i < arrival.length) {
            if (arrival[i] > departure[j]) {
                i++;
                j++;
            } else {
                curPlatform += 1;
                maxPlatform = Math.max(maxPlatform, curPlatform);
                i++;
            }
        }

        return maxPlatform;
    }

    public static void main(String[] args) {
        MinimumNumberOfPlatforms platforms = new MinimumNumberOfPlatforms();
        int[] arrival = new int[]{900, 940, 950, 1100, 1500, 1800};
        int[] departure = new int[]{910, 1200, 1120, 1130, 1900, 2000};
        int no = platforms.findTotalNeeded(arrival, departure);
        System.out.println("No of platforms needed "+ no);
    }
}
