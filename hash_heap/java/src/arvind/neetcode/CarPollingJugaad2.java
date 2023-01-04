package arvind.neetcode;

public class CarPollingJugaad2 {

    public boolean carPooling(int[][] trips, int capacity) {
        int n = trips.length;
        int[] diff = new int[1001];

        for (int[] trip : trips) {
            diff[trip[1]] += trip[0];
            diff[trip[2]] -= trip[0];
        }

        int currCapacity = 0;

        for (int d : diff) {
            currCapacity += d;
            if (currCapacity > capacity) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CarPollingJugaad2 solution = new CarPollingJugaad2();
        int[][] trips = new int[][] {{2,1,5},{3,3,7}};
        int capacity = 4;
        boolean possible = solution.carPooling(trips, capacity);
        System.out.println(possible);
    }
}
