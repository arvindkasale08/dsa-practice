package arvind.neetcode;

import java.util.Arrays;
import java.util.Comparator;

public class CarPoolingJugaad {

    class Trip {
        int from;
        int to;
        int weight;

        public Trip(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public boolean carPooling(int[][] trips, int capacity) {
        int n = trips.length;
        Trip[] getOn = new Trip[n];
        Trip[] getOff = new Trip[n];
        for (int i=0; i< n; i++) {
            int[] trip = trips[i];
            getOn[i] = new Trip(trip[1], trip[2], trip[0]);
            getOff[i] = new Trip(trip[1], trip[2], trip[0]);
        }
        Arrays.sort(getOn, Comparator.comparingInt(value -> value.from));
        Arrays.sort(getOff, Comparator.comparingInt(value -> value.to));

        int i = 0;
        int j = 0;
        int currentcapacity = 0;
        while (i < n) {
            if (getOn[i].from < getOff[j].to) {
                currentcapacity += getOn[i].weight;
                i++;
            } else {
                currentcapacity -= getOff[j].weight;
                j++;
            }
            if (currentcapacity > capacity) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CarPoolingJugaad solution = new CarPoolingJugaad();
        int[][] trips = new int[][] {{2,1,5},{3,3,7}};
        int capacity = 5;
        boolean possible = solution.carPooling(trips, capacity);
        System.out.println(possible);
    }
}
